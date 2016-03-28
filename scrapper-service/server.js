var express=require('express'),
    path=require('path'),
    request=require('request'),
    csv = require('csv-write-stream'),
    fs=require('fs'),
    parser=require('./lib/parser'),
    config=require('./lib/config'),
    writer = csv(),
    app=express();


app.use(express.static(path.join(__dirname,'public')));

var params = {
  q:"SELECT * FROM html WHERE url='"+config.TV+"' and xpath='"+config.XPATH+"'",
  format:"json",
  diagnostics:true,
  callback:""
};

app.get('/api/v1/parse',function(req,res){
  var writer = csv()
  writer.pipe(fs.createWriteStream('csv/schedule.csv'))
  request({url:config.URL, qs:params}, function(err, response, body) {
    if(err){
      res.status(404).send({
        "code":404,
        "message":"Something went wrong"
      });
    }
    body=JSON.parse(body);
    var data=body.query.results.div;
    data.forEach(function(item){
      var show=parser.parseItem(item);
      writer.write(show);
    });
    writer.end();
    res.status(201).send({
      "code":201,
      "message":"CSV successfuly created"
    });
  });
});

app.listen(3000,function(){
  console.log('Server listneing ...');
});

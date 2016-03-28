angular.module('scrapper',[])
  .controller('MainCtrl',function($http,$scope){
    $scope.shows=[];
    var website="http://www.mbc.net/en/mbc2/schedule.channel-MBC-2---Middle-East.programtype-all.html";
    var query="SELECT * FROM html WHERE url='"+website+"' and xpath='//div[@class=\"text-box-section\"]/div[@class=\"archttl\"]'&format=json&diagnostics=true&callback=";
    var url="https://query.yahooapis.com/v1/public/yql?q="+query;
    $http.get(url)
      .then(function(data){
        $scope.data=data.data.query.results.div;
        $scope.data.forEach(function(item){
          var title=item.h3;
          if(item.h3.a!=undefined && item.h3.a.content)
            title=item.h3.a.content;
          if(item.div.img!=undefined)
          var image=item.div.img.src;
          if(item.div.a!=undefined && item.div.a.img.src){
            image=item.div.a.img.src;
          }

          var description="None description available";
          description=item.p;
          if(item.p.content)
            description=item.p.content;
          $scope.shows.push({
            title:title.trim(),
            image:image.trim(),
            startKSA:item.div.ul.li[1].trim(),
            startEG:item.div.ul.li[2].trim(),
            description:description.trim()
          })

        });
        console.log($scope.shows.length);
      })
  });

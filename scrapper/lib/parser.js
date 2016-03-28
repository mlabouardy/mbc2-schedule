
module.exports={
  parseItem:function(item){
    var title=item.h3;
    if(item.h3.a!=undefined && item.h3.a.content)
    title=item.h3.a.content;
    if(item.div.img!=undefined)
    var image="http://www.mbc.net/"+item.div.img.src;
    if(item.div.a!=undefined && item.div.a.img.src){
      image="http://www.mbc.net/"+item.div.a.img.src;
    }

    var description="None description available";
    description=item.p;
    if(item.p.content)
    description=item.p.content;

    return {
      TITLE:title.trim(),
      KSA:item.div.ul.li[1].trim(),
      EG:item.div.ul.li[2].trim(),
      IMAGE:image.trim(),
      DESCRIPTION:description.trim()
    };
  }
}

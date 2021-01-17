$(function () {

    // console.log(indexProductList);

/* 插入图片的js实现方式 现在已经被 thymeleaf 替代

    // 单独的js文件无法获取 model 的值，必须要从html中定义全局变量传入js文件
    console.log(indexProductList);
    if (indexProductList == null) {
        return;
    }
    var jsonStr = indexProductList.replace(new RegExp('&quot;', "gm"), '"');
    // console.log(jsonStr);
    var jsonObject = JSON.parse(jsonStr);
    // console.log(jsonObject);
    for (var k in jsonObject) {  //遍历jsonObject 对象的每个key/value对,k为key
        // console.log(k + " " + jsonObject[k].name);
        $("#product_ul").append(
            "<li data-plugin=\"appear\" data-animate=\"slide-bottom\" class=\"animation-slide-bottom\">\n" +
            "   <a href=\"/product/" + jsonObject[k].product_id + "\">\n" +
            "       <p>\n" +
            "           <img src=\"" + jsonObject[k].picture + "\" alt=\"" + jsonObject[k].name + "\" style=\"display: inline;\">\n" +
            "       </p>\n" +
            "       <span>" + jsonObject[k].name + "</span>\n" +
            "   </a>\n" +
            "</li>"
        );
    }
*/

});
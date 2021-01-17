$(function () {
    /* 插入图片的js实现方式 现在已经被 thymeleaf 替代

        // 单独的js文件无法获取 model 的值，必须要从html中定义全局变量传入js文件
        console.log(indexProductList);
        if (indexProductList == null){
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


    /* 分页按钮组的js实现方式 现在已经被 thymeleaf 替代

                // 分页相关的参数
                var pageNum = parseInt("[[${pageNum}]]");
                var pageSize = parseInt("[[${pageSize}]]");
                var totalPages = parseInt("[[${totalPages}]]");
                var totalSize = parseInt("[[${totalSize}]]");

                // 如果没有分页则不添加页码
                if (isNaN(pageNum)) {
                    return;
                }

                // 判断是否第一页
                if (pageNum > 1) {
                    // 添加页码中的 "上一页"
                    // $("<li/>").append($("<a/>").html("上一页")).appendTo($(".pagination"));
                    var a_prev = "<a href=\"/product/all/" + (pageNum - 1) + "/8\">上一页</a>";
                    $("<li/>").append(a_prev).appendTo($(".pagination"));
                } else {
                    var a_prev = "<span>上一页</span>";
                    $("<li/>").append(a_prev).appendTo($(".pagination"));
                }

                // 添加分页中的 页号
                for (var i = 1; i <= totalPages; i++) {
                    // $("<li/>").append($("<a/>").html(i)).appendTo($(".pagination"));
                    var a_i = "<a href=\"/product/all/" + i + "/8\">" + i + "</a>";
                    $("<li/>").append(a_i).appendTo($(".pagination"));

                }

                // 判断是否最后一页
                if (pageNum < totalPages) {
                    // 添加页码中的 "下一页"
                    // $("<li/>").append($("<a/>").html("下一页")).appendTo($(".pagination"));
                    var a_next = "<a href=\"/product/all/" + (pageNum + 1) + "/8\">下一页</a>";
                    $("<li/>").append(a_next).appendTo($(".pagination"));
                } else {
                    var a_next = "<span>下一页</span>";
                    $("<li/>").append(a_next).appendTo($(".pagination"));
                }
    */

});
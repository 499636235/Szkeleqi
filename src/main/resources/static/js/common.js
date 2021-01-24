$(function () {

    /* 导航栏根据当前页面变更选中状态的的js实现 现在已经被 thymeleaf 替代

        //html文件的路径名，如："/index/first"
        var pathname = window.location.pathname;
        console.log(pathname);

        // 如果是根目录"/"
        if (pathname == "/index") {
            // 激活主页
            $("#index").addClass("active");
            console.log("欢迎访问苏州科乐奇工艺品有限公司的首页！");
            return;
        }

        //第二个斜杠"/"的位置，如："/index/first" 获得的位置是6
        var secondSlashIndex = pathname.indexOf("/", 1);
        // console.log(secondSlashIndex);

        //如果有第二个斜杠
        if (secondSlashIndex > 0) {
            // 使用两个斜杠中间的字符作为pathname
            pathname = pathname.substr(1, secondSlashIndex - 1);
        } else {
            //否则使用斜杠后面的字符作为pathname
            pathname = pathname.substr(1, pathname.length - 1);
        }
        // console.log(pathname);
        // 激活相应的导航栏标签
        $("#" + pathname).addClass("active");
    */


});

function diyPageSize() {
    // $("#diya").attr('href', "/product/all/" + "1" + "/" + $("#diyPageSize").val());

    // url = path + "picture_list_ul/" + "1" + "/" + $("#diyPageSize").val();
    // $("#picture_list_div").load(url);
    // url = path + "pager_ul/" + "1" + "/" + $("#diyPageSize").val();
    // $("#pager_div").load(url);

    url = path + "picbox_div/" + "1" + "/" + $("#diyPageSize").val();
    $("#picbox_div").load(url);
}

function test() {
    /*

        url="/product/all/ajax/1/8";
        $("#picture_list_div").load(url);
    */

    /*$.post(
        "/product/all/ajax/1/8",
        "",
        function (data) {
            console.log(data);
            $("#picture_list_div").html(data);
        }
    )*/
}

function page(i,pagesize) {

    // console.log(i);
    // console.log(pagesize);
    // url = path + "picture_list_ul/" + i + "/" + pagesize;
    // $("#picture_list_div").load(url);
    // url = path + "pager_ul/" + i + "/" + pagesize;
    // $("#pager_div").load(url);

    url = path + "picbox_div/" + i + "/" + pagesize;
    $("#picbox_div").load(url);

}
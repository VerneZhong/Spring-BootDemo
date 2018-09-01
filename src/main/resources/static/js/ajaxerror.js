$.ajax({
    url : "/SpringBoot/err/getAjaxError",
    type : "POST",
    async : false,
    success : function (data) {
        if (data.code ==  200 && data.msg == "ok") {
            alert("请求成功");
            console.log(data);
        } else {
            console.log("异常堆栈:"+data.data);
            alert("发生异常：" + data.msg);
        }
    },
    error : function (response, ajaxOptions, throwError) {
        alert(ajaxOptions);
        console.log(response);
        console.log(ajaxOptions);
        console.log(throwError);
    }
});
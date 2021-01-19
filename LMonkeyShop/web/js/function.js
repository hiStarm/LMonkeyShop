function change(imge) {
    imge.src="getCode?"+new Date().getTime();
}
var flag=true;
function CheckItem(obj) {
    var msgBox=$(obj).next('span');
    switch ($(obj).attr('name')) {
        case "userName":
            if ($(obj).val()==""){
                msgBox.html('用户名不能为空');
                msgBox.addClass('_error');
                flag=false;
            }else{
                var url="userNameCheckServlet?name="+encodeURI($(obj).val())+"&"+new Date().getTime();

                $.get(url,{},function (data) {
                    if (data=="false"){
                        msgBox.html('用户名不可用');
                        msgBox.addClass('_error');
                        flag=false;

                    }else{
                        msgBox.removeClass('_error');
                        flag=true;

                    }
                });
            }
            break;
        case "name":
            if ($(obj).val()==""){
                msgBox.html('姓名不能为空');
                msgBox.addClass('_error');
                flag=false;

            }else {
                flag=true;

            }
            break;
        case "passWord":
            if ($(obj).val()==""){
                msgBox.html('密码不能为空');
                msgBox.addClass('_error');
                flag=false;

            }else {
                flag=true;

            }
            break;
        case "rePassWord":
            if ($(obj).val()==""){
                msgBox.html('确认密码不能为空');
                msgBox.addClass('_error');
                flag=false;

            }else if ($(obj).val()!=$('input[name=passWord]').val()){
                msgBox.html('密码不一致');
                msgBox.addClass('_error');
                flag=false;

            }else {
                flag=true;
            }
            break;
        case "veryCode":
            var show=$(obj).next().next();
            if ($(obj).val()==""){
                show.html('验证码不能为空');
                show.addClass('_error');
                flag=false;

            }else{
                var url="userCodeCheckServlet?num="+encodeURI($(obj).val())+"&"+new Date().getTime();

                $.get(url,{},function (numdata) {
                    if (numdata=="false"){
                        show.html('验证码输入错误');
                        show.addClass('_error');
                        flag=false;

                    }else{
                        show.removeClass('_error');
                        flag=true;

                    }
                });
            }
            break;
    }
}
function FocusItem(obj) {
    if ($(obj).attr('name')=='veryCode'){
        $(obj).next().next().html('').removeClass('_error');
    }else {
        $(obj).next('span').html('').removeClass('_error');
    }
}

function CheckForm(fom) {
    var input = $("input[onblur]");
    $(input).each(function (index) {
        CheckItem(input[index]);
    });
    return flag;
}
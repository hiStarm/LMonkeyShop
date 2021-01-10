function change(imge) {
    imge.src="getCode?"+new Date().getTime();
}
function CheckItem(obj) {
    var msgBox=$(obj).next('span');
    switch ($(obj).attr('name')) {
        case "userName":
            if (obj.value()==""){
                msgBox.html('用户名不能为空');
                msgBox.addClass('_error');
            }
            break;
        case "name":
            if (obj.value()==""){
                msgBox.html('姓名不能为空');
                msgBox.addClass('_error');
            }
            break;
        case "passWord":
            if (obj.value()==""){
                msgBox.html('密码不能为空');
                msgBox.addClass('_error');
            }
            break;
        case "rePassWord":
            if (obj.value()==""){
                msgBox.html('确认密码不能为空');
                msgBox.addClass('_error');
            }else if ($(obj).val()!=$('input[name=passWord]').val()){
                msgBox.html('密码不一致');
                msgBox.addClass('_error');
            }
            break;
        case "veryCode":
            if (obj.value()==""){
                msgBox.html('验证码不能为空');
                msgBox.addClass('_error');
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
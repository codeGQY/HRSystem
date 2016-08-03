/**
 * Created by admin on 2016/8/2.
 */
function check() {
    if(form1.userName.value =="")
    {
        alert("请输入用户名！");
        form1.userName.focus();
        return;
    }else
    if (form1.password.value =="")
    {
        alert("请输入密码！");
        form1.password.focus();
        return;
    }
else
    {
        form1.submit();
    }
}
/**
 * Created by Administrator on 2016/8/12.
 */
//用户获取cookie中的微信ID
function getCookie(cookie_name){
    //test
//        return false;
//        return '123';
    return 'oF3PcsnsrMiJzEwalZZbAfWQpxCI';

    var alllCookie=document.cookie;
    var cookie_pos=alllCookie.indexOf(cookie_name);
    if(cookie_pos!=-1){
        cookie_pos+=cookie_name+1;
        var cookie_end=alllCookie.indexOf(";",cookie_pos);
        if(cookie_end==-1){
            cookie_end=alllCookie.length;
        }
        var value=alllCookie.substring(cookie_pos,cookie_end);
        return value;
    }
    return false;
}
//判断用户有没有openid和数据库中有没有记录
function judgeCookie(child_name) {
    var cookie_id = getCookie("openid");
    if (!cookie_id) {  //没有cookie，第一次访问，跳转值注册页面
        var url = "";
        //这个URL 是向open.weixin.qq.com发送授权请求，映射到后端的接口，获得openid，并设置到cookie中，响应
        /*
         * 处理授权的操作
         * window.location.href =url;
         */
        window.location.href = '../../userMessage.html';
    } else {//有cookie的话
        $.ajax({//查询数据库请求 看有没有用户有没有填写注册信息
            type: "POST",
            //test
            url: "../starsea/queryOpenId",  //查询数据库接口  测试接口
            dataType: "json",
            data: {
                openid: cookie_id
            },
            async:false,
            success: function (data) {
                //如果有记录，ServiceResult的code为200，反之为500 返回的json为{code,{code,msg}}
                if (data['msg']['code'] == 500) { //没有记录，跳转至注册界面
                    window.location.href = '../../userMessage.html';
                } else {//有记录 进行后面的操作
                    child_name.name= data['msg']['msg'];
                    //child_name= data['msg']['msg']['name'];//获取 返回的json数据中 孩子的名字
                }
            }
        });
    }
}
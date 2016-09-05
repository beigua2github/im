/**
 * Created by Administrator on 2016/9/1.
 */
//获取openid
function getOpenid(){
    var openid = getCookie("openid");
    if (!openid) {
        window.location.href ="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx9b08b42b34258af7&redirect_uri=http%3A%2F%2Fwww.elastictime.cn%2Fstarsea%2Fopenid&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
    }
    return openid;
}

$(document).ready(function () {
    var children=[];
    var openid=getOpenid();
    var flag = getCookie("p_t");//flag标志角色  p家长 t老师
    if(!flag) {//第一次
        //获取角色信息
        $.ajax({
            type: "GET",
            url: "../starsea/user/getUserByOpenId",
            dataType: "json",
            data: {
                openId: openid
            },
            async: false,
            success: function (data) {
                //var flag=data['msg']['msg']['power'];
                var flag="p";
                if(flag) {
                    //将角色设置到cookie
                    setCookie("p_t",flag,3000);
                }else{
                    //alert("没有权限");
                    //WeixinJSBridge.invoke('closeWindow',{},function(res){});
                    window.location.href='../../userMessage.html';
                }
            }
        });
    }
    if (flag =="p") {//家长
        $('.fourPoint').css('display','block');
        $('.children').css('display','none');

        $('.p1').click(function(){
            window.location.href="../../positiveTest.html";
        });
        $('.p2').click(function(){
            window.location.href="../../watchForm.html";
        });
        $('.p3').click(function(){
            window.location.href="../../zhexiantu.html";
        });
        $('.p4').click(function(){
            window.location.href="../../parentLog.html";
        });
    }
    //老师
    else{
        $('.fourPoint').css('display','none');
        $('.children').css('display','block');
        //获取老师管理的孩子openid
        $.ajax({
            type: "GET",
            url: "../starsea/",
            dataType: "json",
            data: {
                openId: openid
            },
            success: function (data) {
                var content=data['msg']['msg'];//获取孩子信息  生成一个数组 split content=['dcdscuid','小红','dcwcww','小明']；
                var children_num=0;
                for(var i=0;i<content.length;i+=2) {
                    children[children_num]={openid:"",name:""};
                    children[children_num].openid=content[i];
                    children[children_num].name=content[i+1];
                    children_num+=1;
                }
                //children=[{openid:"cdscsdcsd",name:"小明"},{openid:"cdscvdsvsdd",name:"小红"}];

            }
        });
    }
});
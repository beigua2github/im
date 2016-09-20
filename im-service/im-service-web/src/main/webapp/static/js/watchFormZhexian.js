/**
 * Created by Administrator on 2016/9/17.
 */
//每日观察  5个维度的都显示
//setCookie("openid","o45t9wZx7eQo5VIB4nTY_76TCW4w",100);
var point=["自主力","专注力","意志力","情绪力","人际力"];
var score=new Array();
var date=new Array();
var role=getCookie("role");
var openid="";
if(role=="p"){
    openid=getCookie("openid");
}else{
    openid=getCookie("childOpenid");
}

function week(){
    $.ajax({
        type: "GET",
        url: "/starsea/watch/queryLastWatchFormByOpenIdWeek",
        data: {
            openId:openid
        },
        dataType: "json",
        async:false,
        success: function (data) { //成功的处理函数
            var content = data['msg']['msg'];
            for(var i=0;i<7;i++) {
                score[i]=new Array();
                score[i]=content.score[i];
            }
            date=content.date;
            //alert(score);
            //alert(date);
            $(".ts_mask").fadeOut(1000);
        }
    });
}
function month(){
    $.ajax({
        type: "GET",
        url: "/starsea/watch/queryLastWatchFormByOpenIdMonth",
        data: {
            openId:openid
        },
        dataType: "json",
        async:false,
        success: function (data) { //成功的处理函数
            var content = data['msg']['msg'];
            for(var i=0;i<30;i++) {
                score[i]=new Array();
                score[i]=content.score_m[i];
            }
            date=content.date_m;
            //alert(score);
            //alert(date);
            $(".ts_mask").fadeOut(1000);
        }
    });
}
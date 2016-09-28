/**
 * Created by Administrator on 2016/9/20.
 */
//全班学生一周记录
var zizhu_wt=new Array();//用于存储孩子的自主力
var zhuanzhu_wt=new Array();//专注力
var yizhi_wt=new Array();//意志力
var qingxu_wt=new Array();//情绪力
var renji_wt=new Array();//人际
var date_w=new Array();//日期
var childrenName_t=new Array();//孩子姓名
//全校学生一周记录
var zizhu_wa=new Array();//用于存储孩子的自主力
var zhuanzhu_wa=new Array();//专注力
var yizhi_wa=new Array();//意志力
var qingxu_wa=new Array();//情绪力
var renji_wa=new Array();//人际
var childrenName_a=new Array();//孩子姓名
//全班学生一月记录
var zizhu_mt=new Array();//用于存储孩子的自主力
var zhuanzhu_mt=new Array();//专注力
var yizhi_mt=new Array();//意志力
var qingxu_mt=new Array();//情绪力
var renji_mt=new Array();//人际
var date_m=new Array();//日期
//全校学生一月记录
var zizhu_ma=new Array();//用于存储孩子的自主力
var zhuanzhu_ma=new Array();//专注力
var yizhi_ma=new Array();//意志力
var qingxu_ma=new Array();//情绪力
var renji_ma=new Array();//人际

var openid=getCookie("openid");
var select=getCookie("ejia_table"); //辨别 全班 还是 全校 class班 school校

function allWeek(){
    if(select=="class"){//全班一周
        $.ajax({
            type: "GET",
            url: "/starsea/watch/queryOneTeacherAllChildrenByOpenIdWeek",
            data: {
                openId:openid
            },
            dataType: "json",
            async:false,
            success: function (data) { //成功的处理函数
                var content = data['msg']['msg'];
                date_w=content.date;
                childrenName_t=content.childrenName;
                zizhu_wt=content.zizhu;
                zhuanzhu_wt=content.zhuanzhu;
                yizhi_wt=content.yizhi;
                qingxu_wt=content.qingxu;
                renji_wt=content.renji;
            }
        });
    }else if(select=="school"){
        $.ajax({
            type: "GET",
            url: "/starsea/watch/queryAllChildrenByOpenIdWeek",
            data: {
                openId:openid
            },
            dataType: "json",
            async:false,
            success: function (data) { //成功的处理函数
                var content = data['msg']['msg'];
                date_w=content.date;
                childrenName_a=content.childrenName;
                zizhu_wa=content.zizhu;
                zhuanzhu_wa=content.zhuanzhu;
                yizhi_wa=content.yizhi;
                qingxu_wa=content.qingxu;
                renji_wa=content.renji;
            }
        });
    }
}

function allMonth(){
    if(select=="class"){//全班一月
        $.ajax({
            type: "GET",
            url: "/starsea/watch/queryOneTeacherAllChildrenByOpenIdMonth",
            data: {
                openId:openid
            },
            dataType: "json",
            async:false,
            success: function (data) { //成功的处理函数
                var content = data['msg']['msg'];
                date_m=content.date;
                childrenName_t=content.childrenName;
                zizhu_mt=content.zizhu;
                zhuanzhu_mt=content.zhuanzhu;
                yizhi_mt=content.yizhi;
                qingxu_mt=content.qingxu;
                renji_mt=content.renji;
            }
        });
    }else if(select=="school"){
        $.ajax({
            type: "GET",
            url: "/starsea/watch/queryAllChildrenByOpenIdMonth",
            data: {
                openId:openid
            },
            dataType: "json",
            async:false,
            success: function (data) { //成功的处理函数
                var content = data['msg']['msg'];
                date_m=content.date;
                childrenName_a=content.childrenName;
                zizhu_ma=content.zizhu;
                zhuanzhu_ma=content.zhuanzhu;
                yizhi_ma=content.yizhi;
                qingxu_ma=content.qingxu;
                renji_ma=content.renji;
            }
        });
    }
}
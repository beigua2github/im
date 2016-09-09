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
    //删除cookie的方法， 第三个参数设置为负的
    //setCookie("openid","o45t9wZx7eQo5VIB4nTY_76TCW4w",3000);
    //setCookie("role",'1',-1);
    var openid=getOpenid();
    var role = getCookie("role");//p为家长 t为老师
    //alert(role);
    //setCookie("role","p",3000);
    if(!role) {//第一次
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
                var f=data['msg']['msg']['role'];
                //var f="t";
                if(f=="老师") {
                    //将角色设置到cookie
                    setCookie("role","t",3000);
                    role="t";
                }else if(f=="家长"){
                    setCookie("role","p",3000);
                    role="p";
                }else{
                    alert("没有权限");
                    //WeixinJSBridge.invoke('closeWindow',{},function(res){});
                    //window.location.href='../../userMessage.html';

                }
            }
        });
    }
    //alert(role);
    if (role =="p") {//家长
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
            window.location.href="../../newFind.html";
        });
    }
    //老师
    else if(role=='t'){
        var children=[];
        $('.fourPoint').css('display','none');
        $('.children').css('display','block');

        //children=[{openid:"o45t9wZx7eQo5VIB4nTY_76TCW4w",name:"小明",school:"华师",class:"一年级"},
        //    {openid:"cdscvdsvsdd",name:"小红",school:"华师aaaaaaa",class:"二年级aaaaa"},
        //    {openid:"cevrvrvr",name:"小白",school:"华师",class:"三年级"},
        //    {openid:"cdscvvfdsdd",name:"小蓝",school:"华师",class:"四年级"},
        //    {openid:"cdsacsdsdd",name:"小绿",school:"华师",class:"五年级"},
        //    {openid:"vregthvsdd",name:"小黑",school:"华师",class:"六年级"},
        //    {openid:"pioiysvsdd",name:"小紫",school:"华师",class:"七年级"}];

        //获取老师管理的孩子openid
        $.ajax({
            type: "GET",
            url: "../starsea/user/getChildrenUserByOpenId",
            dataType: "json",
            data: {
                openId: openid
            },
            async:false,
            success: function (data) {
                var content=data['msg']['msg'];//获取孩子信息
                for(var i=0;i<content.length;i++) {
                    children[i]={openid:"",name:"",school:"",class:""};
                    children[i].openid=content[i].openId;
                    children[i].name=content[i].name;
                    children[i].school=content[i].school;
                    children[i].class=content[i].myClass;
                }
            }
        });

        var num=children.length;
        var div=document.querySelector('.children');
        var button = document.createElement('button');
        button.className='self';
        button.innerHTML='我的';
        button.addEventListener("click", function(){
            window.location.href='..';//显示所有孩子 所有情况的总的
        });
        div.appendChild(button);

        for(var i=0;i<num;i++) {
            var div_child = document.createElement('div');
            div_child.className="divChild";
            var button_child=document.createElement('button');
            button_child.innerHTML=children[i].name;
            //button_child.name=i;
            button_child.className="child";
            button_child.value=children[i].openid;
            var text_child=document.createElement("label");
            text_child.className="text";
            text_child.innerHTML="学校："+children[i].school+"<br/>年级："+children[i].class;
            text_child.style="display:none";
            button_child.addEventListener("mouseover", function(){
                $(this).next().css('display','block');
            });
            button_child.addEventListener("mouseout", function(){
                $(this).next().css('display','none');
            });
            button_child.addEventListener("click", function(){
                //alert(1);
                setCookie('childOpenid',$(this).val(),1);
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
                    window.location.href="../../newFind.html";
                });
            });
            div_child.appendChild(button_child);
            div_child.appendChild(text_child);
            div.appendChild(div_child);
        }



        //中心点横坐标
        var dotLeft = ($(".children").width()-$(".self").width())/2;
        //中心点纵坐标
        var dotTop = ($(".children").height()-$(".self").height())/2;
        //起始角度
        var stard = 0;
        //半径
        var radius = 60;
        //每一个BOX对应的角度;
        var avd = 360/$(".divChild").length;
        //每一个BOX对应的弧度;
        var ahd = avd*Math.PI/180;
        //设置圆的中心点的位置
        $(".self").css({"left":dotLeft,"top":dotTop});
        $(".divChild").each(function(index, element){
            $(this).css({"left":Math.sin((ahd*index))*radius+dotLeft,"top":Math.cos((ahd*index))*radius+dotTop});
        });
    }
});
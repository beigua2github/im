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
                var f="p";
                if(f) {
                    //将角色设置到cookie
                    setCookie("p_t",f,3000);
                }else{
                    //alert("没有权限");
                    //WeixinJSBridge.invoke('closeWindow',{},function(res){});
                    window.location.href='../../userMessage.html';
                }
            }
        });
    }
    flag = getCookie("p_t");
    if (flag =="a") {//家长
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
        var children=[];
        $('.fourPoint').css('display','none');
        $('.children').css('display','block');

        children=[{openid:"o45t9wZx7eQo5VIB4nTY_76TCW4w",name:"小明",school:"华师",class:"一年级"},{openid:"cdscvdsvsdd",name:"小红",school:"华师",class:"二年级"}];
        //获取老师管理的孩子openid
        $.ajax({
            type: "GET",
            url: "../starsea/",
            dataType: "json",
            data: {
                openId: openid
            },
            success: function (data) {
                var content=data['msg']['msg'];//获取孩子信息  生成一个数组 split content=['dcdscuid','小红','华师','一年级','dcwcww','小明','华师','二年级']；
                var children_num=0;
                for(var i=0;i<content.length;i+=4) {
                    children[children_num]={openid:"",name:""};
                    children[children_num].openid=content[i];
                    children[children_num].name=content[i+1];
                    children[children_num].school=content[i+2];
                    children[children_num].class=content[i+3];
                    children_num+=1;
                }
                //children=[{openid:"cdscsdcsd",name:"小明",school:"华师",class:"一年级"},{openid:"cdscvdsvsdd",name:"小红",school:"华师",class:"二年级"}];
            }
        });
        var a=0;//为circle设置编号

        var svg = d3.select("svg"),
            width = +svg.attr("width"),
            height = +svg.attr("height");
        var color = d3.scaleOrdinal(d3.schemeCategory20);
        var simulation = d3.forceSimulation()
            .force("link", d3.forceLink().id(function(d) { return d.id; }))
            .force("charge", d3.forceManyBody())
            .force("center", d3.forceCenter(width / 2, height / 2));
        d3.json("static/json/data.json", function(error, graph) {
            if (error) throw error;

            var link = svg.append("g")
                .attr("class", "links")
                .selectAll("line")
                .data(graph.links)
                .enter().append("line")
            // .attr("stroke-width", function(d) { return (d.value); });

            var node = svg.append("g")
                .attr("class", "nodes")
                .selectAll("circle")
                .data(graph.nodes)
                .enter().append("circle")
                .attr("r", 10)
                .attr("fill", function(d) { return color(d.group); })
                .call(d3.drag()
                    .on("start", dragstarted)
                    .on("drag", dragged)
                    .on("end", dragended));

            node.append("title")
                .text(function(d) { return d.id; });

            simulation
                .nodes(graph.nodes)
                .on("tick", ticked);

            simulation.force("link")
                .links(graph.links);

            function ticked() {
                link
                    .attr("x1", function(d) { return d.source.x; })
                    .attr("y1", function(d) { return d.source.y; })
                    .attr("x2", function(d) { return d.target.x; })
                    .attr("y2", function(d) { return d.target.y; });

                node
                    .attr("cx", function(d) { return d.x; })
                    .attr("cy", function(d) { return d.y; });
            }
        });
        function dragstarted(d) {
            if (!d3.event.active) simulation.alphaTarget(0.3).restart();
            d.fx = d.x;
            d.fy = d.y;
        }
        function dragged(d) {
            d.fx = d3.event.x;
            d.fy = d3.event.y;
        }
        function dragended(d) {
            if (!d3.event.active) simulation.alphaTarget(0);
            d.fx = null;
            d.fy = null;
        }



    }
});
/**
 * Created by Administrator on 2016/8/19.
 */
$(document).ready(function () {
    $(".ts_mask").fadeIn(1000);
    $(".button_self").click(self);
    $(".self_commit").click(self_commit);
    $(".self_back").click(self_back);

    $(".button_cp").click(cp);
});

function self(){
    $(".ts_mask").fadeOut(1000);
    $(".self").css('display','block');
}
function self_commit(){
    var count=$("input:checked").length;
    if(count!=5){
        alert("请选择5个");
    }else{
        var chooseClass=new Array();//用于记录选择的类型 1-7编号
        $("input:checked").each(function(){
            chooseClass.push($(this).val());
        });
        alert(chooseClass);
        $.ajax({
            type: "POST",
            url: "../starsea/",
            data: {
                data:chooseClass
            },
            dataType: "json",
            success:function(data){ //成功的处理函数
                console.log(data);
                if(data['msg']['msg']['now_score']!=null) {
                    now_score = data['msg']['msg']['now_score'];
                    now_comment = data['msg']['msg']['now_comment'];
                }else{
                    now_score=[5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5];
                    now_comment=["","","","","","",""];
                }
                //alert(pre_score);
//                set_pre_value();
                $(".ts_mask").fadeOut(1000);
            }
        });
    }
}
function self_back(){
    $(".self").css('display','none');
    $(".ts_mask").fadeIn(1000);
}


function cp(){
    $(".ts_mask").fadeOut(1000);

}

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
        var check_json={};
        var n=1;
        $("input:checked").each(function(){
            check_json['choice'+n]=$(this).val();
            n+=1;
        });
        alert(JSON.stringify(check_json));
    }
}
function self_back(){
    $(".self").css('display','none');
    $(".ts_mask").fadeIn(1000);
}


function cp(){
    $(".ts_mask").fadeOut(1000);

}

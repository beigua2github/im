/**
 * Created by Administrator on 2016/9/3.
 */
$(document).ready(function () {
    var flag = getCookie("role");//flag标志角色  p家长 t老师
    if (flag =="p") {//家长
        $('.p1').click(function(){
            window.location.href="../../diagnoseForm.html";
        });
        $('.p2').click(function(){
            window.location.href="../../parentTest.html";
        });
        $('.p3').click(function(){
            window.location.href="../../keyPoints.html";
        });
    }else if(flag=='t'){//老师
        $('.p1').click(function(){
            window.location.href="../../diagnoseForm.html";
        });
        $('.p2').val('老师教育效能评估').click(function(){
            window.location.href="../../teacherTest.html";
        });
        $('.p3').click(function(){
            window.location.href="../../keyPoints.html";
        });
    }
    $('.p4').click(function(){
        window.location.href="../../common_fourPoint.html";
    });
});
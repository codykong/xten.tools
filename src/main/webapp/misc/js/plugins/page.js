/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 13-12-2
 * Time: 上午10:32
 * page.js
 */
$(function(){
    $("#to-page").keydown(function(event){
        if(event.keyCode==13){
            var pageIndex=$("#to-page").val();
            if(!isLegalSearch(pageIndex)){return ;}
            goToPage(parseInt(pageIndex));
        }

    });
})

function pageClick(pageIndex){
    if(!isLegalSearch(pageIndex)){return ;}
    goToPage(parseInt(pageIndex));
}
/**
 * 判断pageIndex是否合法
 * 1: 是否是数字 2:是否小于1 3:是否大于总页数
 */
function isLegalSearch(pageIndex) {
    var isLegal = false;
    if(!isPositiveInteger(pageIndex)) {alert('请输入一个合法的页数！');return isLegal;}
    var page =   parseInt(pageIndex);
    if(page < 1) {alert('已经是第一页，请输入正确的页数！');return isLegal;}
    var total = parseInt($('#page_total').html());
    if(page > total) {alert('超过总页数，请输入正确的页数！');return isLegal;}
    isLegal = true;
    return isLegal;
}
//判断该对象是否是正的整数组成
function isPositiveInteger(number) {
    var result = false;
    var reg = /^[0-9]*[1-9][0-9]*$/;
    if(reg.test(number)) {
        result = true;
    }
    return result;
}
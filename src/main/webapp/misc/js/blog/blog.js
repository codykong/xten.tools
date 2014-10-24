/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 13-12-23
 * Time: 下午4:59
 * To change this template use File | Settings | File Templates.
 */

function support(ele,sourceId,type){
    var url;
    if(type==1){
        url='/blog/support';
    } else{
        url='/comment/support';
    }
    $.ajax({
        type: 'POST',
        url: url,
        data    : {
            sourceId:sourceId,
            type:type
        },
        error: function () {
            alert("失败");
        },
        success: function (data) {
            if (data.code==0) {


                alert("成功");
                addNum(ele);


            } else {
                alert("失败");
            }
        }
    });
}

function addNum(ele){
    var text=$(ele).html();
    alert(text.replace(/[^0-9]/ig,""));
}

function comment($ele,sourceId,level){
    var content=$($ele).siblings("textarea").val();
    var ancestorId;
    var type;
    if(level==1){
        ancestorId=$("#blogId").val();
        type=1;
    }else{
        ancestorId=$($ele).parents("dl").attr("ancestorId");
        type=2;
    }

    var blogId=$("#blogId").val();
    $.ajax({
        type: 'POST',
        url: '/comment/save',
        data    : {
            sourceId:sourceId,
            content:content,
            type:type,
            level:level,
            ancestorId:ancestorId,
            blogId:blogId
        },
        error: function () {
            alert("失败");
        },
        success: function (data) {
            if (data.code==0) {
                alert("成功");
                $($ele).parent("div").addClass("hidden");


            } else {
                alert("失败");
            }
        }
    });
}

function getComments(blogId){
    $.ajax({
        type: 'POST',
        url: '/comment/list',
        data    : {
            blogId:blogId,
            index:1,
            size:10
        },
        error: function () {
            alert("失败");
        },
        success: function (data) {
            if (data.code==0) {
                setComments(data.content)
            } else {
                alert("失败");
            }
        }
    });

}

function setComments(comments){

    $(comments).each(function(){
        if(this.level==1){
            $("#comments").append("<dl class=\"comments\" ancestorId=\""+this.id+"\"></dl>");
        }
        var $comment = $("#comment-template").clone(true);
        $comment.removeAttr("id");
        $comment.addClass("level"+this.level);
        $comment.removeClass("hidden");
        $comment.find("#userName").html(this.userName);
        $comment.find("#createTime").html(this.createTime);
        $comment.find("#content").html(this.content);
        $comment.find("#supportCount").html("赞（"+this.supportCount+"）");
        $comment.find("#supportCount").attr("onClick","support(this,"+this.id+",2)");
        $comment.find("#commentCount").html("评论（"+this.commentCount+"）");
        $comment.find("#commentCount").attr("onClick","goToComment(this,"+this.id+","+(this.level+1)+")");
        $("#comments").find("dl:last").append($comment);
    })

}


function goToComment(ele,id,level){

    var $content=getSelectTxt()
    var $commentBody= $(ele).parents("dd").children(".comment-body");
    if($commentBody.length==0){
        var $commentTemplate=$("#comment-body-template").clone(true);
        $commentTemplate.children("textarea").val($content);
        $commentTemplate.removeClass("hidden");
        $commentTemplate.removeAttr("id");
        $commentTemplate.children("input").attr("onClick","comment(this,"+id+","+level+")");
        $(ele).parents("dd").append($commentTemplate);
    }else if($commentBody.hasClass("hidden")){
        $commentBody.removeClass("hidden");
    }else{
        $commentBody.addClass("hidden");
    }
}

function getSelectTxt(){
    var selectTxt;
    if(window.getSelection){
        //标准浏览器支持的方法
        selectTxt=window.getSelection();

    }else if(document.selection){
        //IE浏览器支持的方法
        selectTxt=document.selection.createRange().text;
    }
    if(null==selectTxt||""==selectTxt){
        return selectTxt;
    } else{
        return "引用：“"+selectTxt+"”/n";
    }

}



function quote(){
    var selectTxt=getSelectTxt();
    var s= $(".comment-body");
    $(".comment-body").each(function(){
         if(!$(this).hasClass("hidden")){
             var old=$(this).children("textArea").val();
             $(this).children("textArea").val(old+selectTxt);
         }
    });

}

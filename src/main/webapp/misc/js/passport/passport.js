// JavaScript Document

$(function(){			
		

});	

$(function(){

	$("#inputUser").blur(function(){

		if ($(this).val()=="")
		{
			$(this).next(".help-inline").html("输入用户名格式不正确!");
			$(this).parents(".control-group").addClass("error");
		}else{
			$(this).next(".help-inline").html("有效用户名!");
			$(this).parents(".control-group").removeClass("error");
		}

	});

	$("#inputUser").click(function(){

		$(this).next(".help-inline").html("请输入6-20位有效用户名！");
		$(this).parents(".control-group").removeClass("error");
	});

	$(".regist-pwd").blur(function(){

		var $pwd_val=$(this).val();
		if ($pwd_val.length>20||$pwd_val.length<6)
		{
			$(this).next(".help-inline").html("输入密码格式不正确!");
			$(this).parents(".control-group").addClass("error");
		}else if($(this).attr("id")=="inputPasswordR"&&$(this).val()!=$("#inputPassword").val()){
			$(this).next(".help-inline").html("两次输入的密码不一致");
			$(this).parents(".control-group").addClass("error");
		}else{
			$(this).next(".help-inline").html("有效密码!");
			$(this).parents(".control-group").removeClass("error");
		}

	});

	$(".regist-pwd").click(function(){

		$(this).next(".help-inline").html("请输入6-20位有效密码！");
		$(this).parents(".control-group").removeClass("error");

	});

	$("#regist-btn").click(function(){

		if ($(".control-group").hasClass("error")) {
			return false;
		}

	});

	

});
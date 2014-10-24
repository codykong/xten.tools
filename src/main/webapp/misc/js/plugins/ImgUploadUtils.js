/*
 * 图片上传
 * 调用方式$('a.btn').imgupload(function(data){...})
 */

(function($){
	$.fn.extend({
		imgupload : function(setExtraData,postHandler){
			var self = this;
			
			//var regExt = /jpg|jpeg|gif|png/;
			var regExt = /jpg|jpeg|JPG|JPEG/;
			
			var uploadForm = $("<form/>").attr({action:'/ads/plan/postpic',name:'imgUploadForm',method:'post',enctype:'multipart/form-data'}).appendTo(this);
			var fileInput = $("<input type='file' name='imgFile' class='j_btn-file'/>").appendTo(uploadForm);
		    //判断上传文件格式是否正确
		    var isLegalFile = function() {
				//验证图片格式
				var filePath = $.trim(fileInput.val());
				var index = filePath.lastIndexOf(".");
				var ext = filePath.substring(index + 1).toLowerCase();
				if(!regExt.test(ext)) {
					setAlertBox(self,'您所输入的图片格式不正确，请重新输入jpg|jpeg格式文件！');
					return false;
				}
				return true;
				//验证图片分别率
		    };
		    
			var imgUploadOptions = {
					data:{},
					error:function(){setAlertBox('#singleImgUpload','请求中断!');},
					beforeSubmit:function(formData, jqForm, options) { 
						setExtraData(options.data);
					},
					success:function(data){
						postHandler(eval(data));
						uploadForm[0].reset();
					}
			};
			
			if($.browser.msie){
				fileInput.bind("change",function(event)
			    {
					if(!isLegalFile()) {return false;}
			        setTimeout(function()
			        {
			        	uploadForm.ajaxSubmit(imgUploadOptions);
			        }, 0);
			    });
				
			}else if($.browser.mozilla){
				fileInput.bind("change", function(){if(!isLegalFile()) {return false;}uploadForm.ajaxSubmit(imgUploadOptions);});  
			}   
			else{
				fileInput.bind("change", function(){if(!isLegalFile()) {return false;}uploadForm.ajaxSubmit(imgUploadOptions);}); 
			} 
			
			var inputHeight = fileInput.height();
			var inputWidth = fileInput.width();
			
			this.bind("mousemove",function(e){
				var st = getScrollTop(),    //页面滚动的高度
				ctop = $(this).offset().top - st,  //容器元素相对窗口的高度
				mtop = e.clientY,      //鼠标相对窗口的高度
				mleft = e.clientX,    //鼠标相对窗口左边的距离
				cleft = $(this).offset().left,  //容器元素相对窗口左边的距离
				
				rleft=Math.floor(mleft - cleft), //鼠标相对容器的left
				rtop=Math.floor(mtop - ctop),    //鼠标相对容器的height
				iHeight = parseInt(inputHeight / 2), 
				iWidth = parseInt(inputWidth / 2);
				
				fileInput.css({left:(rleft - iWidth) + "px",top:(rtop - iHeight) + "px"});
			});
			
			function getScrollTop() {   
			    var scrollPos = 0;    
			    if (typeof window.pageYOffset != 'undefined') {    
			       scrollPos = window.pageYOffset;    
			    }    
			    else if (typeof window.document.compatMode != 'undefined' &&    
			       window.document.compatMode != 'BackCompat') {    
			       scrollPos = window.document.documentElement.scrollTop;    
			    }    
			    else if (typeof window.document.body != 'undefined') {    
			       scrollPos = window.document.body.scrollTop;    
			    }    
			    return scrollPos;   
			}  
			return this;
		}
	});
})(jQuery);

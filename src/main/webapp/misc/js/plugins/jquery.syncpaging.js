 /* 
 * jQuery Sync Paging Plugin
 * version: 1.0.0 (09-April-2013)
 * author: shuzongrui 
 * @requires jQuery v1.7.0 or later
 */
(function($) {

	
	//encapsulation and architecture this will not be cluttering up the $.fn namespace
	var methods = {
		//【分页：执行初始化】
		init : function(queryFun) {
			$('#pagingDiv').children('a').click(function() {
				clearPagingInputValue();
				if($(this).hasClass('pre')) {
					var pageIndex = getCurrentPageIndex() - 1;
					if(isLegalSearch(pageIndex)) {
						$('#pagingDiv').children('a.current').removeClass('current').prev().addClass('current');
					}
				}
				else if($(this).hasClass('next')) {
					var pageIndex = getCurrentPageIndex() + 1;
					if(isLegalSearch(pageIndex)) {
						$('#pagingDiv').children('a.current').removeClass('current').next().addClass('current');
					}
				}
				else {
					$('#pagingDiv').children('a.current').removeClass('current');
					$(this).addClass('current');
					
				}
				initPagingQueryParameter();
				queryFun();
			})
			
			$('#pagingOkBtn').click(function(){
				var pageIndex = parseInt($.trim($('#pagingPageIndex').val()));
				if(isLegalSearch(pageIndex)) {
					initPagingQueryParameter();
					queryFun();
				}
			})
			
			$('#pageSizeSelect').change(function(){
				    $('#pagingPageIndex').val("1");
				    initPagingQueryParameter();
					queryFun();
	        })
			
			initPageSizeSelect();
		}
	}

	$.fn.syncpaging = function(method) {
		//calling method
		if (methods[method]) { //call paging method or other for future
			return methods[method].apply(this, Array.prototype.slice.call(arguments, 1));
		} else if (!method) {  //call init
			return methods.init.apply(this, arguments);
		} else {
			$.error('Method ' + method + ' does not exist on jQuery.paging');
		}
		return this;
	};
	
	/**
	 * init pageSize and pageIndex for paging parameter
	 */
	function initPagingQueryParameter() {
		$('#pageSize').val($('#pageSizeSelect').val());
		var pageIndex = parseInt($.trim($('#pagingPageIndex').val()));
		if(pageIndex) {
			$('#pageIndex').val(pageIndex)
		}
		else {
			var curIndex = $.trim($('#pagingDiv').children('a.current').text());
			if (curIndex){
				$('#pageIndex').val(curIndex);
			}else{
				$('#pageIndex').val("1");
			}
			
		}

	}
	
	function clearPagingInputValue() {
		$('#pagingPageIndex').val(null);
	}
	
	function initPageSizeSelect() {
		$('#pageSizeSelect').val($('#pageSizeSelectValue').val());
	}

	function getCurrentPageIndex() {
		return parseInt($.trim($('#pagingDiv').children('a.current').text()));
	}

	function setCurrentPageStyle() {
		return parseInt($.trim($('#pagingDiv').children('a.current').text()));
	}

	/**
	 * 获取总页数
	 */
	function getTotalPage() {
		return parseInt($('#totalPage').text());
	}
	/**
	 * 判断pageIndex是否合法
	 * 1: 是否是数字 2:是否小于1 3:是否大于总页数
	 */
	function isLegalSearch(pageIndex) {
		var isLegal = false;
		if(!_isPositiveInteger(pageIndex)) {alert('请输入一个合法的页数！');return isLegal;}
		if(pageIndex < 1) {alert('已经是第一页，请输入正确的页数！');return isLegal;}
		if(pageIndex > getTotalPage()) {alert('超过总页数，请输入正确的页数！');return isLegal;}
		isLegal = true;
		return isLegal;
	}
		
	function _isPositiveInteger(number) {
		var result = false;
		var reg = /^[1-9][0-9]*$/;
		if(reg.test(number)) {
			result = true;
		}
		return result;
	}

})(jQuery)
// validate
$(function(){
	 $("#postForm").validate({
	        rules: {
	        	prdNm:{required:true},
	        	prdDesc:{required:true},
	        },
	        onkeyup:false,
	        onclick:false,
	        onfocusout:false,
	        messages: {
	        	prdNm:{required:"상품명을 입력하세요."},
	        	prdDesc:{required:"상품설명을 입력하세요."},
	 
	        },        
	        submitHandler: function (frm) {
				if(confirm("등록하시겠습니까?")){
		        	frm.submit();	 
				}else{
					return false;
				}
	    		
	        },
	        success: function (e) { 
	        },
	        showErrors:function(errorMap, errorList){
				if(!$.isEmptyObject(errorList)){
			       	$.each(errorList, function() {
	                	alert(this.message); //summary += " * " + this.message + "<br>" ;
	                	return false;
	            	});
				}
			}		
		});
	
});
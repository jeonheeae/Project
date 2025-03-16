// 페이징 기능
function pageLink (num){
	var form = document.searchForm;
	form.pageIndex.value = num;
	form.submit();
}

// 삭제 기능
$(document).on('click', '#delBtn', function(){
	if(confirm("삭제하시겠습니까?")){
		$.ajax({
			url : "./delete.do"
			, type : "json"
			, method : "post"
			, data : {
				prdSn : $(this).val()
			},
			success: function(data){
				location.reload();
			},
			error : function(request, status, error){
				console.log(error);
			}
		});
	}
});
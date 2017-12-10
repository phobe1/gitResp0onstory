/**
 * 
 */
$(function(){
	$("#userCode").blur(function(){
		var uc = $("#userCode").val();
		console.log(uc);
		$.ajax({
			url:"/queryUserByUserCode",
			data:{"userCode":uc},
			method:"POST",
			dataType:"JSON",
			success:function(data){
				console.log(data.result);
				$("#userCode").next().text(data.result);
				
			}
			
		})
		
	})
	
})
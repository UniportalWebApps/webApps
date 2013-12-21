
$(function(){	
	$("studentForm").validate({
		rules: {
			id: {
				required: true,
				number: true					
			},
			firstName: {
				required: true,
				minlength : 2,
				maxlength : 50
			},
			lastName: {
				required: true,
				minlength : 2,
				maxlength : 50
			}
		}
	});
});
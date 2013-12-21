// calls the delete from DB using Ajax and remove the deleted row from table 
var xmlhttp;
var tRowIndex;
function deleteByAjax(id, rowId) {			
	if (confirm('Are you sure you want to Delete Student')) {
		//Hide the table and show animation
		$("#StudentListTable").hide();
		$("#loading").show();
		
		// get the form values  
		$.ajax({
			type : "GET",
			url : "deleteStudent?id=" + id,
			success : function(response) {
				// we have the response  
				$('#deleteResult').html(response);
				$("#ROWID_"+rowId).remove();
				
				//show back the table and hide animation 
			$("#StudentListTable").show();
			$("#loading").hide();
			},
			error : function(e) {
				alert('Error: ' + e);
			}
		});
	}

}


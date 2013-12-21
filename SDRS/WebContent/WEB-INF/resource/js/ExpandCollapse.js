
$( document ).ready(function() {
	
	$("#EXPND_LEFT").hide();
	
	$( "#CLPS_LEFT" ).click(function(){
		$("#CLPS_LEFT").hide();
		$("#leftMain").hide();
		$("#EXPND_LEFT").show();		
	});
	
	
	$( "#EXPND_LEFT" ).click(function(){
		$("#EXPND_LEFT").hide();
		$("#CLPS_LEFT").show();
		$("#leftMain").show();			
	});

});


function showImage(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#studentImg')
                .attr('src', e.target.result)
                .width(150)
                .height(200);
        };

        reader.readAsDataURL(input.files[0]);
    }
}
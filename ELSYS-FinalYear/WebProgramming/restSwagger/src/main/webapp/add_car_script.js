$(document).ready(function() {
	
	$("#submitButton").click(function (){
		var id = $('#id').val();
		var name = $('#name').val();
		var brand = $('#brand').val();
		var model = $('#model').val();
		var hp = $('#hp').val();
		var year = $('#year').val();
		var JSONObj = {"id": parseInt(id),
						"name": name,
						"brand": brand, 
						"model": model,
						"horsePower": parseInt(hp),
						"year": year};
		console.log(JSONObj);
		$.post({
			url: "http://localhost:8081/rst/api/cars",
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			data: JSON.stringify(JSONObj),
			success: function(data){
				console.log(data);
				var text = "";
				$.each(data, function(index){
					text.concat(data[index] + " ");
				});
				alert("New car added . . .");
				location.reload();
			}
		});
	});
});
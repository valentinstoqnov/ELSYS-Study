var page = 1;
$(document).ready(function() {
	$("#showMoreCars").hide();
	$("#loadCars").click(function(){
		$('#loadCars').remove();
		console.log(load_content());
		$('#panel').append();
		$("#showMoreCars").show();
	});
	$("#showMoreCars").click(function() {
		load_content();
		//$('#panel').append(load_content());
	});
});

function load_content(){
	var PER_PAGE = 2;
	//var divPanel = "";
	$.get({
		url: "http://localhost:8081/rst/api/cars",
		data : {"page":page, "per-page":PER_PAGE} ,
		dataType: "json",
		success: function(data){
			console.log(data);
			if(data.length === 0){
				alert("There is no more data");
				$("#showMoreCars").hide();
			}else{
			$.each(data, function(index){
				var divPanel = 
					'<div class="panel-group">'
						+'<div id="panel" class="panel panel-info">'
							+'<div class="panel-heading">'
								+'<h2>'+data[index].name+'</h2>'
								/*+'<span name="remove" class="glyphicon glyphicon-remove"'
								+'style="float:right; margin-left: 15px"></span>'
								+'<span name="update" class="glyphicon glyphicon-pencil"'
								+'style="float:right;"></span>'
								+'</div>'*/
								+'<div class="panel-body">'
								+'<h3 id="panel-brand">Brand: '+data[index].brand+'</h3>'
								+'<h4 id="panel-model">Model: '+data[index].model+'</h4>'
								+'<h5 id="panel-hp">HP: '+data[index].horsePower+'</h5>'
								+'<h5 id="panel-year">Year: '+data[index].year+'</h5>'
								+'<h5 id="panel-id">Id: '+data[index].id+'</h5>'
								+'</div></div></div>';
				$('#panel').append(divPanel);
				console.log(divPanel);
			});
			page++;
			}
		}
	});
	//console.log(divPanel);
	//return divPanel;
}









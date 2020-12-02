$(document).ready(function() {
	changePageAndSize("");
	var v = 0;
	var city = $('#city').val();
	$('#search').click(function() {
		var city = $('#city').val();
		window.location.replace("/?pageSize=" + 10
							+ "&page=0&city="+city);		
	});
	
	$('#reset').click(function() {
		window.location.replace("/?pageSize=" + this.value
						+ "&page=1&city=");		
	});
	
	function changePageAndSize(city) {
		$('#pageSizeSelect').change(
			function(evt) {
				v= this.value;
				window.location.replace("/?pageSize=" + this.value
						+ "&page=1&city="+city);
		});
	}
	
});
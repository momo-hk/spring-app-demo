$(document).ready(function() {
	changePageAndSize();
});

function changePageAndSize() {
	$('#pageSizeSelect').change(function(evt) {
		var url = window.location.href.split('?')[0];
		window.location.replace(url + "?size=" + this.value + "&page=1");
	});
}

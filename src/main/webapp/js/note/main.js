require([ 'jquery', 'mustache' ], function($, mustache) {

	function render(datas) {
		var template = $("#list").html();
		var html = mustache.to_html(template, datas);
		$("#test1").html(html);
	}

	$("#button").click(function() {
		var params = {
				username : "liying"
		};
		var url = "business/test";
		$.ajax({
			type : "POST",
			url : url,
			data : JSON.stringify(params),
			contentType :'application/json',
			success : function(datas, status, XHR) {
				var data = {
					users:datas,	
				};
				render(data);
			},
			error : function() {
				alert("异常！");
			}
		});
	});
});
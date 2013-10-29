<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">    
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	<link href="/Cofre/resources/css/bootstrap.css" rel="stylesheet">
	<link href="/Cofre/resources/css/bootstrap-responsive.css" rel="stylesheet">
	<script type="text/javascript" src="/Cofre/resources/js/jquery.js"></script>
	<script type="text/javascript" src="/Cofre/resources/js/bootstrap-dropdown.js"></script>
	<script>
		function teste (x, event)
		{
			event.preventDefault();
			$("#menuSup li").removeClass("active");
			$(x).addClass("active");
		}
		
		$(document).ready(function(){
				$(".menuSup").click(function(){
				$(".menuSup").removeClass("active");
				$(this).addClass("active");
			});
		});
	</script>
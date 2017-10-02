<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<title>Project-Hub</title>
<meta charset="utf-8">
<title>Admin | Social - Premium Responsive Admin Template</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link href="${pageContext.request.contextPath}/resources/css/social.core.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/social.admin.css" rel="stylesheet">


<link href="${pageContext.request.contextPath}/resources/css/glyphicons_free/glyphicons.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/glyphicons_pro/glyphicons.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/glyphicons_pro/glyphicons.halflings.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/font-awesome/font-awesome.css" rel="stylesheet">
<style>
.wrapper .main {
	margin-top: 40px;
}

@media screen and (max-width: 480px) {
	.wrapper .main {
		margin-top: 80px;
	}
}
</style>
<link href="${pageContext.request.contextPath}/resources/css/jquery-ui/social/jquery.ui.css" rel="stylesheet">

<link id="current-theme" href="${pageContext.request.contextPath}/resources/css/themes/admin/facebook.css"
	rel="stylesheet">

<link href="${pageContext.request.contextPath}/resources/js/plugins/jqvmap/jqvmap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/plugins/fullcalendar/fullcalendar.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/js/plugins/pnotify/pnotify.custom.min.css" rel="stylesheet">


<link href="${pageContext.request.contextPath}/resources/css/demo.css" rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/js/plugins/jquery-simplecolorpicker/jquery.simplecolorpicker.css"
	rel="stylesheet">


<!--[if lt IE 8]>
    <script src="${pageContext.request.contextPath}/resources/js/html5shiv/html5shiv.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/plugins/respond/respond.min.js"></script> 
    <![endif]-->

</head>
<body>
	<div class="wrapper">
		<div id="navbar">
			<%@include file="/WEB-INF/mainjsps/navbar.jsp"%>
		</div>
		<div id="header">
			<%@include file="/WEB-INF/mainjsps/header.jsp"%>
		</div>

		<div class="main">

			<div id="body">
				<jsp:doBody />
			</div>
			<div id="footer">
				<%@include file="/WEB-INF/mainjsps/footer.jsp"%>
			</div>
		</div>
		<!-- /.row -->


		<div id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" data-dismiss="modal" aria-hidden="true"
							class="close">×</button>
						<h4 id="myModalLabel" class="modal-title">Modal Settings</h4>
					</div>
					<div class="modal-body">Lorem ipsum dolor sit amet,
						consectetur adipisicing elit. Et, deserunt!</div>
					<div class="modal-footer">
						<button type="button" data-dismiss="modal" class="btn btn-default">Close</button>
						<button type="button" class="btn btn-primary">Save
							changes</button>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
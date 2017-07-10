<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.goods_sell.model.*"%>

<jsp:useBean id="goods_sellSvc" scope="page"
	class="com.goods_sell.model.Goods_SellService" />

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>Title Page</title>
<jsp:include page="/mustinclude/head.jsp" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<!--[if lt IE 9]>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->

<style>
.collapse {
	margin: -15px;
}

.list-group {
	margin-top: 15px;
}

.btn {
	width: 50px;
}

.breadcrumb {
	margin-top: -20px;
	background: skyblue;
}
</style>
</head>
<body>
	<jsp:include page="/mustinclude/left_nav.jsp" />
	<jsp:include page="/mustinclude/top_nav.jsp" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-8 col-sm-push-2">
				<ol class="breadcrumb">
					<li><a href="<%=request.getContextPath()%>/index.jsp">首頁</a></li>
					<li><a href="#" class="active">預購商品</a></li>
					<li><a href="#" class="active">商品</a></li>
				</ol>
			</div>
			<div class="row">
				<div class="col-sm-12 cal-sm-push-1">
					<div class="collapse navbar-collapse navbar-ex1-collapse">
						<ul class="nav navbar-nav side-nav">
							<li><a href="#">
									<FORM METHOD="post" ACTION="<%=request.getContextPath()%>"
										onclick="submit()">
										<p>A</p>
									</FORM>
							</a></li>
							<li><a href="#">
									<FORM METHOD="post" ACTION="<%=request.getContextPath()%>"
										onclick="submit()">
										<p>B</p>
									</FORM>
							</a></li>
							<li><a href="#">
									<FORM METHOD="post" ACTION="<%=request.getContextPath()%>"
										onclick="submit()">
										<p>C</p>
									</FORM>
							</a></li>
							<li><a href="#">
									<FORM METHOD="post" ACTION="<%=request.getContextPath()%>"
										onclick="submit()">
										<p>D</p>
									</FORM>
							</a></li>

						</ul>
					</div>
				</div>
			</div>
			<jsp:include page="/buycart/maosecond-import.jsp" />
			<div class="row ">
				<div class="col-sm-10 col-sm-push-1 ">
					<div class="col-sm-10 col-sm-push-1 ">
						<div class="btn-group btn-group-justified ">
							<a href="# " class="btn btn-default " role="button ">回標題</a>
						</div>
						<div class="col-sm-11 col-sm-push-3 ">
							<jsp:include page="/mustinclude/footer.jsp" />
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
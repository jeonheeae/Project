<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 				prefix="c" 			%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" 		prefix="page" 		%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<title><decorator:title default="Beauty Log" /></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
	    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/admin/app.css" />
	    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/admin/app-dark.css" />
        <script src="${pageContext.request.contextPath }/js/admin/initTheme.js"></script>	    
        <script src="${pageContext.request.contextPath }/js/admin/dark.js"></script>	    
        <script src="${pageContext.request.contextPath }/js/admin/perfect-scrollbar.min.js"></script>
        <script src="${pageContext.request.contextPath }/js/admin/app.js"></script>	    
		<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
		<decorator:head />
	</head>
	
	<body>
		<div id="app">
		<page:applyDecorator name="adminLeftMenu" />
		<div id="main">
            <header class="mb-3">
                <a href="#" class="burger-btn d-block d-xl-none">
                    <i class="bi bi-justify fs-3"></i>
                </a>
            </header>		
			<decorator:body />
			<page:applyDecorator name="adminFooter" />
		</div>
	</div>
	</body>
</html>
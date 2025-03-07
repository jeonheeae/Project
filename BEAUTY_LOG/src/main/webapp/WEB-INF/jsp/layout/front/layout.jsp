<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 				prefix="c" 			%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" 		prefix="page" 		%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<title><decorator:title default="BeautyLog" /></title>	
		<decorator:head />
	</head>
<%-- 	<page:applyDecorator name="header" /> --%>
	<decorator:body />
<%-- 	<page:applyDecorator name="footer" /> --%>
	</body>
</html>
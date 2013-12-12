<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title><fmt:message key="login.titulo" /></title>
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=yes">
		<link href="<c:url value="css/bootstrap.min.css"/>" rel="stylesheet" type="text/css">
		<link href="<c:url value="css/bootstrap-theme.min.css"/>" rel="stylesheet" type="text/css">		
		<link href="<c:url value="css/login.css"/>" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="<c:url value="js/jquery-2.0.3.js"/>"></script>
		<script type="text/javascript" src="<c:url value="js/relprev.utilitarios.js"/>"></script>
	</head>
	<body>		
		<div class="container">
	      <form action="<c:url value='/login'/>" method="post" class="form-signin">
	        <h2 class="form-signin-heading"><fmt:message key="login.label" /></h2>
	        <input type="text" name="usuario" class="form-control" value="${usuario}" placeholder="<fmt:message key="usuario" />" required="" autofocus="">
	        <input type="password" name="senha" class="form-control" value="${senha}" placeholder="<fmt:message key="login.senha" />" required="">
	        <c:forEach var="error" items="${errors}">
			    ${error.category} - ${error.message}<br />
			</c:forEach>
	        <label class="checkbox">
	          <input type="checkbox" value="remember-me"><fmt:message key="login.lembrarme" />
	        </label>	        
	        <button class="btn btn-lg btn-primary btn-block" type="submit"><fmt:message key="login.entrar" /></button>
	        <br/>
	        <a href=""><fmt:message key="login.naoconsegueacessar" /></a>
	      </form>		      	
	    </div>	
	</body>		
</html>
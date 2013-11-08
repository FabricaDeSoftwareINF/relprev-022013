<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title><fmt:message key="login.titulo" /></title>
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=yes">
		<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
		<link href="../css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
		<link href="../css/site.css" rel="stylesheet" type="text/css">
		<link href="../css/login.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="../js/jquery-2.0.3.js"></script>
		<script type="text/javascript" src="../js/utilitarios.js"></script>
	</head>
	<body>
		<div class="container">
	      <form class="form-signin">
	        <h2 class="form-signin-heading"><fmt:message key="login.label" /></h2>
	        <input type="text" class="form-control" placeholder="<fmt:message key="login.usuario" />" required="" autofocus="">
	        <input type="password" class="form-control" placeholder="<fmt:message key="login.senha" />" required="">
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
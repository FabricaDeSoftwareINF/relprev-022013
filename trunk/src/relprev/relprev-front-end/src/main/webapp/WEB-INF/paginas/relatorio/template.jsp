<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>RELPREV</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Bootstrap -->
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/relprev.css" rel="stylesheet">
        <link href="../css/menu-superior.css" rel="stylesheet">
        <script type="text/javascript" src="../js/jquery-2.0.3.js"></script>
		<script type="text/javascript" src="../js/utilitarios.js"></script>
    </head>
    <body>
        <div class="container">
            <div id="topo">
                <div id="sessao">
                    <span style="margin: 10px">Nome do usuário</span>
                    <a href="#"><fmt:message key="menu.sair" /></a>
                </div>
                <div id="selecao-ano">
                	<fmt:message key="menu.ano" />
                	<select>
                        <option>2013</option>
                        <option>2012</option>
                    </select>
                </div>
            </div>
            <div>
                <ul class="nav nav-justified">
                    <li class="active"><a href="#"><fmt:message key="menu.relprev" /></a></li>
                    <li><a href="#"><fmt:message key="menu.impressao" /></a></li>
                    <li><a href="#"><fmt:message key="menu.estatisticas" /></a></li>
                    <li><a href="#"><fmt:message key="menu.rsv" /></a></li>
                    <li><a href="#"><fmt:message key="menu.elosipaer" /></a></li>
                </ul>
            </div>            
            <div class="conteudo">                
            </div>
        </div>
    </body>
</html>
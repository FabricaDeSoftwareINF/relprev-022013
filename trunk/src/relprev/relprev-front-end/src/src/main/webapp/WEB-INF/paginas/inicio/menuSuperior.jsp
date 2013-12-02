<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="container">   
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<c:url value="/relatorio/ultimosRelatorios"/>"><fmt:message key="relprev" /></a>
                <div class="nomeUsuario visible-xs">
                    ${usuarioInfo.nome}
                </div>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav">	            
                    <li><a href=""><fmt:message key="menu.estatisticas" /></a></li>
                    <li><a href="<c:url value="/rsv"/>"><fmt:message key="menu.rsv" /></a></li>
                    <li><a href="<c:url value="/impressao"/>"><fmt:message key="menu.impressao" /></a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="menu.configuracoes" /> <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li><a href="#"><fmt:message key="menu.sistema" /></a></li>
                            <li><a href="<c:url value="/eloSipaer"/>"><fmt:message key="menu.elosipaer" /></a></li>
                            <li><a href="<c:url value="/usuario"/>"><fmt:message key="usuario" /></a></li>
                        </ul>
                    </li>
                    <li class="visible-xs"><a href="<c:url value="/logout"/>"><fmt:message key="menu.sair" /></a></li>
                </ul>
                <li class="visible-md visible-lg"><a href="<c:url value="/logout"/>"><fmt:message key="menu.sair" /></a></li>
                <div class="nomeUsuario hidden-xs">
                    ${usuarioInfo.nome}
                </div>							
            </div>				
        </div>	          
    </div>                      
</div>
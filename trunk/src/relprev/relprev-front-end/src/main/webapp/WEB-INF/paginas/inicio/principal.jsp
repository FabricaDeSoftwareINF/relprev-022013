<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
    <title><fmt:message key="relprev" /></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- Bootstrap -->
      	<link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
      	<link href="<c:url value="/css/relprev.css"/>" rel="stylesheet">
      	<link href="<c:url value="/css/menu-superior.css" />" rel="stylesheet">
      	<script type="text/javascript" src="<c:url value="/js/jquery-2.0.3.js"/>" ></script>
		<script type="text/javascript" src="<c:url value="/js/utilitarios.js"/>" ></script>
		<script type="text/javascript" src="<c:url value="/js/bootstrap.min.js"/>" ></script>
  	</head>
    <body>
    	<div class="container">
        	<div id="topo">            	
                <div id="selecao-ano">
               		<fmt:message key="menu.ano" />
                	<select>
                        <option>2013</option>
                        <option>2012</option>
                    </select>
                </div>
            </div>
            <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		    	<div class="container">
		        	<div class="navbar-header">
		          		<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
		            		<span class="sr-only">Toggle navigation</span>
		            		<span class="icon-bar"></span>
		            		<span class="icon-bar"></span>
		            		<span class="icon-bar"></span>
		          		</button>
		          		<a class="navbar-brand" href="#"><fmt:message key="relprev" /></a>
		          		<div class="nomeUsuario visible-xs">
			          		Olá, ${usuarioInfo.nome}
			          	</div>
		        	</div>
		        	<div class="collapse navbar-collapse">
		        		<ul class="nav navbar-nav">	            
		            		<li><a href=""><fmt:message key="menu.estatisticas" /></a></li>
			            	<li><a href=""><fmt:message key="menu.rsv" /></a></li>
			            	<li><a href=""><fmt:message key="menu.elosipaer" /></a></li>
			            	<li class="visible-xs"><a href=""><fmt:message key="menu.impressao" /></a></li>
			            	<li class="visible-xs"><a href=""><fmt:message key="menu.configuracoes" /></a></li>
							<li class="visible-xs"><a href=""><fmt:message key="menu.sair" /></a></li>
			          	</ul>			          	
			          	<button type="button" class="hidden-xs botoesMenu btn btn-default" onclick="location.href='<c:url value="/logout"/>';" >
	  						<span class="glyphicon glyphicon-log-out"></span>
	  										
						</button>
			          	<button type="button" class="hidden-xs botoesMenu btn btn-default">
	  						<span class="glyphicon glyphicon-wrench"></span>
						</button>
			          	<button type="button" class="hidden-xs botoesMenu btn btn-default" onclick="print()">
	  						<span class="glyphicon glyphicon-print"></span>
						</button>
						<div class="nomeUsuario hidden-xs">
			          		Olá, ${usuarioInfo.nome}
			          	</div>							
	          		</div>				
		    	</div>	          
	        </div>                      
            <div class="conteudo">                
            </div>
        </div>        
    </body>
</html>
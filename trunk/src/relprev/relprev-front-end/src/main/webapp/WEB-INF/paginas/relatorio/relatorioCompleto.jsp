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
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        
        <!-- Estilos para os componentes do jQuery UI, tais como o DatePicker. -->
<link href="<c:url value="/css/ui-lightness/jquery-ui-1.10.3.custom.css" />" rel="stylesheet" media="all">
        
		<script type="text/javascript" src="<c:url value="/js/jquery-2.0.3.js"/>" ></script>
		<script type="text/javascript" src="<c:url value="/js/jquery-ui-1.10.3.custom.js"/>" ></script>
		<script type="text/javascript" src="<c:url value="/js/jquery.meio.mask.js"/>" ></script>
    </head>
    <body>
        <div id="borda" class="container">
        	<div class="container" style="max-width: 800px;">
			    <div class="container"  id="titulo" style="text-align: center">
			        <h1 class="labelMaiuscula"><fmt:message key="relatorio.prevencao" /></h1>
			    </div>			    
			    <div id="aviso">
			        De acordo com as regulamenta��es brasileiras, este relato (ou parte dele) <b>somente ser� usado para a 
			        preven��o de acidentes aeron�uticos</b>, a fim de aumentar a seguran�a operacional. Este relato n�o precisa
			        ser identificado, se o for, o relator ser� informado sobre as medidas adotadas.
			    </div>			    
			    <hr/>
			    <form action="<c:url value='/relatorio'/>" method="post" enctype="multipart/form-data">
						<% String relprev = "relprev"; %>
        		<%@include file="relatorio.jsp" %>
        		<div id="botoesRelatorio" class="container">
			        <button type="submit" class="btn btn-primary">
			        	<fmt:message key="enviar" />
			        </button>
			        <button type="reset" class="btn btn-default">
			        	<fmt:message key="limpar" />
			        </button>
			    </div>
        		</form>
       		</div>
       	</div>
       	
       	<%@include file="../../partials/calendario.jsp" %>
    </body>
</html>
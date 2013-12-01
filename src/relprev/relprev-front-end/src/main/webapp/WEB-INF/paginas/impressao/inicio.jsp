<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="<c:url value="/css/impressao.css" />" rel="stylesheet" media="all">
<t:template>
    <jsp:attribute name="titulo">
        <fmt:message key="impressao" />
    </jsp:attribute>
    <jsp:body>
    	<div class="text-center tituloPagina">
        	<fmt:message key="impressao" />
       	</div>
        <hr/>
        <table border=1 class="col-xs-12 col-md-12">
	        <thead bgcolor="#E6E6E6">
	        	<tr>
	        		<th><fmt:message key="numeroComBola" /></th>
	        		<th><fmt:message key="data" /></th>
	        		<th><fmt:message key="situacao" /></th>
	        		<th><fmt:message key="relator" /></th>
	        		<th><fmt:message key="situacao" /></th>
	        		<th><fmt:message key="imprimir" /></th>	        		
	        	</tr>	        	
	        </thead>
	        <tbody>
	        	<tr>
	        		<td>1</td>
	        		<td>27/12/2011</td>
	        		<td>Pegaram meu checklist no bolso do meu anti-g e colocaram outro...</td>
	        		<td>Cap. José</td>
	        		<td>
	        			<span class="label label-success" title="<fmt:message key="encaminhado" />"><fmt:message key="sigla.encaminhamento" /></span>
	        			<span class="label label-success" title="<fmt:message key="relatorio.divulgacao" />"><fmt:message key="sigla.divulgacao" /></span>
	        			<span class="label label-success" title="<fmt:message key="acoes.recomendadas" />"><fmt:message key="sigla.acoes.recomendadas" /></span>
	        			<span class="label label-success" title="<fmt:message key="resposta" />"><fmt:message key="sigla.resposta" /></span>
	        			<span class="label label-success"><fmt:message key="fim" /></span>	
	        		</td>
	        		<td><input type="checkbox"/></td>
	        	</tr>
	        	<tr>
	        		<td>2</td>
	        		<td>03/01/2012</td>
	        		<td>Objeto estranho encontrado no chão dos hangaretes</td>
	        		<td>3s Pagan</td>
	        		<td>
	        			<span class="label label-success" title="<fmt:message key="encaminhado" />"><fmt:message key="sigla.encaminhamento" /></span>
	        			<span class="label label-success" title="<fmt:message key="relatorio.divulgacao" />"><fmt:message key="sigla.divulgacao" /></span>
	        			<span class="label label-success" title="<fmt:message key="acoes.recomendadas" />"><fmt:message key="sigla.acoes.recomendadas" /></span>
	        			<span class="label label-default" title="<fmt:message key="resposta" />"><fmt:message key="sigla.resposta" /></span>
	        			<span class="label label-default"><fmt:message key="fim" /></span>	
	        		</td>
	        		<td><input type="checkbox"/></td>
	        	</tr>
	        	<tr>
	        		<td>3</td>
	        		<td>05/01/2012</td>
	        		<td>Objeto estranho encontrado na caixa de partida da nacele do 1p</td>
	        		<td>3s Gilbert</td>
	        		<td>
	        			<span class="label label-success" title="<fmt:message key="encaminhado" />"><fmt:message key="sigla.encaminhamento" /></span>
	        			<span class="label label-default" title="<fmt:message key="relatorio.divulgacao" />"><fmt:message key="sigla.divulgacao" /></span>
	        			<span class="label label-success" title="<fmt:message key="acoes.recomendadas" />"><fmt:message key="sigla.acoes.recomendadas" /></span>
	        			<span class="label label-default" title="<fmt:message key="resposta" />"><fmt:message key="sigla.resposta" /></span>
	        			<span class="label label-default"><fmt:message key="fim" /></span>	
	        		</td>
	        		<td><input type="checkbox"/></td>
	        	</tr>
	        </tbody>
        </table>        
    	<div class="botoes">
    		<div class="col-xs-3 col-md-3">
	    		<button type="button" class="btn btn-default btn-md">
	  				<span class="glyphicon glyphicon-print"></span>
	  				<fmt:message key="encaminhamentos" /> (<fmt:message key="sigla.encaminhamento" />)
				</button>
			</div>
			<div class="col-xs-3 col-md-3">
				<button type="button" class="btn btn-default btn-md">
	  				<span class="glyphicon glyphicon-print"></span>
	  				<fmt:message key="acoes.recomendadas" /> (<fmt:message key="sigla.acoes.recomendadas" />)
				</button>
			</div>
			<div class="col-xs-3 col-md-3">
				<button type="button" class="btn btn-default btn-md">
	  				<span class="glyphicon glyphicon-print"></span>
	  				<fmt:message key="respostas" /> (<fmt:message key="sigla.resposta" />)
				</button>
			</div>
			<div class="col-xs-3 col-md-3">
				<button type="button" class="btn btn-default btn-md">
	  				<span class="glyphicon glyphicon-print"></span>
	  				<fmt:message key="relatorio.divulgacao" /> (<fmt:message key="sigla.divulgacao" />)
				</button>
			</div>
    	</div>    
    </jsp:body>
</t:template>
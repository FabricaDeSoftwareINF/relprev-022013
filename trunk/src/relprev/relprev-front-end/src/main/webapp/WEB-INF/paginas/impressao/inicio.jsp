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
    	<fmt:setLocale value="pt_BR"/>
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
			    <c:forEach var="relprev" varStatus="status" items="${relatorioPrevencaoList}">
			  		<tr>
				    	<td>${relprev.id}</td>				    	
				    	<td><fmt:formatDate pattern="dd/MM/yyyy" value="${relprev.dataSituacaoPerigosa}" /></td>
				    	<td>${relprev.descricaoSituacaoPerigosa}</td>				    	
				    	<td>${relprev.relator.nome}</td>
				    	<td>
				    		<span class="label 
			    			<c:if test="${!relprev.situacoes.temEncaminhamento}">label-default</c:if>
			    			<c:if test="${relprev.situacoes.temEncaminhamento}">label-success</c:if>
			    			" title="<fmt:message key="encaminhado" />"><fmt:message key="sigla.encaminhamento" /></span>	        							    		
	        				<span class="label 
	        				<c:if test="${!relprev.situacoes.temAcaoRecomendada}">label-default</c:if>
	        				<c:if test="${relprev.situacoes.temAcaoRecomendada}">label-success</c:if>
			  				" title="<fmt:message key="acoes.recomendadas" />"><fmt:message key="sigla.acoes.recomendadas" /></span>
			  				<span class="label 
			  				<c:if test="${!relprev.situacoes.temDivulgacao}">label-default</c:if>
	        				<c:if test="${relprev.situacoes.temDivulgacao}">label-success</c:if>
			  				" title="<fmt:message key="relatorio.divulgacao" />"><fmt:message key="sigla.divulgacao" /></span>
	        				<span class="label 
	        				<c:if test="${relprev.resposta == null}">label-default</c:if>
	        				<c:if test="${relprev.resposta != null}">label-success</c:if>
	        				" title="<fmt:message key="resposta" />"><fmt:message key="sigla.resposta" /></span>        					
	        				<span class="label 
	        				<c:if test="${!relprev.situacoes.foiConcluido}">label-default</c:if>
	        				<c:if test="${relprev.situacoes.foiConcluido}">label-success</c:if>
	        				"><fmt:message key="fim" /></span>	
	        			</td>
				    	<td><input type="checkbox"/></td>
			    	</tr>
			    </c:forEach>		        	
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
				<button type="button" class="btn btn-default btn-md" disabled="disabled">
	  				<span class="glyphicon glyphicon-print"></span>
	  				<fmt:message key="relatorio.divulgacao" /> (<fmt:message key="sigla.divulgacao" />)
				</button>
			</div>
    	</div>    
    </jsp:body>
</t:template>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<link href="<c:url value="/css/dados-gerais.css" />" rel="stylesheet" media="all">
<t:template>
<jsp:body>
	<div class="dadosGerais">
		<div class="relatorio">
		<%@include file="relatorio.jsp" %>
		</div>		
		<div class="resumo">
			<label for="descricaoResumo" class="labelMaiuscula">
				<fmt:message key="resumo" />
			</label>
			<textarea id="descricaoResumo" class="col-xs-12 col-md-12"></textarea>
		</div>
		<ul id="navAbas" class="nav nav-tabs">
			<li id="encaminhamentoAba" class="active">
				<a><fmt:message key="encaminhamento" /></a>
			</li>
  			<li id="parecerDoSetorAba">
  				<a><fmt:message key="parecerDoSetor" /></a>
  			</li>
  			<li id="respostaAba">
  				<a><fmt:message key="resposta" /></a>
			</li>
  			<li id="acoesRecomendadasAba">
				<a><fmt:message key="acoesRecomendadas" /></a>
			</li>
  			<li id="observacoesAba">
  				<a><fmt:message key="observacoes" /></a>
			</li>
  			<li id="concluirAba">
  				<a><fmt:message key="concluir" /></a>
  			</li>
		</ul>		
		<div id="abas" class="panel panel-default">				
			<%@include file="encaminhamento.jsp" %>
			<%@include file="parecerDoSetor.jsp" %>
			<%@include file="resposta.jsp" %>
			<%@include file="acoesRecomendadas.jsp" %>
			<%@include file="observacoes.jsp" %>
		</div>
		<div id="botoesDadosGerais" class="container">
	        <button type="submit" class="btn btn-primary">
	        	<fmt:message key="salvar" />
	        </button>
	        <button type="reset" class="btn btn-default">
	        	<fmt:message key="cancelar" />
	        </button>
	    </div>
	</div>
	<script type="text/javascript" src="<c:url value="/js/abas.js"/>" ></script>
</jsp:body>
</t:template>
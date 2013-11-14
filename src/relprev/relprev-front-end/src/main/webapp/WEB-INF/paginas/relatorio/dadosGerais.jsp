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
		<div class="btn-group-vertical">
	  		<button id="encaminhamentoBotao" type="button" class="botaoAba btn btn-default" style="background-color: #EBEBEB;">
	  			<fmt:message key="encaminhamento" />
	  		</button>
	  		<button id="parecerDoSetorBotao" type="button" class="botaoAba btn btn-default">
	  			<fmt:message key="parecerDoSetor" />
	  		</button>
	  		<button id="respostaBotao" type="button" class="botaoAba btn btn-default">
	  			<fmt:message key="resposta" />
	  		</button>
	  		<button id="acoesRecomendadasBotao" type="button" class="botaoAba btn btn-default">
	  			<fmt:message key="acoesRecomendadas" />
	  		</button>
  			<button id="observacoesBotao" type="button" class="botaoAba btn btn-default">
	  			<fmt:message key="observacoes" />
  			</button>
	  		<button id="concluirBotao" type="button" class="botaoAba btn btn-default">
	  			<fmt:message key="concluir" />
	  		</button>
		</div>	
		<div id="abas" class="panel panel-default">				
			<%@include file="encaminhamento.jsp" %>
			<%@include file="parecerDoSetor.jsp" %>
			<%@include file="resposta.jsp" %>
			<%@include file="acoesRecomendadas.jsp" %>
			<%@include file="observacoes.jsp" %>
		</div>		
	</div>
	<script type="text/javascript" src="<c:url value="/js/abas.js"/>" ></script>
</jsp:body>
</t:template>
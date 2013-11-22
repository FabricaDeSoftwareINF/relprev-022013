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
		<div class="avaliacaoReavaliacao panel panel-default">
			<div class="row">
				<div class="risco">
					<label class="labelMaiuscula"><fmt:message key="risco" /></label>
					<span class="glyphicon glyphicon-info-sign" data-toggle="modal" data-target="#modalTabelaRisco"></span>					
					<div class="modal fade" id="modalTabelaRisco" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					  <div class="dialogoModal modal-dialog">
					    <div class="conteudoModal modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					        <h4 class="modal-title" id="myModalLabel">Matriz de Avalia��o de Risco</h4>
					      </div>
					      <div class="modal-body">
					        <img src="../img/tabela-risco.jpg"/>
					      </div>
					    </div>
					  </div>
					</div>
				</div>
				<div class="reavaliacao col-md-6">
					<label class="labelMaiuscula"><fmt:message key="reavaliacao" /></label>
					<div class="col-md-2">
						<select class="form-control">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select>
					</div>
					<div class="col-md-2">
						<select class="form-control">
							<option>A</option>
							<option>B</option>
							<option>C</option>
							<option>D</option>
							<option>E</option>
						</select>
					</div>
				</div>		
				<div class="avaliacao col-md-6">
				<label class="labelMaiuscula"><fmt:message key="avaliacao" /></label>
				<div class="col-md-2">
					<select class="form-control">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
					</select>
				</div>
				<div class="col-md-2">
					<select class="form-control">
						<option>A</option>
						<option>B</option>
						<option>C</option>
						<option>D</option>
						<option>E</option>
					</select>
				</div>
			</div>
			</div>
		</div>
		<hr />
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
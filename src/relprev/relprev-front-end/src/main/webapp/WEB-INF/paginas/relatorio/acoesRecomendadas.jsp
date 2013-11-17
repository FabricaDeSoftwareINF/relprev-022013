<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div id="acoesRecomendadas" class="aba fundoAbas labelPadrao" style="display: none">
	<div id="tituloAcoesRecomendadas" class="tituloAba col-md-12 textoCentralizado">
		<label><fmt:message key="acoes.corretivas" /></label>
	</div>
	<div id="camposAcoesRecomendadas" class="camposAba col-xs-12 col-md-12">
		<div class="col-xs-4 col-md-4">
			<label class="col-xs-12 col-md-12 labelPadrao"><fmt:message key="do" /></label>
			<input id="acaoDo" type="text" class="form-control"/>
		</div>		
		<div class="col-xs-4 col-md-4">
			<label class="col-xs-12 col-md-12 labelPadrao"><fmt:message key="para" /></label>
			<input id="acaoAo" type="text" class="form-control"/>
		</div>
		<div class="col-xs-4 col-md-4">
			<label class="col-xs-12 col-md-12 labelPadrao"><fmt:message key="dataMaiuscula" /></label>
			<input id="acaoData" type="text" class="form-control"/>
		</div>
		<div class="col-xs-12 col-md-12">
			<textarea id="descricaoAcoesRecomendadas" class="col-xs-12 col-md-12"></textarea>
		</div>
	</div>		
</div>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div id="resposta" class="aba labelPadrao">
	<div id="tituloResposta" class="tituloAba col-xs-12 col-md-12 textoCentralizado">
		<label><fmt:message key="resposta.resposta" /></label>
	</div>
	<div id="camposResposta" class="camposAba col-xs-12 col-md-12">
		<div class="col-xs-4 col-md-4">
			<label class="col-xs-12 col-md-12"><fmt:message key="resposta.ao" /></label>
			<input id="respostaAo" type="text" class="col-xs-12 col-md-12"/>
		</div>		
		<div class="col-xs-4 col-md-4">
			<label class="col-xs-12 col-md-12"><fmt:message key="dataMaiuscula" /></label>
			<input id="dataResposta" type="text" class="col-xs-12 col-md-12"/>
		</div>
		<div class="col-xs-12 col-md-12">
			<textarea id="descricaoEncaminhamento"></textarea>
		</div>
	</div>		
</div>
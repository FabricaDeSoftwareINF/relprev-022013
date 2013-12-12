<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div id="resposta" class="aba labelPadrao" style="display: none">
	<div id="tituloResposta" class="tituloAba col-xs-12 col-md-12 textoCentralizado">
		<label class="labelMaiuscula"><fmt:message key="resposta" /></label>
		<button type="button" class="botaoResposta btn btn-primary">
        	<fmt:message key="registrar.resposta" />
        </button>	
	</div>
	<div id="camposResposta" class="camposAba col-xs-12 col-md-12">
		<div class="col-xs-4 col-md-4">
			<label class="col-xs-12 col-md-12"><fmt:message key="do" /></label>
			<input id="respostaDo" type="text" class="form-control" 
				value="${relatorioPrevencao.resposta.remetente}"/>
		</div>	
		<div class="col-xs-4 col-md-4">
			<label class="col-xs-12 col-md-12"><fmt:message key="para" /></label>
			<input id="respostaAo" type="text" class="form-control"
				value="${relatorioPrevencao.resposta.destinatario}"/>
		</div>		
		<div class="col-xs-4 col-md-4">
			<label class="col-xs-12 col-md-12"><fmt:message key="dataMaiuscula" /></label>
			<fmt:setLocale value="pt_BR"/>
			<input id="dataResposta" type="text" class="form-control calendario"
				value="<fmt:formatDate pattern="dd/MM/yyyy" value="${relatorioPrevencao.resposta.data}" />"/>
		</div>
		<div class="col-xs-12 col-md-12">
			<textarea id="descricaoResposta">${relatorioPrevencao.resposta.descricao}</textarea>
		</div>
	</div>		
</div>
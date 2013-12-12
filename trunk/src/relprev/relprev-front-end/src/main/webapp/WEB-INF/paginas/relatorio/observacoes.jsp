<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div id="observacoes" class="aba fundoAbas labelPadrao" style="display: none">
	<div id="tituloObservacao" class="tituloAba col-md-12 textoCentralizado">
		<label><fmt:message key="observacoes" /></label>
		<button type="button" class="botaoObservacao btn btn-primary">
        	<fmt:message key="registrar.observacao" />
        </button>	
	</div>
	<div id="camposObservacoes" class="camposAba col-xs-12 col-md-12">		
		<textarea id="textoObservacoes" class="col-xs-12 col-md-12">${relatorioPrevencao.observacao.descricao}</textarea>		
	</div>		
</div>
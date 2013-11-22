<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div id="parecerDoSetor" class="aba labelPadrao" style="display: none">
	<div id="tituloResposta" class="tituloAba col-xs-12 col-md-12 textoCentralizado">
		<label><fmt:message key="parecerDoSetor" /></label>
	</div>
	<div id="camposParecerDoSetor" class="camposAba col-xs-12 col-md-12">
		<div class="col-xs-4 col-md-4">
			<label class="col-xs-12 col-md-12"><fmt:message key="setor" /></label>
			<input id="setor" type="text" class="form-control"/>
		</div>		
		<div class="col-xs-4 col-md-4">
			<label class="col-xs-12 col-md-12"><fmt:message key="dataMaiuscula" /></label>
			<input id="dataParecer" type="text" class="form-control calendario"/>
		</div>
		<div class="col-xs-12 col-md-12">
			<textarea id="descricaoParecerDoSetor"></textarea>
		</div>
	</div>		
</div>
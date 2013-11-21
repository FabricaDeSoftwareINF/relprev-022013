<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link href="../css/relprev.css" rel="stylesheet">

<!-- Estilos para os componentes do jQuery UI, tais como o DatePicker. -->
<link href="<c:url value="/css/ui-lightness/jquery-ui-1.10.3.custom.css" />" rel="stylesheet" media="all">

<div class="container" style="text-align: center">
    <h4 class="labelMaiuscula"><fmt:message key="dados.gerais.ocorrencia" /></h4>
</div>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../js/bootstrap.file-input.js"></script>
<script type="text/javascript" src="../js/jquery.MultiFile.js"></script>
<script type="text/javascript" src="<c:url value="/js/jquery-ui-1.10.3.custom.js"/>" ></script>
<script type="text/javascript" src="<c:url value="/js/jquery.meio.mask.js"/>" ></script>

    <div class="row">
        <div class="form-group col-md-12">
            <label for="local" class="labelMaiuscula">
            	<fmt:message key="local" />
            </label>
            <input type="text" name='relprev.local' value="${relprev.local}" class="form-control" id="local"/>
        </div>
    </div>        
    <div class="row">
        <div class="form-group col-md-4">
            <label for="data" class="labelMaiuscula">
            	<fmt:message key="data" />
            </label>
            <div class="input-group">
                <input type="text" class="form-control calendario" id="data"  value="${relprev.data}"/>
                <span class="input-group-btn">
                    <button type="button" class="btn btn-default">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </button>
                </span>
            </div>
        </div>
        <div class="form-group col-md-4">
            <label for="hora" class="labelMaiuscula">
            	<fmt:message key="hora" />
            </label>
            <div class="input-group">
                <input type="text" class="form-control hora" id="hora"  value="${relprev.hora}"/>
                <span class="input-group-btn">
                    <button type="button" class="btn btn-default">
                        <span class="glyphicon glyphicon-time"></span>
                    </button>
                </span>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-12">
            <label for="pessoalEnvolvido" class="labelMaiuscula">
            	<fmt:message key="pessoal.envolvido" />
            </label>
            <input type="text" name="relprev.pessoalEnvolvido" class="form-control" id="pessoalEnvolvido"
            	 value="${relprev.pessoalEnvolvido}"/>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-12">
            <label for="situacao" class="labelMaiuscula">
            	<fmt:message key="situacao" />
            </label>
            <textarea class="form-control" name="relprev.situacao"  value="${relprev.situacao}" rows="6" id="situacao"></textarea>
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-12">
            <label for="enviarArquivo" class="labelMaiuscula" style="display:block">
            	<fmt:message key="enviar.arquivo" />
            </label>                            
            	<input id="enviarArquivo" type="file" title="Selecionar.." multiple name="files[]" >
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-12">
            <label for="relator" class="labelMaiuscula">
            	<fmt:message key="relator" />
            </label>
            <input type="text" name="relprev.relator.nome" class="form-control" id="relator">
        </div>
    </div>
    <div class="row">
        <div class="form-group col-md-12">
            <label for="contato" class="labelMaiuscula">
            	<fmt:message key="email.telefone" />
            </label>
            <input type="text" name="relprev.relator.contato" class="form-control" id="contato">
        </div>
    </div>
    <hr/>
<script type="text/javascript">	
	$(function(){		
		$("#enviarArquivo").MultiFile({
			STRING:{
				remove:'<span class="glyphicon glyphicon-remove"></span>',
				duplicate:'Arquivo já selecionado:\n$file!'
			}
		}); 
	});
</script>

<%@include file="../../partials/calendario.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link href="<c:url value="/css/relprev.css" />" rel="stylesheet">

<!-- Estilos para os componentes do jQuery UI, tais como o DatePicker. -->
<link href="<c:url value="/css/ui-lightness/jquery-ui-1.10.3.custom.css" />" rel="stylesheet" media="all">

<div class="container" style="text-align: center">
    <h4 class="labelMaiuscula"><fmt:message key="dados.gerais.ocorrencia"/></h4>
</div>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script type="text/javascript" src="<c:url value="/js/bootstrap.file-input.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.MultiFile.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/jquery-ui-1.10.3.custom.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.meio.mask.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/relprev.relatorio.js"/>"></script>
<input name="relatorioPrevencao.id" type="hidden" value="${ relatorioPrevencao.id }" />
<div class="row">
    <div class="form-group col-md-12">
        <label for="local" class="labelMaiuscula">
            <fmt:message key="local"/>
        </label>
        <input type="text" name='relatorioPrevencao.local' value="${relatorioPrevencao.local}" class="form-control"
               id="local"/>
    </div>
</div>
<div class="row">
	<input name="relatorioPrevencao.dataSituacaoPerigosa" type="hidden" value="${relatorioPrevencao.dataSituacaoPerigosa}"/>
    <div class="form-group col-md-4">
        <label for="dataSituacaoPerigosa" class="labelMaiuscula">
            <fmt:message key="data"/>
        </label>

        <div class="input-group">
        	<fmt:setLocale value="pt_BR"/>
            <input type="text" class="form-control calendario" id="dataSituacaoPerigosa"
                   name="relatorioPrevencao.dataFormatadaSituacaoPerigosa"
                   value="<fmt:formatDate pattern="dd/MM/yyyy" value="${relatorioPrevencao.dataSituacaoPerigosa}" />"/>
        </div>        
    </div>
    <div class="form-group col-md-4">
        <label for="hora" class="labelMaiuscula">
            <fmt:message key="hora"/>
        </label>

        <div class="input-group">
            <input type="text" class="form-control hora" id="hora"
                   value="<fmt:formatDate timeStyle="short" value="${relatorioPrevencao.dataSituacaoPerigosa}" pattern="HH:mm" />"/>
        </div>
    </div>
</div>
<div class="row">
    <div class="form-group col-md-12">
        <label for="pessoalEnvolvido" class="labelMaiuscula">
            <fmt:message key="pessoal.envolvido"/>
        </label>
        <input type="text" name="relatorioPrevencao.envolvidos" class="form-control" id="pessoalEnvolvido"
               value="${relatorioPrevencao.envolvidos}"/>
    </div>
</div>
<div class="row">
    <div class="form-group col-md-12">
        <label for="descricaoSituacaoPerigosa" class="labelMaiuscula">
            <fmt:message key="situacao"/>
        </label>
        <textarea class="form-control" name="relatorioPrevencao.descricaoSituacaoPerigosa"
                  rows="6" id="descricaoSituacaoPerigosa">${relatorioPrevencao.descricaoSituacaoPerigosa}</textarea>
    </div>
</div>
<div class="row">
    <div class="form-group col-md-12">
        <label for="enviarArquivo" class="labelMaiuscula" style="display:block">
            <fmt:message key="enviar.arquivo"/>
        </label>
        <input id="enviarArquivo" type="file" title="Selecionar.." multiple name="files[]">
    </div>
</div>

<div class="row">
    <div class="form-group col-md-12">
        <h3><fmt:message key="anexos"/></h3>
        <ul>
            <c:forEach items="${relatorioPrevencao.anexos}" var="anexo">
                <li>
                    <a href="<c:url value='/cdn/${relatorioPrevencao.id}/${anexo.pathAnexo}'/>">${anexo.pathAnexo} </a>
                </li>
            </c:forEach>
        </ul>
    </div>
</div>

<div class="row">
    <div class="form-group col-md-12">
        <label for="relator" class="labelMaiuscula">
            <fmt:message key="relator"/>
        </label>
        <input type="text" name="relatorioPrevencao.relator.nome" class="form-control" id="relator"
               value="${relatorioPrevencao.relator.nome}">
    </div>
</div>
<div class="row">
    <div class="form-group col-md-12">
        <label for="telefoneCelular" class="labelMaiuscula">
            <fmt:message key="telefone.celular"/>
        </label>
        <input type="text" name="relatorioPrevencao.relator.telefoneCelular" class="form-control telefone"
               id="telefoneCelular"
               value="${relatorioPrevencao.relator.telefoneCelular}">
    </div>
    <div class="form-group col-md-12">
        <label for="telefoneResidencial" class="labelMaiuscula">
            <fmt:message key="telefone.residencial"/>
        </label>
        <input type="text" name="relatorioPrevencao.relator.telefoneResidencial" class="form-control telefone"
               id="telefoneResidencial"
               value="${relatorioPrevencao.relator.telefoneResidencial}">
    </div>
    <div class="form-group col-md-12">
        <label for="email" class="labelMaiuscula">
            <fmt:message key="email"/>
        </label>
        <input type="text" name="relatorioPrevencao.relator.email" class="form-control" id="email"
               value="${relatorioPrevencao.relator.email}">
    </div>
</div>
<hr/>
<script type="text/javascript">
    $(function () {
        $("#enviarArquivo").MultiFile({
            STRING: {
                remove: '<span class="glyphicon glyphicon-remove"></span>',
                duplicate: 'Arquivo já selecionado:\n$file!'
            }
        });
    });
</script>

<%@include file="../../partials/calendario.jsp" %>
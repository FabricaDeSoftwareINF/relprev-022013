<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<t:template>
    <jsp:attribute name="titulo">
        Últimos Relatórios - RELPREV
    </jsp:attribute>
    <jsp:body>
        <h4><fmt:message key="ultimosrelatorio.ultimos" /></h4>
        <hr/>
        <a href="#">
            <div class="item-relatorio row">
                <div class="col-md-2">Data: 01/01/2013</div>
                <div class="col-md-2">Hora: 17h39</div>
                <div class="col-md-8">Situação: Pegaram meu checklist no bolso do meu anti-g e colocaram outro</div>
                <div class="col-md-2">Local: SBAN</div>
                <div class="col-md-4">Pessoal envolvido: Cap. João</div>
            </div>
        </a>
        <a href="#">
            <div class="item-relatorio row">
                <div class="col-md-2">Data: 01/01/2013</div>
                <div class="col-md-2">Hora: 17h39</div>
                <div class="col-md-8">Situação: Pegaram meu checklist no bolso do meu anti-g e colocaram outro</div>
                <div class="col-md-2">Local: SBAN</div>
                <div class="col-md-4">Pessoal envolvido: Cap. João</div>
            </div>
        </a>
    </jsp:body>
</t:template>
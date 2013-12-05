<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>  
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
        
        <c:forEach var="relprev" varStatus="status" items="${relatorioPrevencaoList}">
        <a href="<c:url value="/relatorio/dadosgerais/${relprev.id}"/>">
          <div class="item-relatorio row">            
                <div class="col-md-2">
                Data: <fmt:formatDate type="date" value="${relprev.dataSituacaoPerigosa}" dateStyle="short" />
                </div>
                <div class="col-md-2">
                Hora: <fmt:formatDate pattern="HH:mm" value="${relprev.dataSituacaoPerigosa}" /></div>
                <div class="col-md-8">Situação: "${relprev.descricaoSituacaoPerigosa}"</div>
                <div class="col-md-2">Local: "${relprev.local}"</div>
                <div class="col-md-4">Pessoal envolvido: "${relprev.envolvidos}"</div>
            </div>            
        </a>
        </c:forEach>
    </jsp:body>
</t:template>
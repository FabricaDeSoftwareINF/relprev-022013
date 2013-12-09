<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<t:template>
    <jsp:attribute name="titulo">
        <fmt:message key="ultimosrelatorio.ultimos" /> - <fmt:message key="relprev" /> 
    </jsp:attribute>
    <jsp:body>
        <h4><fmt:message key="ultimosrelatorio.ultimos" /></h4>
        <hr/>
        
        <c:forEach var="item" varStatus="status" items="${relatorioPrevencaoList}">
        <fmt:setLocale value="pt_BR" />
        <a href="<c:url value="/relatorio/dadosgerais/${item.id}"/>">
          <div class="item-relatorio row">         
                <div class="col-md-2">
                <fmt:message key="data" />: <fmt:formatDate type="both" dateStyle="full" value="${item.dataSituacaoPerigosa}" pattern="dd/MM/yyyy" />
                </div>
                <div class="col-md-2">
                <fmt:message key="hora" />: <fmt:formatDate pattern="HH:mm" value="${item.dataSituacaoPerigosa}" /></div>
                <div class="col-md-8">Situação: "${item.descricaoSituacaoPerigosa}"</div>
                <div class="col-md-2">Local: "${item.local}"</div>
                <div class="col-md-4">Pessoal envolvido: "${item.envolvidos}"</div>
            </div>            
        </a>
        </c:forEach>
    </jsp:body>
</t:template>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<t:template>
    <jsp:attribute name="titulo">
        Usu�rios - RELPREV
    </jsp:attribute>
    <jsp:body>
        <div class="labelMaiuscula">
            <div class="text-center tituloPagina">
                <label><fmt:message key="usuario.identificacao" /></label>
            </div>

            <div class="row">
                <a href="<c:url value="/configuracoes/novoUsuario"/>" class="btn btn-default active col-md-1" role="button">
                    <fmt:message key="novo" />
                </a>
            </div>
        </div>

        <hr/>

        <a href="#">
            <div class="item-relatorio">
                <div class="row">
                    <div class="col-md-3">
                        <fmt:message key="usuario.tipo" />:
                    </div>
                    <div class="col-md-3">
                        <fmt:message key="usuario.posto" />:
                    </div>
                    <div class="col-md-3">
                        <fmt:message key="funcao" />:
                    </div>
                    <div class="col-md-3">
                        <fmt:message key="usuario.telefone" />:
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-3">
                        <fmt:message key="usuario.nome" />:
                    </div>
                    <div class="col-md-3">
                        <fmt:message key="funcao" />:
                    </div>
                    <div class="col-md-3">
                        <fmt:message key="usuario.siglasecao" />:
                    </div>
                </div>

            </div>
        </a>
    </jsp:body>

</t:template>
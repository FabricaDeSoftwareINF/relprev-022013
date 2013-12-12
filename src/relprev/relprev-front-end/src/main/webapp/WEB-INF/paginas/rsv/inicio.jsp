<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<t:template>
    <jsp:attribute name="titulo">
        RSV - RELPREV
    </jsp:attribute>
    <jsp:body>
        <div class="labelMaiuscula">
            <div class="text-center tituloPagina">
                <label><fmt:message key="rsv.recomendacao" /></label>
            </div>

            <div class="row">
                <a href="<c:url value="/rsv/novo"/>" class="btn btn-default active col-md-1" role="button">
                    <fmt:message key="novo" />
                </a>

                <div class="col-md-2">
                    <select class="form-control">
                        <option><fmt:message key="rsv.recebido" /></option>
                    </select>
                </div>
            </div>
        </div>
        <hr/>

        <div class="item-relatorio row">
            <a href="#">
                <div class="col-md-6">
                    <div class="row">

                        <div class="col-md-12">001/ 1GDA / 2013</div>

                        <div class="col-md-12 textoOverflowEllipsis">
                            RSV: O chefe do setor de material deverá de imediato estabelecer o procedimento
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="col-md-4">
                        <input type="checkbox" checked="true" onclick="return false;"> <fmt:message key="rsv.encaminhado" />

                    </div>
                    <div class="col-md-4">
                        <input type="checkbox" onclick="return false;"> <fmt:message key="rsv.recebido" />

                    </div>
                    <div class="col-md-4">
                        <input type="checkbox" onclick="return false;"> <fmt:message key="rsv.finalizado" />

                    </div>

                    <div class="col-md-4">
                        <input type="checkbox" onclick="return false;"> <fmt:message key="rsv.respondido" />
                    </div>

                    <div class="col-md-8">
                        <input type="checkbox" onclick="return false;"> <fmt:message key="rsv.respostarecebida" />
                    </div>
                </div>
            </a>
        </div>
    </jsp:body>

</t:template>

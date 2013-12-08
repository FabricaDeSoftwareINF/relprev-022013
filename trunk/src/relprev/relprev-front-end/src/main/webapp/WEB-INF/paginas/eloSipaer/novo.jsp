<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<t:template>

    <div class="labelMaiuscula">
        <div class="text-center tituloPagina">
            <label><fmt:message key="elo.identificacao" /></label>
        </div>
        <hr/>


        <div class="row">
            <div class="form-group col-md-6">
                <label><fmt:message key="elo.organizacao" /></label>
                <input type="text" class="form-control">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-6">
                <label><fmt:message key="elo.siglaorganizacao" /></label>
                <input type="text" class="form-control">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-2">
                <label><fmt:message key="elo.posto" /></label>
                <input type="text" class="form-control">
            </div>
            <div class="form-group col-md-5">
                <label><fmt:message key="elo.nome" /></label>
                <input type="text" class="form-control">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-3">
                <label><fmt:message key="funcao" /></label>
                <input type="text" class="form-control">
            </div>
            <div class="form-group col-md-4">
                <label><fmt:message key="elo.siglasecao" /></label>
                <input type="text" class="form-control">
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-3">
                <label><fmt:message key="elo.telefone" /></label>
                <input type="text" class="form-control">
            </div>
            <div class="form-group col-md-4">
                <label><fmt:message key="elo.email" /></label>
                <input type="text" class="form-control">
            </div>
        </div>
    </div>
    <hr/>

    <div class="container" style="max-width: 200px; margin-bottom: 20px; margin-top: 50px;">
        <button type="submit" class="btn btn-primary">
            <fmt:message key="salvar" />
        </button>
        <button class="btn btn-default">
            <fmt:message key="cancelar" />
        </button>
    </div>
</t:template>
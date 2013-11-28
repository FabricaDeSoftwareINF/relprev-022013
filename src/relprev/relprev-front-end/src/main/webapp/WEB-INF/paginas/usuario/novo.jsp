<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<t:template>

    <div class="labelMaiuscula">
        <div class="text-center tituloPagina">
            <label><fmt:message key="usuario.identificacao" /></label>
        </div>
        <hr/>


        <div class="row">
            <div class="form-group col-md-3">
                <label><fmt:message key="usuario.tipo" /></label>
                <select class="form-control">
                    <option>SUPERVISOR</option>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-2">
                <label><fmt:message key="usuario.posto" /></label>
                <input type="text" class="form-control">
            </div>
            <div class="form-group col-md-5">
                <label><fmt:message key="usuario.nome" /></label>
                <input type="text" class="form-control">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-3">
                <label><fmt:message key="usuario.funcao" /></label>
                <input type="text" class="form-control">
            </div>
            <div class="form-group col-md-4">
                <label><fmt:message key="usuario.siglasecao" /></label>
                <input type="text" class="form-control">
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-3">
                <label><fmt:message key="usuario.telefone" /></label>
                <input type="text" class="form-control">
            </div>
            <div class="form-group col-md-4">
                <label><fmt:message key="usuario.email" /></label>
                <input type="text" class="form-control">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-3">
                <label><fmt:message key="usuario.login" /></label>
                <input type="text" class="form-control">
            </div>
            <div class="form-group col-md-3">
                <label><fmt:message key="usuario.senha" /></label>
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
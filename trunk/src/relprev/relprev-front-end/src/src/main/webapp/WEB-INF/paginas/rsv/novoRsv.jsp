<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<t:template>

    <div class="labelMaiuscula">
        <div class="text-center">
            <label><fmt:message key="rsv.recomendacao" /></label>
        </div>
        <hr/>


        <div class="row">
            <div class="form-group col-md-1">
                <label><fmt:message key="rsv.classe" /></label>
                <select class="form-control">
                    <option>0</option>
                </select>
            </div>

            <div class="form-group col-md-1">
                <label><fmt:message key="rsv.numero" /></label>
                <input type="text" class="form-control">
            </div>

            <div class="form-group col-md-1">
                <label><fmt:message key="rsv.prazo" /></label>
                <select class="form-control">
                    <option>A</option>
                </select>
            </div>

            <div class="form-group col-md-1">
                <label><fmt:message key="rsv.ano" /></label>
                <input type="text" class="form-control">
            </div>

            <div class="form-group col-md-2">
                <label><fmt:message key="rsv.elosipaer" /></label>
                <input type="text" class="form-control">
            </div>

            <div class="form-group col-md-2 pull-right">
                <label><fmt:message key="rsv.emitida" /></label>
                <input type="text" class="form-control">
            </div>
        </div>

        <hr/>

        <div class="row">
            <div class="form-group col-md-6">
                <label><fmt:message key="rsv.ao" /></label>
                <input type="text" class="form-control">
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label><fmt:message key="rsv.rsv" /></label>
                <textarea class="form-control" rows="5"></textarea>
            </div>
        </div>

        <hr/>

        <div class="row">
            <div class="form-group col-md-2">
                <label for="data">
                    <fmt:message key="rsv.emissao" />
                </label>
                <div class="input-group">
                    <input type="text" class="form-control" id="emissao">
                    <span class="input-group-btn">
                        <button type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-calendar"></span>
                        </button>
                    </span>
                </div>
            </div>

            <div class="form-group col-md-2">
                <label for="data">
                    <fmt:message key="rsv.recebimento" />
                </label>
                <div class="input-group">
                    <input type="text" class="form-control" id="recebimento">
                    <span class="input-group-btn">
                        <button type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-calendar"></span>
                        </button>
                    </span>
                </div>
            </div>

            <div class="form-group col-md-2">
                <label for="data" class="labelMaiuscula">
                    <fmt:message key="rsv.cumprida" />
                </label>
                <div class="input-group">
                    <input type="text" class="form-control" id="cumprida">
                    <span class="input-group-btn">
                        <button type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-calendar"></span>
                        </button>
                    </span>
                </div>
            </div>

            <div class="form-group col-md-3">
                <label><fmt:message key="rsv.documentodeorigem" /></label>
                <input type="text" class="form-control">
            </div>
        </div>

        <div class="row">
            <div class="col-md-2">
                <label>
                    <input type="checkbox" value="">
                    <fmt:message key="rsv.encaminhado" />
                </label>
            </div>

            <div class="col-md-2">
                <label>
                    <input type="checkbox" value="">
                    <fmt:message key="rsv.recebido" />
                </label>
            </div>

            <div class="col-md-2">
                <label>
                    <input type="checkbox" value="">
                    <fmt:message key="rsv.respostarecebida" />
                </label>
            </div>

            <div class="col-md-2">
                <label>
                    <input type="checkbox" value="">
                    <fmt:message key="rsv.respondido" />
                </label>
            </div>

            <div class="col-md-2">
                <label>
                    <input type="checkbox" value="">
                    <fmt:message key="rsv.finalizado" />
                </label>
            </div>

        </div>
    </div>

    <div class="pull-right">
        <button type="button" class="btn btn-default">Impressão</button>
    </div>

    <div class="container" style="max-width: 200px; margin-bottom: 20px; margin-top: 50px;">
        <button type="submit" class="btn btn-primary">
            <fmt:message key="salvar" />
        </button>
        <button class="btn btn-default">
            <fmt:message key="cancelar" />
        </button>
    </div>
</t:template>
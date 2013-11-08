<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title><fmt:message key="relprev" /></title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Bootstrap -->
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/relprev.css" rel="stylesheet">
    </head>
    <body>
        <div id="borda" class="container">
            <div class="container" style="max-width: 800px;">
                <div class="container"  id="titulo" style="text-align: center">
                    <h1 class="labelMaiuscula"><fmt:message key="relatorio.prevencao" /></h1>
                </div>
                
                <div id="aviso">
                    De acordo com as regulamentações brasileiras, este relato (ou parte dele) <b>somente será usado para a 
                    prevenção de acidentes aeronáuticos</b>, a fim de aumentar a segurança operacional. Este relato não precisa
                    ser identificado, se o for, o relator será informado sobre as medidas adotadas.
                </div>
                
                <hr/>
                <div class="container" style="text-align: center">
                    <h4 class="labelMaiuscula"><fmt:message key="dados.gerais.ocorrencia" /></h4>
                </div>
                <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
                <script src="http://code.jquery.com/jquery.js"></script>
                <!-- Include all compiled plugins (below), or include individual files as needed -->
                <script src="../js/bootstrap.min.js"></script>
                <script src="../js/bootstrap.file-input.js"></script>

                <form action="<c:url value='/relatorio/salvar'/>" method="post" enctype="multipart/form-data">
					<% String relprev = "relprev"; %>
					
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label for="local" class="labelMaiuscula">
                            	<fmt:message key="local" />
                            </label>
                            <input type="text" name='<%=relprev%>.local' class="form-control" id="local">
                        </div>
                    </div>
                    
                    <div class="row">
                        <div class="form-group col-md-4">
                            <label for="data" class="labelMaiuscula">
                            	<fmt:message key="data" />
                            </label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="data">
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
                                <input type="text" class="form-control" id="hora">
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
                            <input type="text" name="<%= relprev %>.pessoalEnvolvido" class="form-control" id="pessoalEnvolvido">
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label for="situacao" class="labelMaiuscula">
                            	<fmt:message key="situacao" />
                            </label>
                            <textarea class="form-control" name="<%= relprev %>.situacao" rows="6" id="situacao"></textarea>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label for="enviarArquivo" class="labelMaiuscula" style="display:block">
                            	<fmt:message key="enviar.arquivo" />
                            </label>                            
                            	<input type="file" class="btn-info" title="Selecionar.." name="files[]" multiple id="enviarArquivo">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label for="relator" class="labelMaiuscula">
                            	<fmt:message key="relator" />
                            </label>
                            <input type="text" name="<%= relprev %>.relator.nome" class="form-control" id="relator">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label for="contato" class="labelMaiuscula">
                            	<fmt:message key="email.telefone" />
                            </label>
                            <input type="text" name="<%= relprev %>.relator.contato" class="form-control" id="contato">
                        </div>
                    </div>
                    <hr/>
                    <div class="container" style="max-width: 200px; margin-bottom: 20px;">
                        <button type="submit" class="btn btn-primary">
                        	<fmt:message key="enviar" />
                        </button>
                        <button type="reset" class="btn btn-default">
                        	<fmt:message key="limpar" />
                        </button>
                    </div>
                </form>
            </div>
        </div>
        
        <script type="text/javascript">
        	$(function(){
        		$('input[type=file]').bootstrapFileInput();
        	});
        </script>
    </body>
</html>
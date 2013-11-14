<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Template" pageEncoding="UTF-8"%>
<%@attribute name="titulo" fragment="true" %>
<html>
    <head>
        <title><jsp:invoke fragment="titulo"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet" media="all">
        <link href="<c:url value="/css/relprev.css"/>" rel="stylesheet" media="all">
        <link href="<c:url value="/css/menu-superior.css" />" rel="stylesheet" media="all">
        <link href="<c:url value="/css/site.css" />" rel="stylesheet" media="all">
        <script type="text/javascript" src="<c:url value="/js/jquery-2.0.3.js"/>" ></script>
        <script type="text/javascript" src="<c:url value="/js/utilitarios.js"/>" ></script>
        <script type="text/javascript" src="<c:url value="/js/bootstrap.min.js"/>" ></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <jsp:include page="/WEB-INF/paginas/inicio/menuSuperior.jsp"/>
        <div id="body" class="container">
            <jsp:doBody/>
        </div>
    </body>
</html>
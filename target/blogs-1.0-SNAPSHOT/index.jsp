<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Aviso"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Aviso> aviso=(ArrayList<Aviso>) request.getAttribute("aviso");
    %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
        .contenido {

    width: 500px;

}
    </style>
</head>
<body>
    <h1>BLOG DE TECNOLOGIA</h1>
    <p>Autor: Wilson Ariel Callizaya Mamani</p>
    <a href="inicio?action=add">Nueva entrada</a>
    <table cellspacing="1">
        
        <c:forEach var="item" items="${aviso}">
            <tr>
                <td><big><u>${item.titulo}</u></td>
            </tr>
            <tr>
                <td>${item.fecha}</td>                
            </tr>           
            <tr>
                <td><div class="contenido"><p>${item.contenido}</p></div></td>
            </tr>
            <tr><td><a href="inicio?action=edit&id=${item.id}">Editar</a>
                    <a href="inicio?action=delete&id=${item.id}">Eliminar</a></td></tr>
        </c:forEach>
    </table>
</body>
</html>
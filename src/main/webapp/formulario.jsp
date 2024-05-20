<%@page import="com.emergentes.modelo.Aviso"%>
<%
    Aviso avisos = (Aviso) request.getAttribute("aviso");
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro de Blog</h1>
        <form action="inicio" method="post">
            <input type="hidden" name="id" value="${aviso.id}"><br>
            <label>Titulo</label>
            <input type="text" name="titulo" value="${aviso.titulo}" /><br>
            <label>Fecha</label>
            <input type="date" name="fecha" value="${aviso.fecha}" /><br>
            
            <label>Contenido</label><br>
            <textarea name="contenido" rows="10" cols="50">${aviso.contenido}</textarea><br>
            
            <button type="submit">Enviar</button>
        </form>
    </body>
</html>

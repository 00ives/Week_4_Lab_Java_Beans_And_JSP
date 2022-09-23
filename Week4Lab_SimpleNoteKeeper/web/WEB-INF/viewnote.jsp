<%-- 
    Document   : viewnote
    Created on : 22-Sep-2022, 7:34:02 PM
    Author     : ivorl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <div>
            <b>Title:</b>

            ${note.title}

            <br><br>

            <div><b>Content:</b></div>

            <div>${note.content}</div>

        </div>
        <br>

        <a href="note?edit" name="edit">Edit</a>
    </body>
</html>

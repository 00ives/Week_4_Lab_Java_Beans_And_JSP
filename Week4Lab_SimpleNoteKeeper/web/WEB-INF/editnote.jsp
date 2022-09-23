<%-- 
    Document   : editnote
    Created on : 22-Sep-2022, 7:34:19 PM
    Author     : ivorl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form method="post" action="note">

            Title: <input type="text" name="titleText">
            <br>
            Content: <textarea name="contentText" rows="6" cols="25">Contents go here</textarea>
            <br>
            <input type="submit" name="saveNote" >

        </form>

    </body>
</html>

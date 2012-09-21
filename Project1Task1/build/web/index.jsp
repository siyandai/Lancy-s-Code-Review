<%-- 
    Document   : index
    Created on : Sep 9, 2012, 9:37:53 PM
    Author     : Lancy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Please enter the text below:<br /></h1>
        <form action="ComputeHashes" method="get">
            <input type="text" name="stringText" value=""><br />
            <input type="radio" name="hashFunction" value="MD5" checked /> MD5<br />
            <input type="radio" name="hashFunction" value="SHA-1" /> SHA-1<br />
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>

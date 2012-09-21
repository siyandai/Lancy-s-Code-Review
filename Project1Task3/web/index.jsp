<%-- 
    Document   : index
    Created on : Sep 14, 2012, 6:45:30 PM
    Author     : Lancy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML Basic 1.1//EN"
    "http://www.w3.org/TR/xhtml-basic/xhtml-basic11.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Please enter a string and I will tell you whether it is a palindrome or not:</h1>
        <form action="Palin" method="get">
            <input type="text" name="stringText" value=""><br />
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>

<%-- 
    Document   : index
    Created on : Sep 14, 2012, 9:42:40 AM
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
        <h1><center>Big Integer Calculator</center></h1>
        <p>Please input two integers and operation type:</p>
        <form action="BigCalc" method="GET">
            <label for="integerX">Integer X</label>
            <input type="text" name="integerX" value="" /><br />
            <label for="integerY">Integer Y</label>
            <input type="text" name="integerY" value="" /><br />
            <label for="operationType">Operation Type</label>
            <select name="operationType">
                <option value="add">add</option>
                <option value="multiply">multiply</option>
                <option value="relativePrime">relative prime</option>
                <option value="mod">mod</option>
                <option value="modInverse">mod inverse</option>
                <option>power</option>
            </select><br />
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>

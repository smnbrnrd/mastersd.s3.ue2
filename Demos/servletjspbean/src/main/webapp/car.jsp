<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>Car Details</title>
    </head>
    <body>
        <jsp:useBean id="car" class="fr.urn.sime.servletjspbean.Car" scope="request">
            <p> No model specified. Default model used instead </p>
        </jsp:useBean>
        <h1>Car Details</h1>
        <table>
            <tr><td>Model:</td><td><jsp:getProperty name="car" property="model" /></td></tr>
            <tr><td>Speed:</td><td><jsp:getProperty name="car" property="speed" /></td></tr>
        </table>
        <a href="index.jsp">Back to Home</a>
    </body>
</html>
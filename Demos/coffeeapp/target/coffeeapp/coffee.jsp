<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Informations sur le café</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
        <style>
            body {
                font-family: 'Roboto', sans-serif;
            }
            h1 {
                color: #333;
            }
        </style>
    </head>
    <body>
        <main class="container">
            <jsp:useBean id="coffee" class="fr.urn.sime.coffeeapp.Coffee" scope="request"/>
            <h1>Your coffee is served</h1>
            <ul>
                <li>Type : <jsp:getProperty name="coffee" property="type"/></li>
                <li>Strength : <jsp:getProperty name="coffee" property="strength"/></li>
                <li>Sugar : <jsp:getProperty name="coffee" property="sugar"/></li>
            </ul>
        </main>
    </body>
</html>
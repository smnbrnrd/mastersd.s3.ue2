<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>Car Details</title>
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
            <h1>Welcome to the Coffee Shop App</h1>
            <p>You can ask for a filter coffee or an espresso. Make your choice below:</p>
            <a class="btn btn-primary mt-4" href="selection?coffeeType=filter">Filter</a>
            <a class="btn btn-primary mt-4" href="selection?coffeeType=espresso">Espresso</a>
        </main>
    </body>
</html>
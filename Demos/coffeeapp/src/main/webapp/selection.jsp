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
            <h1>Select Your Coffee</h1>
            <form action="coffee" method="post">
                <div class="form-group">
                    <label for="strength">Strength (1-5):</label>
                    <input type="number" class="form-control" id="strength" name="strength" min="1" max="5" value="5">
                </div>
                <div class="form-group">
                    <label for="sugar">Sugar (0-5):</label>
                    <input type="number" class="form-control" id="sugar" name="sugar" min="0" max="5" value="0">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            <p class="mt-4"><a href="index.jsp" class="btn btn-secondary">Back to Home</a></p>
        </main>
    </body>
</html>
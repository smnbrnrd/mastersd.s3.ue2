<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <title>Car Details</title>
    </head>
    <body>
       <h1>Welcome to the Car Details Page</h1>
       <form action="car" method="get">
           <label for="model">Car Model:</label>
           <input type="text" id="model" name="model" />
           <br />
           <label for="speed">Car Speed:</label>
           <input type="text" id="speed" name="speed" />
           <br />
           <input type="submit" value="Submit" />
       </form>
    </body>
</html>
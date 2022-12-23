<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Ripristino Password</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap">
  <link rel="stylesheet" href="style.css">
  <% if(response.containsHeader("passwordDimenticata")) { %>
  <h1 align = "center"> <font color = #FF0000> <%= response.getHeader("passwordDimenticata")%></font></h1>
  <% } %>
</head>
<body>
<form id = "ripristinoPassword" method = "POST" action = "ripristinoPasswordServlet" >
  <label>Codice Fiscale</label>
  <input type = "text" name = "codFis"/>
  <label>Email</label>
  <input type = "text" name = "email"/>
  <label>Password</label>
  <input type = "password" name = "password"/>
  <input type = "submit" id = "invia" value = "Login"/>
  <br>
  <a href="passwordDimenticata.jsp">Torna a Password Dimenticata</a>
  <br>
</form>
</body>
</html>
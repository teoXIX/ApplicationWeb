<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Login</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap">
  <link rel="stylesheet" href="style.css">
  <% if(response.containsHeader("registrazione")) { %>
  <h1 align = "center"> <font color = #FF0000> <%= response.getHeader("registrazione")%></font></h1>
  <% } %>
  <% if(response.containsHeader("login")) { %>
  <h1 align = "center"> <font color = #FF0000> <%= response.getHeader("login")%></font></h1>
  <% } %>
  <% if(response.containsHeader("passwordDimenticata")) { %>
  <h1 align = "center"> <font color = #FF0000> <%= response.getHeader("passwordDimenticata")%></font></h1>
  <% } %>
  <% if(response.containsHeader("form")) { %>
  <h1 align = "center"> <font color = #FF0000> <%= response.getHeader("form")%></font></h1>
  <% } %>
</head>
<body>
<form id = "login" method = "POST" action = "LoginServlet" >
  <h1 align = "center">BENVENUTI NELLA PAGINA DI LOGIN</h1>
  <label>Codice Fiscale</label>
  <input type = "text" name = "codFis"/>
  <label>Password</label>
  <input type = "password" name = "password"/>

  <input type = "submit" id = "invia" value = "Login"/>
  <br>
  <a href="index.jsp">Torna a Registrazione</a>
  <br>
</form>
<button onclick = "location.href = 'passwordDimenticata.jsp'">Password Dimenticata?</button>
</body>
</html>
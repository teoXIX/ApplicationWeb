<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Password Dimenticata</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap">
  <link rel="stylesheet" href="style.css">
</head>
<body>
<form id = "passwordDimenticata" method = "POST" action = "passwordDimenticataServlet" >
  <h1 align = "center">CONTROLLO DATI PER RIPRISTINO PASSWORD</h1>
  <label>Nome</label>
  <input type = "text" name = "nome"/>
  <label>Cognome</label>
  <input type = "text" name = "cognome"/>
  <label>Codice Fiscale</label>
  <input type = "text" name = "codFis"/>
  <input type = "submit" id = "invia" value = "Login"/>
  <br>
  <a href="login.jsp">Torna a Login</a>
  <br>
</form>
</body>
</html>
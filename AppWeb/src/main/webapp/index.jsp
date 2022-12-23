<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Registrazione</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap">
    <link rel="stylesheet" href="style.css">
</head>
<% if(response.containsHeader("registrazione")) { %>
<h1 align = "center"> <font color = #FF0000> <%= response.getHeader("registrazione")%></font></h1>
<% } %>
<% if(response.containsHeader("login")) { %>
<h1 align = "center"> <font color = #FF0000> <%= response.getHeader("login")%></font></h1>
<% } %>
<body>
<form id = "registrazione" method = "POST" action = "RegistrazioneServlet" >
    <h1 align = "center">BENVENUTI NEL FORM DI REGISTRAZIONE</h1>
    <label>Nome</label>
    <input type = "text" name = "nome"/>
    <label>Cognome</label>
    <input type = "text" name = "cognome"/>
    <label>Codice Fiscale</label>
    <input type = "text" name = "codFis"/>
    <label>Password</label>
    <input type = "password" name = "password"/>

    <input type = "submit" id = "invia" value = "Registrati"/>
    <br>
    <a href="login.jsp">Torna a Login</a>
</form>
</body>
</html>
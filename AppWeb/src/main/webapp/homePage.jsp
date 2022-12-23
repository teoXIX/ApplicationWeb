<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="BusinessLogic.DBConnect, java.util.ArrayList, java.util.List, Oggetti.Form" %>
<!DOCTYPE html>
<html>
<head>
      <meta charset="ISO-8859-1">
      <title>Benvenuto</title>
      <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap">
      <link rel="stylesheet" href="style.css">
      <% if(response.containsHeader("registrazione")) { %>
      <h1 align = "center"> <font color = #FF0000> <%= response.getHeader("registrazione")%></font></h1>
      <% } %>
      <% if(response.containsHeader("passwordDimenticata")) { %>
      <h1 align = "center"> <font color = #FF0000> <%= response.getHeader("passwordDimenticata")%></font></h1>
      <% } %>
      <% if(response.containsHeader("form")) { %>
      <h1 align = "center"> <font color = #FF0000> <%= response.getHeader("form")%></font></h1>
      <% } %>
</head>
<body>
      <% if(session.getAttribute("codFis") != null){ %>
      <form id = "homePage" method = "POST" action = "FormServlet">
        <h1 align = "center"> BENVENUTO NELL'HOME PAGE <%= session.getAttribute("codFis") %></h1>
        <%	for(int i = 0; i < request.getCookies().length; i++){
          if(request.getCookies()[i].getName().equals("nome")){%>
        <%= request.getCookies()[i].getValue()%>
        <% }
          if(request.getCookies()[i].getName().equals("cognome")){%>
        <%= request.getCookies()[i].getValue()%>
        <% }
        }%>
        <label>Nome Utente</label>
        <input type = "text" name = "nomeUtente"/>
        <label>Casella di Testo</label>
        <input type = "text" name = "casellaTesto"/>
        <input type = "submit" id = "invia" value = "Invia">
      </form>

      <div id = "form">
        <table align = "center">
          <tr>
            <th>Nome Utente</th>
            <th>Descrizione</th>
          </tr>
          <%
            DBConnect db = new DBConnect();
            for(Form f : db.visualizzaForm()) { %>
          <tr>
            <th><%= f.getNomeUtente() %></th>
            <th><%= f.getDescrizione() %></th>
          </tr>
          <%}
          %>
        </table>
      </div>

      <form id = "homePage" method = "POST" action = "HomePageServlet">
        <input type = "submit" id = "invia1" value = "Logout" onclick = <%  session.invalidate(); %>>
      </form>
      <% } else{ %>
      <h1 align = "center"> DEVI PRIMA SUPERARE IL LOGIN PER VISUALIZZARE L'HOME PAGE </h1>
      <button onclick = "location.href = 'http://localhost:8080/Prenota_Lab/login.jsp'">Torna a Login</button>
      <% } %>
</body>
</html>
package Servlet;

import java.io.IOException;

import BusinessLogic.GestioneUtente;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Oggetti.Utente;

/**
 * Servlet implementation class RegistrazioneServlet
 */
@WebServlet("/RegistrazioneServlet") //descrive questa classe Java come una Servlet, ("/nomeservlet")
public class RegistrazioneServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public RegistrazioneServlet() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String codFis = request.getParameter("codFis");
        String password = request.getParameter("password");

        Utente u = new Utente(nome, cognome, codFis, password);
        GestioneUtente gu = new GestioneUtente();
        try {
            boolean registrazione = gu.addUtente(u);
            if(registrazione) {
                response.setHeader("registrazione", "Registrazione Avvenuta con SUCCESSO"); //parola chiave di avvenuta registrazione

                RequestDispatcher ris = request.getRequestDispatcher("/login.jsp");
                ris.forward(request, response);
            }
            else {
                response.setHeader("registrazione", "Utente gi� registrato"); //parola chiave di avvenuta registrazione

                RequestDispatcher ris = request.getRequestDispatcher("/index.jsp");
                ris.forward(request, response);
            }
        } catch (Exception e) {
            response.setHeader("registrazione", "Registrazione Fallita"); //parola chiave di avvenuta registrazione

            RequestDispatcher ris = request.getRequestDispatcher("/index.jsp");
            ris.forward(request, response);
        }
        //La comunicazione con il database

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response); //chiama il metodo doGet per non riscrivere la logica
    }

}

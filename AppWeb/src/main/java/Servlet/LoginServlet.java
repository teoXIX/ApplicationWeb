package Servlet;

import java.io.IOException;

import BusinessLogic.GestioneUtente;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Oggetti.Utente;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @throws IOException
     * @throws ServletException
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        String codFis = request.getParameter("codFis");
        String password = request.getParameter("password");
        Utente u = new Utente(null, null, codFis, password);
        GestioneUtente gu = new GestioneUtente();

        try{
            boolean login = gu.esisteUtenteLogin(u);
            if(login) {
                response.setHeader("login", "Login Avvenuto con SUCCESSO"); //parola chiave di avvenuta registrazione
                HttpSession session = request.getSession();
                session.setAttribute("codFis", codFis);
                session.setAttribute("password", password);
                RequestDispatcher ris = request.getRequestDispatcher("/homePage.jsp");
                ris.forward(request, response);
            }
            else {
                if(gu.getErrore() == "password") {
                    response.setHeader("login", "Password ERRATA"); //parola chiave di avvenuta registrazione

                    RequestDispatcher ris = request.getRequestDispatcher("/login.jsp");
                    ris.forward(request, response);
                }
                else
                    response.setHeader("login", "Utente non REGISTRATO"); //parola chiave di avvenuta registrazione

                RequestDispatcher ris = request.getRequestDispatcher("/index.jsp");
                ris.forward(request, response);
            }
        } catch(Exception e) {
            response.setHeader("login", "Login FALLITO"); //parola chiave di avvenuta registrazione

            RequestDispatcher ris = request.getRequestDispatcher("/index.jsp");
            ris.forward(request, response);
        }
        //interrogazione al DB

		/*HttpSession session = request.getSession();
		session.setAttribute("codFis", codFis); //salvare un valore all'interno della sessione chiave, valore
		session.setAttribute("nome", "pippo");
		session.setAttribute("cognome", "pluto");

		Cookie c = new Cookie("codfis", codFis);
		Cookie cname = new Cookie("nome", "pippo");
		Cookie ccognome = new Cookie("cognome", "pluto");
		response.addCookie(c);
		response.addCookie(cname);
		response.addCookie(ccognome);*/

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

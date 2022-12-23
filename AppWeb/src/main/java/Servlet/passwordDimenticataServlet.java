package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import BusinessLogic.DBConnect;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class passwordDimenticataServlet
 */
@WebServlet("/passwordDimenticataServlet")
public class passwordDimenticataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public passwordDimenticataServlet() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String codFis = request.getParameter("codFis");
        DBConnect db = new DBConnect();
        try {
            if(db.recuperoPassword(nome, cognome, codFis)) {
                response.setHeader("passwordDimenticata", "SUCCESSO, I TUOI DATI SONO CORRETTI");
                RequestDispatcher ris = request.getRequestDispatcher("/ripristinoPassword.jsp");
                ris.forward(request, response);
            }
            else {
                response.setHeader("passwordDimenticata", "FALLITO, I TUOI DATI SONO SBAGLIATI");
                RequestDispatcher ris = request.getRequestDispatcher("/login.jsp");
                ris.forward(request, response);
            }
        } catch (SQLException e) {
            response.setHeader("passwordDimenticata", "RECUPERO PASSWORD FALLITO");
            RequestDispatcher ris = request.getRequestDispatcher("/login.jsp");
            ris.forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

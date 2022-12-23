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
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ripristinoPasswordServlet
 */
@WebServlet("/ripristinoPasswordServlet")
public class ripristinoPasswordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public ripristinoPasswordServlet() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codFis = request.getParameter("codFis");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        DBConnect db = new DBConnect();
        try {
            db.inserisciEmailPassword(email, password, codFis);
            HttpSession session = request.getSession();
            session.setAttribute("codFis", codFis);
            session.setAttribute("password", password);
            response.setHeader("passwordDimenticata", "RECUPERO PASSWORD COMPLETATO");
            RequestDispatcher ris = request.getRequestDispatcher("/homePage.jsp");
            ris.forward(request, response);
        } catch (SQLException e) {
            response.setHeader("passwordDimenticata", "RECUPERO PASSWORD ERRATO");
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

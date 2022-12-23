package Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import BusinessLogic.DBConnect;

/**
 * Servlet implementation class Form
 */
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public FormServlet() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String textMessage = request.getParameter("casellaTesto");
        String nomeUtente = request.getParameter("nomeUtente");
        DBConnect db = new DBConnect();
        try {
            db.formData(textMessage, nomeUtente);
            HttpSession session = request.getSession();
            session.setAttribute("codFis", nomeUtente);
            response.setHeader("form", "FORM INVIATO CON SUCCESSO");
            RequestDispatcher ris = request.getRequestDispatcher("/homePage.jsp");
            ris.forward(request, response);
        }catch(Exception e) {
            e.getMessage();
            response.setHeader("form", "INVIO FORM FALLITO");
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

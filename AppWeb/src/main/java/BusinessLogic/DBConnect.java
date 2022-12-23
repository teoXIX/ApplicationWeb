

package BusinessLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Oggetti.Form;
import Oggetti.Utente;

public class DBConnect {

    private String jdbcURL = "jdbc:mysql://localhost:3306/appWeb?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";
    public List<Form> visualizzaForm() throws SQLException{
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        List<Form> forms = new ArrayList<Form>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            ps =  con.prepareStatement("Select * from form");
            rs = ps.executeQuery();
            while(rs.next()) {
                String nomeUtente = rs.getString("nomeUtente");
                String descrizione = rs.getString("descrizione");
                forms.add(new Form(nomeUtente, descrizione));
            }
        }
        catch (SQLException e) {
            throw new SQLException("visualizzaForm: " + e.getMessage());
        }
        catch (ClassNotFoundException e) {
            System.out.println("visualizzaForm " + e.getMessage());
            throw new ClassCastException("visualizzaForm: "+ e.getMessage());
        }
        finally {
            closeConnection(con, rs, ps);
        }
        return forms;
    }

    public void formData(String textMessage, String nomeUtente) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            ps =  con.prepareStatement("insert into form(nomeUtente, descrizione) values(?,?)");
            ps.setString(1, nomeUtente);
            ps.setString(2, textMessage);
            ps.executeUpdate();
        }
        catch (SQLException e) {
            throw new SQLException("formData: " + e.getMessage());
        }
        catch (ClassNotFoundException e) {
            System.out.println("formData " + e.getMessage());
            throw new ClassCastException("formData: "+ e.getMessage());
        }
        finally {
            closeConnection(con, null, ps);
        }
    }

    public boolean recuperoPassword(String nome, String cognome, String codFis) throws SQLException {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            ps =  con.prepareStatement("Select * from Utente where nome = ? and cognome = ? and codFis = ?");
            ps.setString(1, nome);
            ps.setString(2, cognome);
            ps.setString(3, codFis);
            rs = ps.executeQuery();
            return rs.next();
        }
        catch (SQLException e) {
            throw new SQLException("recuperoPassword: " + e.getMessage());
        }
        catch (ClassNotFoundException e) {
            System.out.println("recuperoPassword " + e.getMessage());
            throw new ClassCastException("recuperoPassword: "+ e.getMessage());
        }
        finally {
            closeConnection(con, rs, ps);
        }
    }

    public void inserisciEmailPassword(String email, String password, String codFis) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            ps =  con.prepareStatement("update utente set email = ?, password = ? where codFis = ?");
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, codFis);
            ps.executeUpdate();
        }
        catch (SQLException e) {
            throw new SQLException("inserisciEmailPassword: " + e.getMessage());
        }
        catch (ClassNotFoundException e) {
            System.out.println("inserisciEmailPassword " + e.getMessage());
            throw new ClassCastException("inserisciEmailPassword: "+ e.getMessage());
        }
        finally {
            closeConnection(con, null, ps);
        }
    }

    public boolean controlloLogin(String password) throws SQLException, ClassNotFoundException {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            ps =  con.prepareStatement("Select * from Utente where password=?");
            ps.setString(1, password);
            rs =  ps.executeQuery();
            return rs.next();

        }
        catch (SQLException e) {
            throw new SQLException("controlloLogin: " + e.getMessage());
        }
        catch (ClassNotFoundException e) {
            System.out.println("controlloLogin " + e.getMessage());
            throw new ClassCastException("controlloLogin: "+ e.getMessage());
        }
        finally {
            closeConnection(con, rs, ps);
        }
    }

    public boolean esisteUtente(String codFis) throws SQLException, ClassNotFoundException {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            ps =  con.prepareStatement("Select * from Utente where codFis=?");
            ps.setString(1, codFis);
            rs =  ps.executeQuery();
            return rs.next();

        }
        catch (SQLException e) {
            throw new SQLException("esisteUtente: " + e.getMessage());
        }
        catch (ClassNotFoundException e) {
            System.out.println("esisteUtente " + e.getMessage());
            throw new ClassCastException("esisteUtente: "+ e.getMessage());
        }
        finally {
            closeConnection(con, rs, ps);
        }
    }

    public void insertUtente(Utente u) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            ps=con.prepareStatement("Insert into utente(nome, cognome, codFis, password) values(?,?,?,?)");
            ps.setString(1,u.getNome());
            ps.setString(2, u.getCognome());
            ps.setString(3, u.getCodFis());
            ps.setString(4, u.getPassword());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("insert utente " + e.getMessage());
            throw new SQLException("Insert utente " + e.getMessage());
        }
        catch (ClassNotFoundException e) {
            System.out.println("insert utente " + e.getMessage());
            throw new ClassCastException("insertUtente: "+ e.getMessage());
        }
        finally {
            closeConnection(con, null, ps);
        }
    }

    public void closeConnection(Connection con, ResultSet rs, PreparedStatement ps) throws SQLException{
        try{

            if(ps!= null) {
                ps.close();
            }
            if(rs != null) {
                rs.close();
            }
            if(con!= null) {
                con.close();
            }
        }catch(SQLException e){
            System.out.println("close connection " + e.getMessage());
            throw new SQLException("Connessione fallita");
        }
    }

}

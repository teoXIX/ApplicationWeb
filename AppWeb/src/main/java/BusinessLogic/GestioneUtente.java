package BusinessLogic;

import java.sql.SQLException;

import Oggetti.Utente;

public class GestioneUtente {

    private String errore = "";

    public boolean addUtente(Utente u) throws Exception {
        DBConnect db = new DBConnect();
        boolean esisteUtente;
        try {
            esisteUtente = db.esisteUtente(u.getCodFis());
            if(!esisteUtente) {
                db.insertUtente(u);
                return true;
            }
            return false;
        } catch (ClassNotFoundException | SQLException e) {
            throw new Exception("addUtente: " + e.getMessage());
        }
    }
    public boolean esisteUtenteLogin(Utente u) throws Exception {
        DBConnect db = new DBConnect();
        boolean codFisEsiste = null != null;
        boolean passwordEsiste = null != null;
        try {
            codFisEsiste = db.esisteUtente(u.getCodFis());
            if(codFisEsiste) {
                passwordEsiste = db.controlloLogin(u.getPassword());
            }
            else
                return false;

        }catch (ClassNotFoundException | SQLException e) {
            throw new Exception("esisteUtenteLogin: " + e.getMessage());
        }
        if(passwordEsiste)
            return true;
        else {
            setErrore("password");
            return false;
        }
    }
    public String getErrore() {
        return errore;
    }
    public void setErrore(String errore) {
        this.errore = errore;
    }
}

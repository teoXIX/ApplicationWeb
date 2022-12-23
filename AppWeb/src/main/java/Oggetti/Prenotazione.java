package Oggetti;

import java.sql.Date;
public class Prenotazione {
    private int idPrenotazione;
    private String descrizione;
    private Date dataPrenotazione;
    private Utente utente;
    private Sala sala;
    private Medico medico;
    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public Date getDataPrenotazione() {
        return dataPrenotazione;
    }
    public void setDataPrenotazione(Date dataPrenotazione) {
        this.dataPrenotazione = dataPrenotazione;
    }
    public Utente getUtente() {
        return utente;
    }
    public void setUtente(Utente utente) {
        this.utente = utente;
    }
    public Sala getSala() {
        return sala;
    }
    public void setSala(Sala sala) {
        this.sala = sala;
    }
    public Medico getMedico() {
        return medico;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    public int getIdPrenotazione() {
        return idPrenotazione;
    }
    public void setIdPrenotazione(int idPrenotazione) {
        this.idPrenotazione = idPrenotazione;
    }
}


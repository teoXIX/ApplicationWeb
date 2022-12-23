package Oggetti;

public class Medico {
    private String nome;
    private String cognome;
    private String specializzazione;
    private int idMedico;
    public Medico(String nome, String cognome, String specializzazione, int idMedico) {
        this.nome = nome;
        this.cognome = cognome;
        this.specializzazione = specializzazione;
        this.idMedico = idMedico;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getSpecializzazione() {
        return specializzazione;
    }
    public void setSpecializzazione(String specializzazione) {
        this.specializzazione = specializzazione;
    }
    public int getIdMedico() {
        return idMedico;
    }
    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }
}

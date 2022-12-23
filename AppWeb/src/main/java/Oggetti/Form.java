package Oggetti;

public class Form {
    private String nomeUtente;
    private String descrizione;
    public Form(String nomeUtente, String descrizione) {
        this.nomeUtente = nomeUtente;
        this.descrizione = descrizione;
    }
    public String getNomeUtente() {
        return nomeUtente;
    }
    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}


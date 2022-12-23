package Oggetti;
public class Sala {
    private int idSala;
    private String descrizione;
    public Sala(String descrizione, int idSala) {
        this.idSala = idSala;
        this.descrizione = descrizione;
    }
    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public int getIdSala() {
        return idSala;
    }
    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }
}
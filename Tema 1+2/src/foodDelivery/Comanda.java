package foodDelivery;
import java.util.ArrayList;
import java.util.List;
public class Comanda {
    private int id;
    private int idUtilizator;
    private String stadiuLivrare;

    // Constructor pentru crearea unei noi comenzi, fără ID comandă
    public Comanda(int idUtilizator, String stadiuLivrare) {
        this.idUtilizator = idUtilizator;
        this.stadiuLivrare = stadiuLivrare;
    }

    // Constructor complet cu ID, folosit când obiectele sunt extrase din baza de date
    public Comanda(int id, int idUtilizator, String stadiuLivrare) {
        this.id = id;
        this.idUtilizator = idUtilizator;
        this.stadiuLivrare = stadiuLivrare;
    }

    // Getteri și setteri
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUtilizator() {
        return idUtilizator;
    }

    public void setIdUtilizator(int idUtilizator) {
        this.idUtilizator = idUtilizator;
    }

    public String getStadiuLivrare() {
        return stadiuLivrare;
    }

    public void setStadiuLivrare(String stadiuLivrare) {
        this.stadiuLivrare = stadiuLivrare;
    }
}




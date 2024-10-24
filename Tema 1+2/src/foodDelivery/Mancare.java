package foodDelivery;
public class Mancare {
    private int id;
    private String nume;
    private double pret;

    // Constructor pentru crearea unei noi entități `Mancare`, fără ID
    public Mancare(String nume, double pret) {
        this.nume = nume;
        this.pret = pret;
    }

    // Constructor cu ID, pentru obiecte create din datele bazei de date
    public Mancare(int id, String nume, double pret) {
        this.id = id;
        this.nume = nume;
        this.pret = pret;
    }

    // Getteri și Setteri
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }
}



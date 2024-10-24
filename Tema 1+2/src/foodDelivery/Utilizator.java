package foodDelivery;

public class Utilizator {
    private int id;
    private String nume;
    private String email;
    private String adresaLivrare;

    public Utilizator(String nume, String email, String adresaLivrare) {
        this.nume = nume;
        this.email = email;
        this.adresaLivrare = adresaLivrare;
    }

    public Utilizator(int id, String nume, String email, String adresaLivrare) {
        this.id = id;
        this.nume = nume;
        this.email = email;
        this.adresaLivrare = adresaLivrare;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresaLivrare() {
        return adresaLivrare;
    }

    public void setAdresaLivrare(String adresaLivrare) {
        this.adresaLivrare = adresaLivrare;
    }
}



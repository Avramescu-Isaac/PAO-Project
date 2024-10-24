package foodDelivery;
public class Recenzie {
    private Integer id;
    private int idUtilizator;
    private int rating;
    private String comentariu;

    // Constructor fără ID, pentru crearea unei noi recenzii
    public Recenzie(int idUtilizator, int rating, String comentariu) {
        this.idUtilizator = idUtilizator;
        this.rating = rating;
        this.comentariu = comentariu;
    }

    // Constructor complet cu ID, folosit când recenziile sunt extrase din baza de date
    public Recenzie(Integer id, int idUtilizator, int rating, String comentariu) {
        this.id = id;
        this.idUtilizator = idUtilizator;
        this.rating = rating;
        this.comentariu = comentariu;
    }

    // Getteri și setteri
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdUtilizator() {
        return idUtilizator;
    }

    public void setIdUtilizator(int idUtilizator) {
        this.idUtilizator = idUtilizator;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComentariu() {
        return comentariu;
    }

    public void setComentariu(String comentariu) {
        this.comentariu = comentariu;
    }
}


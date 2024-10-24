package foodDelivery;
public class Sofer extends Utilizator {
    private boolean disponibil;

    public Sofer(int id,String nume, String adresaEmail, String adresaLivrare) {
        super(id, nume, adresaEmail, adresaLivrare);
        this.disponibil = true;
    }

    public boolean isDisponibil() {
        return disponibil;
    }

    public void setDisponibil(boolean disponibil) {
        this.disponibil = disponibil;
    }
}
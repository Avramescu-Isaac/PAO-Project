package foodDelivery;
import java.util.ArrayList;
import java.util.List;

public class Local {
    private String nume;
    private String adresa;
    private List<Mancare> meniu;
    private List<Recenzie> recenzii = new ArrayList<>();
    private RaportVanzari raportVanzari;

    public Local(String nume, String adresa) {
        this.nume = nume;
        this.adresa = adresa;
        this.meniu = new ArrayList<>();
        this.raportVanzari = new RaportVanzari(nume);
    }

    public void adaugaMancare(Mancare mancare) {
        meniu.add(mancare);
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public List<Mancare> getMeniu() {
        return new ArrayList<>(meniu);
    }

    public void adaugaRecenzie(Recenzie recenzie) {
        recenzii.add(recenzie);
    }

    public List<Recenzie> getRecenzii() {
        return new ArrayList<>(recenzii);
    }

    public void adaugaVanzareLaRaport(String produs, int cantitate) {
        raportVanzari.adaugaVanzare(produs, cantitate);
    }

    public RaportVanzari getRaportVanzari() {
        return raportVanzari;
    }
}


package foodDelivery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiciuFoodDelivery {
    private Map<String, Local> listaLocaluri;
    private List<Comanda> listaComenzi;
    private Map<String, Utilizator> utilizatori;
    private Map<String, Sofer> soferi;

    public ServiciuFoodDelivery() {
        listaLocaluri = new HashMap<>();
        listaComenzi = new ArrayList<>();
        utilizatori = new HashMap<>();
        soferi = new HashMap<>();
    }

    public void adaugaLocal(Local local) {
        listaLocaluri.put(local.getNume(), local);
    }

    public void plaseazaComanda(Comanda comanda) {
        listaComenzi.add(comanda);
    }

    public void adaugaUtilizator(Utilizator utilizator) {
        utilizatori.put(utilizator.getEmail(), utilizator);
    }

    public void adaugaSofer(Sofer sofer) {
        soferi.put(sofer.getEmail(), sofer);
    }

    public Sofer asignareSoferPentruLivrare() {
        for (Sofer sofer : soferi.values()) {
            if (sofer.isDisponibil()) {
                sofer.setDisponibil(false);
                return sofer;
            }
        }
        return null;
    }

    public void adaugaRecenzieLaLocal(String numeLocal, Recenzie recenzie) {
        Local local = listaLocaluri.get(numeLocal);
        if (local != null) {
            local.adaugaRecenzie(recenzie);
        }
    }

    public void adaugaVanzareLaRaport(String numeLocal, String produs, int cantitate) {
        Local local = listaLocaluri.get(numeLocal);
        if (local != null) {
            local.adaugaVanzareLaRaport(produs, cantitate);
        }
    }

    public Local cautaLocalDupaNume(String nume) {
        return listaLocaluri.get(nume);
    }

    public Utilizator cautaUtilizatorDupaEmail(String email) {
        return utilizatori.get(email);
    }

    public Sofer cautaSoferDupaEmail(String email) {
        return soferi.get(email);
    }
    public RaportVanzari getRaportVanzari(String numeLocal) {
        Local local = listaLocaluri.get(numeLocal);
        if (local != null) {
            return local.getRaportVanzari();
        }
        return null;
    }
    public List<Sofer> getSoferiDisponibili() {
        List<Sofer> soferiDisponibili = new ArrayList<>();
        for (Sofer sofer : soferi.values()) {
            if (sofer.isDisponibil()) {
                soferiDisponibili.add(sofer);
            }
        }
        return soferiDisponibili;
    }
    public List<Comanda> istoricComenzi(int idUtilizator) {
        List<Comanda> comenziUtilizator = new ArrayList<>();
        for (Comanda comanda : listaComenzi) {
            if (comanda.getIdUtilizator() == idUtilizator) {
                comenziUtilizator.add(comanda);
            }
        }
        return comenziUtilizator;
    }




}


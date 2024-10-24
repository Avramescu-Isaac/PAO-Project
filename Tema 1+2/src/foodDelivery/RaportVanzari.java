package foodDelivery;
import java.util.HashMap;
import java.util.Map;

public class RaportVanzari {
    private String idLocal;
    private Map<String, Integer> vanzariPeProdus;

    public RaportVanzari(String idLocal) {
        this.idLocal = idLocal;
        this.vanzariPeProdus = new HashMap<>();
    }

    public void adaugaVanzare(String produs, int cantitate) {
        vanzariPeProdus.merge(produs, cantitate, Integer::sum);
    }

    public String getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(String idLocal) {
        this.idLocal = idLocal;
    }

    public Map<String, Integer> getVanzariPeProdus() {
        return new HashMap<>(vanzariPeProdus);
    }
}


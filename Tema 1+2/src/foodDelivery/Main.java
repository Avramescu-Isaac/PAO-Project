package foodDelivery;
import java.util.Scanner;
import database.*;

import java.util.Scanner;

public class Main {
    private static UtilizatorCrud utilizatorCRUD = new UtilizatorCrud();
    private static MancareCrud mancareCRUD = new MancareCrud();
    private static ComandaCrud comandaCRUD = new ComandaCrud();
    private static RecenzieCrud recenzieCRUD = new RecenzieCrud();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Alege o operație:");
            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Print");
            System.out.println("0. Exit");
            int operationChoice = scanner.nextInt();
            scanner.nextLine();

            if (operationChoice == 0) {
                System.out.println("Ieșire din program...");
                break;
            }

            System.out.println("Alege clasa:");
            System.out.println("1. Utilizator");
            System.out.println("2. Mancare");
            System.out.println("3. Comanda");
            System.out.println("4. Recenzie");
            int classChoice = scanner.nextInt();
            scanner.nextLine();

            switch (operationChoice) {
                case 1:
                    insertOperation(classChoice);
                    break;
                case 2:
                    updateOperation(classChoice);
                    break;
                case 3:
                    deleteOperation(classChoice);
                    break;
                case 4:
                    printOperation(classChoice);
                    break;
                default:
                    System.out.println("Opțiune invalidă!");
            }
        }
    }

    private static void insertOperation(int classChoice) {
        switch (classChoice) {
            case 1:
                manageUtilizatorInsert();
                break;
            case 2:
                manageMancareInsert();
                break;
            case 3:
                manageComandaInsert();
                break;
            case 4:
                manageRecenzieInsert();
                break;
            default:
                System.out.println("Opțiune invalidă!");
        }
    }

    private static void updateOperation(int classChoice) {
        switch (classChoice) {
            case 1:
                manageUtilizatorUpdate();
                break;
            case 2:
                manageMancareUpdate();
                break;
            case 3:
                manageComandaUpdate();
                break;
            case 4:
                manageRecenzieUpdate();
                break;
            default:
                System.out.println("Opțiune invalidă!");
        }
    }

    private static void deleteOperation(int classChoice) {
        switch (classChoice) {
            case 1:
                manageUtilizatorDelete();
                break;
            case 2:
                manageMancareDelete();
                break;
            case 3:
                manageComandaDelete();
                break;
            case 4:
                manageRecenzieDelete();
                break;
            default:
                System.out.println("Opțiune invalidă!");
        }
    }

    private static void printOperation(int classChoice) {
        switch (classChoice) {
            case 1:
                manageUtilizatorPrint();
                break;
            case 2:
                manageMancarePrint();
                break;
            case 3:
                manageComandaPrint();
                break;
            case 4:
                manageRecenziePrint();
                break;
            default:
                System.out.println("Opțiune invalidă!");
        }
    }

    // Metode pentru inserare
    private static void manageUtilizatorInsert() {
        System.out.println("Introdu numele, email-ul și adresa de livrare (separate prin virgulă):");
        String[] userData = scanner.nextLine().split(",");
        Utilizator utilizator = new Utilizator(userData[0].trim(), userData[1].trim(), userData[2].trim());
        utilizatorCRUD.addUtilizator(utilizator);
        System.out.println("Utilizator adăugat cu succes!");
    }

    private static void manageMancareInsert() {
        System.out.println("Introdu numele mâncării și prețul (separate prin virgulă):");
        String[] foodData = scanner.nextLine().split(",");
        Mancare mancare = new Mancare(foodData[0].trim(), Double.parseDouble(foodData[1].trim()));
        mancareCRUD.addMancare(mancare);
        System.out.println("Mâncare adăugată cu succes!");
    }

    private static void manageComandaInsert() {
        System.out.println("Introdu ID-ul utilizatorului și stadiul livrării (separate prin virgulă):");
        String[] orderData = scanner.nextLine().split(",");
        Comanda comanda = new Comanda(Integer.parseInt(orderData[0].trim()), orderData[1].trim());
        comandaCRUD.addComanda(comanda);
        System.out.println("Comandă adăugată cu succes!");
    }

    private static void manageRecenzieInsert() {
        System.out.println("Introdu ID-ul utilizatorului, ratingul și comentariul (separate prin virgulă):");
        String[] reviewData = scanner.nextLine().split(",");
        Recenzie recenzie = new Recenzie(Integer.parseInt(reviewData[0].trim()), Integer.parseInt(reviewData[1].trim()), reviewData[2].trim());
        recenzieCRUD.addRecenzie(recenzie);
        System.out.println("Recenzie adăugată cu succes!");
    }

    // Metode pentru actualizare
    private static void manageUtilizatorUpdate() {
        System.out.println("Introdu ID-ul utilizatorului pe care vrei să-l actualizezi:");
        int id = Integer.parseInt(scanner.nextLine().trim());
        Utilizator utilizator = utilizatorCRUD.getUtilizator(id);
        if (utilizator != null) {
            System.out.println("Introdu noul nume, noul email și noua adresă de livrare (separate prin virgulă):");
            String[] userData = scanner.nextLine().split(",");
            utilizator.setNume(userData[0].trim());
            utilizator.setEmail(userData[1].trim());
            utilizator.setAdresaLivrare(userData[2].trim());
            utilizatorCRUD.updateUtilizator(utilizator);
            System.out.println("Utilizator actualizat cu succes!");
        } else {
            System.out.println("Utilizatorul nu a fost găsit.");
        }
    }

    private static void manageMancareUpdate() {
        System.out.println("Introdu ID-ul mâncării pe care vrei să o actualizezi:");
        int id = Integer.parseInt(scanner.nextLine().trim());
        Mancare mancare = mancareCRUD.getMancare(id);
        if (mancare != null) {
            System.out.println("Introdu noul nume și noul preț (separate prin virgulă):");
            String[] foodData = scanner.nextLine().split(",");
            mancare.setNume(foodData[0].trim());
            mancare.setPret(Double.parseDouble(foodData[1].trim()));
            mancareCRUD.updateMancare(mancare);
            System.out.println("Mâncare actualizată cu succes!");
        } else {
            System.out.println("Mâncarea nu a fost găsită.");
        }
    }

    private static void manageComandaUpdate() {
        System.out.println("Introdu ID-ul comenzii pe care vrei să o actualizezi:");
        int id = Integer.parseInt(scanner.nextLine().trim());
        Comanda comanda = comandaCRUD.getComanda(id);
        if (comanda != null) {
            System.out.println("Introdu noul ID al utilizatorului și noul stadiu al livrării (separate prin virgulă):");
            String[] orderData = scanner.nextLine().split(",");
            comanda.setIdUtilizator(Integer.parseInt(orderData[0].trim()));
            comanda.setStadiuLivrare(orderData[1].trim());
            comandaCRUD.updateComanda(comanda);
            System.out.println("Comandă actualizată cu succes!");
        } else {
            System.out.println("Comanda nu a fost găsită.");
        }
    }

    private static void manageRecenzieUpdate() {
        System.out.println("Introdu ID-ul recenziei pe care vrei să o actualizezi:");
        int id = Integer.parseInt(scanner.nextLine().trim());
        Recenzie recenzie = recenzieCRUD.getRecenzie(id);
        if (recenzie != null) {
            System.out.println("Introdu noul ID al utilizatorului, noul rating și noul comentariu (separate prin virgulă):");
            String[] reviewData = scanner.nextLine().split(",");
            recenzie.setIdUtilizator(Integer.parseInt(reviewData[0].trim()));
            recenzie.setRating(Integer.parseInt(reviewData[1].trim()));
            recenzie.setComentariu(reviewData[2].trim());
            recenzieCRUD.updateRecenzie(recenzie);
            System.out.println("Recenzie actualizată cu succes!");
        } else {
            System.out.println("Recenzia nu a fost găsită.");
        }
    }

    // Metode pentru ștergere
    private static void manageUtilizatorDelete() {
        System.out.println("Introdu ID-ul utilizatorului pe care vrei să-l ștergi:");
        int id = Integer.parseInt(scanner.nextLine().trim());
        utilizatorCRUD.deleteUtilizator(id);
        System.out.println("Utilizator șters cu succes!");
    }

    private static void manageMancareDelete() {
        System.out.println("Introdu ID-ul mâncării pe care vrei să o ștergi:");
        int id = Integer.parseInt(scanner.nextLine().trim());
        mancareCRUD.deleteMancare(id);
        System.out.println("Mâncare ștearsă cu succes!");
    }

    private static void manageComandaDelete() {
        System.out.println("Introdu ID-ul comenzii pe care vrei să o ștergi:");
        int id = Integer.parseInt(scanner.nextLine().trim());
        comandaCRUD.deleteComanda(id);
        System.out.println("Comandă ștearsă cu succes!");
    }

    private static void manageRecenzieDelete() {
        System.out.println("Introdu ID-ul recenziei pe care vrei să o ștergi:");
        int id = Integer.parseInt(scanner.nextLine().trim());
        recenzieCRUD.deleteRecenzie(id);
        System.out.println("Recenzie ștearsă cu succes!");
    }

    // Metode pentru afișare
    private static void manageUtilizatorPrint() {
        System.out.println("Introdu ID-ul utilizatorului pe care vrei să-l afișezi:");
        int id = Integer.parseInt(scanner.nextLine().trim());
        Utilizator utilizator = utilizatorCRUD.getUtilizator(id);
        if (utilizator != null) {
            System.out.println("Utilizator: " + utilizator.getId() + ", Nume: " + utilizator.getNume() + ", Email: " + utilizator.getEmail() + ", Adresa de livrare: " + utilizator.getAdresaLivrare());
        } else {
            System.out.println("Utilizatorul nu a fost găsit.");
        }
    }

    private static void manageMancarePrint() {
        System.out.println("Introdu ID-ul mâncării pe care vrei să o afișezi:");
        int id = Integer.parseInt(scanner.nextLine().trim());
        Mancare mancare = mancareCRUD.getMancare(id);
        if (mancare != null) {
            System.out.println("Mâncare: " + mancare.getId() + ", Nume: " + mancare.getNume() + ", Preț: " + mancare.getPret());
        } else {
            System.out.println("Mâncarea nu a fost găsită.");
        }
    }

    private static void manageComandaPrint() {
        System.out.println("Introdu ID-ul comenzii pe care vrei să o afișezi:");
        int id = Integer.parseInt(scanner.nextLine().trim());
        Comanda comanda = comandaCRUD.getComanda(id);
        if (comanda != null) {
            System.out.println("Comandă: " + comanda.getId() + ", ID Utilizator: " + comanda.getIdUtilizator() + ", Stadiu livrare: " + comanda.getStadiuLivrare());
        } else {
            System.out.println("Comanda nu a fost găsită.");
        }
    }

    private static void manageRecenziePrint() {
        System.out.println("Introdu ID-ul recenziei pe care vrei să o afișezi:");
        int id = Integer.parseInt(scanner.nextLine().trim());
        Recenzie recenzie = recenzieCRUD.getRecenzie(id);
        if (recenzie != null) {
            System.out.println("Recenzie: " + recenzie.getId() + ", ID Utilizator: " + recenzie.getIdUtilizator() + ", Rating: " + recenzie.getRating() + ", Comentariu: " + recenzie.getComentariu());
        } else {
            System.out.println("Recenzia nu a fost găsită.");
        }
    }
}







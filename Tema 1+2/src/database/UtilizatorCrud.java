package database;

import foodDelivery.Utilizator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilizatorCrud {
    private Connection connection;
    private AuditService auditService;

    public UtilizatorCrud() {
        this.connection = DatabaseConnection.getConnection();
        this.auditService = AuditService.getInstance();
    }

    public void addUtilizator(Utilizator utilizator) {
        String sql = "INSERT INTO Utilizator (nume, email, adresa_livrare) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, utilizator.getNume());
            statement.setString(2, utilizator.getEmail());
            statement.setString(3, utilizator.getAdresaLivrare());
            statement.executeUpdate();
            auditService.logAction("addUtilizator");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Utilizator getUtilizator(int id) {
        String sql = "SELECT * FROM Utilizator WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            auditService.logAction("getUtilizator");
            if (rs.next()) {
                return new Utilizator(
                        rs.getInt("id"),
                        rs.getString("nume"),
                        rs.getString("email"),
                        rs.getString("adresa_livrare")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateUtilizator(Utilizator utilizator) {
        String sql = "UPDATE Utilizator SET nume = ?, email = ?, adresa_livrare = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, utilizator.getNume());
            statement.setString(2, utilizator.getEmail());
            statement.setString(3, utilizator.getAdresaLivrare());
            statement.setInt(4, utilizator.getId());
            statement.executeUpdate();
            auditService.logAction("updateUtilizator");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUtilizator(int id) {
        String sql = "DELETE FROM Utilizator WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            auditService.logAction("deleteUtilizator");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}





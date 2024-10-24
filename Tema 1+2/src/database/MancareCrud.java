package database;

import foodDelivery.Mancare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class MancareCrud {
    private Connection connection;
    private AuditService auditService;

    public MancareCrud() {
        this.connection = DatabaseConnection.getConnection();
        this.auditService = AuditService.getInstance();
    }

    public void addMancare(Mancare mancare) {
        String sql = "INSERT INTO Mancare (nume, pret) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, mancare.getNume());
            statement.setDouble(2, mancare.getPret());
            statement.executeUpdate();
            auditService.logAction("addMancare");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Mancare getMancare(int id) {
        String sql = "SELECT * FROM Mancare WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            auditService.logAction("getMancare");
            if (rs.next()) {
                return new Mancare(
                        rs.getInt("id"),
                        rs.getString("nume"),
                        rs.getDouble("pret")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateMancare(Mancare mancare) {
        String sql = "UPDATE Mancare SET nume = ?, pret = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, mancare.getNume());
            statement.setDouble(2, mancare.getPret());
            statement.setInt(3, mancare.getId());
            statement.executeUpdate();
            auditService.logAction("updateMancare");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMancare(int id) {
        String sql = "DELETE FROM Mancare WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            auditService.logAction("deleteMancare");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


package database;
import foodDelivery.Recenzie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecenzieCrud {
    private Connection connection;
    private AuditService auditService;

    public RecenzieCrud() {
        this.connection = DatabaseConnection.getConnection();
        this.auditService = AuditService.getInstance();
    }

    public void addRecenzie(Recenzie recenzie) {
        String sql = "INSERT INTO Recenzie (id_utilizator, rating, comentariu) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, recenzie.getIdUtilizator());
            statement.setInt(2, recenzie.getRating());
            statement.setString(3, recenzie.getComentariu());
            statement.executeUpdate();
            auditService.logAction("addRecenzie");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Recenzie getRecenzie(int id) {
        String sql = "SELECT * FROM Recenzie WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            auditService.logAction("getRecenzie");
            if (rs.next()) {
                return new Recenzie(
                        rs.getInt("id"),
                        rs.getInt("id_utilizator"),
                        rs.getInt("rating"),
                        rs.getString("comentariu")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateRecenzie(Recenzie recenzie) {
        String sql = "UPDATE Recenzie SET id_utilizator = ?, rating = ?, comentariu = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, recenzie.getIdUtilizator());
            statement.setInt(2, recenzie.getRating());
            statement.setString(3, recenzie.getComentariu());
            statement.setInt(4, recenzie.getId());
            statement.executeUpdate();
            auditService.logAction("updateRecenzie");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRecenzie(int id) {
        String sql = "DELETE FROM Recenzie WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            auditService.logAction("deleteRecenzie");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


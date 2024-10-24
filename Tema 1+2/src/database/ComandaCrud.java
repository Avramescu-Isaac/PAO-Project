package database;
import foodDelivery.Comanda;

import java.sql.*;

public  class ComandaCrud {
    private Connection connection;
    private AuditService auditService;

    public ComandaCrud() {
        this.connection = DatabaseConnection.getConnection();
        this.auditService = AuditService.getInstance();
    }

    public void addComanda(Comanda comanda) {String sql = "INSERT INTO Comanda (id_utilizator, stadiu_livrare) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, comanda.getIdUtilizator());
            statement.setString(2, comanda.getStadiuLivrare());
            statement.executeUpdate();
            auditService.logAction("addComanda");
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                comanda.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Comanda getComanda(int id) {
        String sql = "SELECT * FROM Comanda WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            auditService.logAction("getComanda");
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new Comanda(
                        rs.getInt("id"),
                        rs.getInt("id_utilizator"),
                        rs.getString("stadiu_livrare")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateComanda(Comanda comanda) {
        String sql = "UPDATE Comanda SET id_utilizator = ?, stadiu_livrare = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, comanda.getIdUtilizator());
            statement.setString(2, comanda.getStadiuLivrare());
            statement.setInt(3, comanda.getId());
            statement.executeUpdate();
            auditService.logAction("updateComanda");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteComanda(int id) {
        String sql = "DELETE FROM Comanda WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            auditService.logAction("deleteComanda");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


package Projeto.Aplicativo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataAccessObjectDB implements DataAccessObject {

    public Connection getConnection() {
        String url = "jdbc:derby://localhost:1527/ProjetoProgramacaoSistemas";
        String user = "projeto";
        String password = "projeto";
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean create(Aplicativo aplicativo) {
        try {

            Connection conn = getConnection();
            String sql = "INSERT INTO Aplicativos (id,desenvolvedor,nome,numeroDownloads) values (?,?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setLong(1, aplicativo.getId());
            pstm.setString(2, aplicativo.getDesenvolvedor());
            pstm.setString(3, aplicativo.getNome());
            pstm.setInt(4, aplicativo.getNumeroDownloads());

            pstm.executeUpdate();
            pstm.close();
            conn.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Aplicativo read(Long id) {
        try {
            Connection conn = getConnection();
            String sql = "Select * FROM aplicativos WHERE id=?";
            Aplicativo app = new Aplicativo();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setLong(1, id);
            ResultSet rs = pstm.executeQuery();

            if (!rs.next()) {
                return null;
            }
            app.setId(id);
            app.setDesenvolvedor(rs.getString("desenvolvedor"));
            app.setNome(rs.getString("nome"));
            app.setNumeroDownloads(rs.getInt("numeroDownloads"));
            rs.close();
            pstm.close();
            conn.close();

            return app;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<Aplicativo> readAll() {
        try {
            Connection conn = getConnection();
            String sql = "Select * FROM aplicativos";
            ArrayList<Aplicativo> list = new ArrayList<>();
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Aplicativo app = new Aplicativo();
                app.setId(rs.getLong("id"));
                app.setDesenvolvedor(rs.getString("desenvolvedor"));
                app.setNome(rs.getString("nome"));
                app.setNumeroDownloads(rs.getInt("numeroDownloads"));
                list.add(app);
            }
            rs.close();
            pstm.close();
            conn.close();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean update(Aplicativo aplicativo) {
        try {
            Connection conn = getConnection();
            String sql = "UPDATE aplicativos SET desenvolvedor=?, nome=?, numeroDownloads=? WHERE id=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, aplicativo.getDesenvolvedor());
            pstm.setString(2, aplicativo.getNome());
            pstm.setInt(3, aplicativo.getNumeroDownloads());
            pstm.setLong(4, aplicativo.getId());
            pstm.executeUpdate();
            pstm.close();
            conn.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public boolean delete(Aplicativo aplicativo) {
        Connection conn = getConnection();
        String sql = "DELETE FROM aplicativos WHERE id=?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setLong(1, aplicativo.getId());
            pstm.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;

    }
}

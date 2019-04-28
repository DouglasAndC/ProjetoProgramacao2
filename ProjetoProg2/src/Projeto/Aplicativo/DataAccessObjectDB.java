package Projeto.Aplicativo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DataAccessObjectDB implements DataAccessObject {

    private Connection conn;
    private PreparedStatement pstmC;
    private PreparedStatement pstmR;
    private PreparedStatement pstmRAll;
    private PreparedStatement pstmU;
    private PreparedStatement pstmD;

    public DataAccessObjectDB() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            this.conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ProjetoProgramacaoSistemas", "projeto", "projeto");
            this.pstmC = this.conn.prepareStatement("INSERT INTO Aplicativos (desenvolvedor,nome,numerodownloads) values (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            this.pstmRAll = this.conn.prepareStatement("Select * FROM aplicativos");
            this.pstmR = this.conn.prepareStatement("Select * FROM aplicativos WHERE id=?");
            this.pstmU = this.conn.prepareStatement("UPDATE aplicativos SET desenvolvedor=?, nome=?, numeroDownloads=? WHERE id=?");
            this.pstmD = this.conn.prepareStatement("DELETE FROM aplicativos WHERE id=?");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void close(){
        try{
            this.conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean create(Aplicativo aplicativo) {
        try {
            this.pstmC.setString(1, aplicativo.getDesenvolvedor());
            this.pstmC.setString(2, aplicativo.getNome());
            this.pstmC.setInt(3, aplicativo.getNumeroDownloads());
            this.pstmC.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public Aplicativo read(Long id) {
        try {
            Aplicativo app = new Aplicativo();
            pstmR.setLong(1, id);
            ResultSet rs = pstmR.executeQuery();
            if (!rs.next()) {
                return null;
            }
            app.setId(rs.getLong("id"));
            app.setDesenvolvedor(rs.getString("desenvolvedor"));
            app.setNome(rs.getString("nome"));
            app.setNumeroDownloads(rs.getInt("numeroDownloads"));
            return app;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Aplicativo> readAll() {
        try {
            ArrayList<Aplicativo> list = new ArrayList<>();
            ResultSet rs = pstmRAll.executeQuery();
            while (rs.next()) {
                Aplicativo app = new Aplicativo();
                app.setId(rs.getLong("id"));
                app.setDesenvolvedor(rs.getString("desenvolvedor"));
                app.setNome(rs.getString("nome"));
                app.setNumeroDownloads(rs.getInt("numeroDownloads"));
                list.add(app);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Aplicativo aplicativo) {
        try {

            this.pstmU.setString(1, aplicativo.getDesenvolvedor());
            this.pstmU.setString(2, aplicativo.getNome());
            this.pstmU.setInt(3, aplicativo.getNumeroDownloads());
            this.pstmU.setLong(4, aplicativo.getId());
            this.pstmU.executeUpdate();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(Aplicativo aplicativo) {
        try {
            this.pstmD.setLong(1, aplicativo.getId());
            this.pstmD.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;

    }
}

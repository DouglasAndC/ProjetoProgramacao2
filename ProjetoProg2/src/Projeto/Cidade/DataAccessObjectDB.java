/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto.Cidade;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mateus
 */
public class DataAccessObjectDB implements DataAccessObject{

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
    public boolean create(Cidade cidade) {
        try {

            Connection conn = getConnection();
            String sql = "INSERT INTO Cidades (id,nome,estado,pais,populacao) values (?,?,?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setLong(1, cidade.getId());
            pstm.setString(2, cidade.getNome());
            pstm.setString(3, cidade.getEstado());
            pstm.setString(4, cidade.getPais());
            pstm.setInt(5, cidade.getPopulacao());

            pstm.executeUpdate();
            pstm.close();
            conn.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Cidade read(Long id) {
        try {
            Connection conn = getConnection();
            String sql = "Select * FROM cidade WHERE id=?";
            Cidade cdd = new Cidade();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setLong(1, id);
            ResultSet rs = pstm.executeQuery();

            if (!rs.next()) {
                return null;
            }
            cdd.setId(id);
            cdd.setNome(rs.getString("nome"));
            cdd.setEstado(rs.getString("estado"));
            cdd.setPais(rs.getString("pais"));
            cdd.setPopulacao(rs.getInt("populacao"));
            rs.close();
            pstm.close();
            conn.close();

            return cdd;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<Cidade> readAll() {
        try {
            Connection conn = getConnection();
            String sql = "Select * FROM cidade";
            ArrayList<Cidade> list = new ArrayList<>();
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Cidade cdd = new Cidade();
                cdd.setId(rs.getLong("id"));
                cdd.setNome(rs.getString("nome"));
                cdd.setEstado(rs.getString("estado"));
                cdd.setPais(rs.getString("pais"));
                cdd.setPopulacao(rs.getInt("populacao"));
                list.add(cdd);
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

    public boolean update(Cidade cidade) {
        try {
            Connection conn = getConnection();
            String sql = "UPDATE cidade SET nome=?, estado=?, pais=?, populacao=?, WHERE id=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setLong(1, cidade.getId());
            pstm.setString(2, cidade.getNome());
            pstm.setString(3, cidade.getEstado());
            pstm.setString(4, cidade.getPais());
            pstm.setInt(5, cidade.getPopulacao());
            pstm.executeUpdate();
            pstm.close();
            conn.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public boolean delete(Cidade cidade) {
        Connection conn = getConnection();
        String sql = "DELETE FROM cidade WHERE id=?";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setLong(1, cidade.getId());
            pstm.executeUpdate();
        } catch (Exception ex) {

        }
        return false;

    }
}
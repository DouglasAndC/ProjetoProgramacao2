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
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mateus
 */
public class DataAccessObjectDB implements DataAccessObject {
    private PreparedStatement pstmC;
    private PreparedStatement pstmR;
    private PreparedStatement pstmRall;
    private PreparedStatement pstmU;
    private PreparedStatement pstmD;
    private Connection conn;
    
    public DataAccessObjectDB() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            this.conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ProjetoProgramacaoSistemas","projeto","projeto");
             this.pstmC = this.conn.prepareStatement("INSERT INTO Cidade (id,nome,estado,pais,populacao) values (?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);        
            this.pstmR = this.conn.prepareStatement("Select * FROM cidade WHERE id=?");
            this.pstmRall = this.conn.prepareStatement("Select * FROM cidade");
            this.pstmU = this.conn.prepareStatement("UPDATE cidade SET nome=?, estado=?, pais=?, populacao=? WHERE id=?");
            this.pstmD = this.conn.prepareStatement("DELETE FROM cidade WHERE id=?");
        } 
            catch (Exception ex) {
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
    public Cidade create(Cidade cdd) {
        try {
            this.pstmC.setString(1, cdd.getNome());
            this.pstmC.setString(2, cdd.getEstado());
            this.pstmC.setString(3, cdd.getPais());
            this.pstmC.setInt(4, cdd.getPopulacao());
            this.pstmC.executeUpdate();
            ResultSet rs = this.pstmC.getGeneratedKeys();
            rs.next();
            long id = rs.getLong(1);
            cdd.setId(id);
            return cdd;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    @Override
    public Cidade read(Long id) {
        try {
            Cidade cdd = new Cidade();
            pstmR.setLong(1, id);
            ResultSet rs = pstmR.executeQuery();
            if (!rs.next()) {
                return null;
            }
            cdd.setId(rs.getLong("id"));
            cdd.setNome(rs.getString("nome"));
            cdd.setEstado(rs.getString("estado"));
            cdd.setPais(rs.getString("pais"));
            cdd.setPopulacao(rs.getInt("populacao"));
            return cdd;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    @Override
    public ArrayList<Cidade> readAll() {
         try {
            ArrayList<Cidade> list = new ArrayList<>();
            ResultSet rs = pstmRall.executeQuery();
            while (rs.next()) {
                Cidade cdd = new Cidade();
                cdd.setId(rs.getLong("id"));
                cdd.setNome(rs.getString("nome"));
                cdd.setEstado(rs.getString("estado"));
                cdd.setPais(rs.getString("pais"));
                cdd.setPopulacao(rs.getInt("populacao"));
                list.add(cdd);
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    @Override
    public Cidade update(Cidade cidade) {
           try {
            this.pstmU.setString(1, cidade.getNome());
            this.pstmU.setString(2, cidade.getEstado());
            this.pstmU.setString(3, cidade.getPais());
            this.pstmU.setInt(4, cidade.getPopulacao());
            this.pstmU.setLong(5, cidade.getId());
            
            this.pstmU.executeUpdate();

            return cidade;
        }catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
    @Override
    public Cidade delete(Cidade cidade) {
        try {
            this.pstmD.setLong(1, cidade.getId());
            this.pstmD.executeUpdate();
            return cidade;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;

    }
}
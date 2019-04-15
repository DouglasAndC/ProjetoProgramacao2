/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto.Aplicativo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Douglas
 */
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

    public boolean create(Aplicativo aplicativo) {
        try{
        Connection conn = getConnection();
        String sql = "INSERT INTO Aplicativos (id,desenvolvedor,nome,numeroDownloads) values (?,?,?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setLong(1, aplicativo.getId());
        pstm.setString(2, aplicativo.getDesenvolvedor());
        pstm.setString(3, aplicativo.getNome());
        pstm.setInt(4, aplicativo.getNumeroDownloads());
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    public String read(Long id) {

    }

    public ArrayList<Aplicativo> readAll() {

    }

    public boolean update(Aplicativo aplicativo) {
        return false;
    }

    public boolean delete(Aplicativo aplicativo) {
        return false;
    }
}

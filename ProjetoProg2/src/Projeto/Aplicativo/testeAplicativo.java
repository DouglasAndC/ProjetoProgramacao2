/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto.Aplicativo;

/**
 *
 * @author Douglas
 */
public class testeAplicativo {
    public static void main(String[] args) {
        Aplicativo app = new Aplicativo();
        app.setId((long)12321);
        app.setDesenvolvedor("Douglas");
        app.setNome("app prog2");
        app.setNumeroDownloads(10);
        
        DataAccessObjectDB dao = new DataAccessObjectDB();
        dao.create(app);
        System.out.println(dao.read(app.getId()));
        System.out.println(dao.readAll());
        System.out.println(app);
        dao.close();
    }
}

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
        app.setId((long)13);
        app.setDesenvolvedor("DouglasA");
        app.setNome("app prog3");
        app.setNumeroDownloads(10);
        DataAccessObjectDB db = new DataAccessObjectDB();
        db.create(app);
    }
}

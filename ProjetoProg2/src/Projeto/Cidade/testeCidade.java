/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto.Cidade;

/**
 *
 * @author Douglas
 */
public class testeCidade {
    public static void main(String[] args) {
        Cidade cdd = new Cidade();
        cdd.setId((long)2);
        cdd.setNome("Sao Paulo");
        cdd.setEstado("Sao Paulo");
        cdd.setPais("Brasil");
        cdd.setPopulacao(12000000);
        DataAccessObject dao = new DataAccessObjectDB();
        System.out.println(dao.read(cdd.getId()));
    }
}

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
        Cidade cidade = new Cidade();
        DataAccessObject DaoDb = new DataAccessObjectDB();
        DaoDb.delete(cidade);
        DaoDb.create(cidade);
        System.out.println(DaoDb.read((long)cidade.getId()));
        cidade.setEstado("São Paulo");
        cidade.setNome("São Paulo");
        cidade.setPais("Brasil");
        cidade.setPopulacao(1000);
        DaoDb.update(cidade);
        System.out.println(DaoDb.read((long)cidade.getId()));
        System.out.println("finalizado");
    }
}

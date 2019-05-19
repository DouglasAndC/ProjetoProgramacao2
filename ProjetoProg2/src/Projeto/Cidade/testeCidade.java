
package Projeto.Cidade;

public class testeCidade {
    public static void main(String[] args) {
        Cidade cdd = new Cidade();
        cdd.setId((long)3);
        cdd.setNome("Campinas");
        cdd.setEstado("Sao Paulo");
        cdd.setPais("Brasil");
        cdd.setPopulacao(12000000);
        
        DataAccessObject dao = new DataAccessObjectDB();
        dao.create(cdd);
        System.out.println(dao.read(cdd.getId()));
        System.out.println(dao.readAll());
        dao.close();
    }
}

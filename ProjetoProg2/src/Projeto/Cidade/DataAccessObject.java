
package Projeto.Cidade;


import java.util.ArrayList;


interface DataAccessObject {
    public Cidade create(Cidade cidade);
    public Cidade read(Long id);
    public ArrayList<Cidade> readAll();
    public Cidade update(Cidade cidade);
    public Cidade delete(Cidade cidade); 
    public void close();
}

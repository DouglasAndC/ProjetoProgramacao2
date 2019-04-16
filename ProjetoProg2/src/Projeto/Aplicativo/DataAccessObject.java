
package Projeto.Aplicativo;

import java.util.ArrayList;


interface DataAccessObject {
    public boolean create(Aplicativo aplicativo);
    public Aplicativo read(Long id);
    public ArrayList<Aplicativo> readAll();
    public boolean update(Aplicativo aplicativo);
    public boolean delete(Aplicativo aplicativo); 
}

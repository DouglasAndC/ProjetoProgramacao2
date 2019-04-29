
package Projeto.Aplicativo;

import java.util.ArrayList;


interface DataAccessObject {
    public Aplicativo create(Aplicativo app);
    public Aplicativo read(Long id);
    public ArrayList<Aplicativo> readAll();
    public Aplicativo update(Aplicativo app);
    public Aplicativo delete(Aplicativo app); 
}

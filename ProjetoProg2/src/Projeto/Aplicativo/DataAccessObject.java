/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto.Aplicativo;

import java.util.ArrayList;

/**
 *
 * @author Douglas
 */
interface DataAccessObject {
    public boolean create(Aplicativo aplicativo);
    public String read(Long id);
    public ArrayList<Aplicativo> readAll();
    public boolean update(Aplicativo aplicativo);
    public boolean delete(Aplicativo aplicativo); 
}

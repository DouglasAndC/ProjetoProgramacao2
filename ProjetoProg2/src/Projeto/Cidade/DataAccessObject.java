
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto.Cidade;


import java.util.ArrayList;


interface DataAccessObject {
    public boolean create(Cidade cidade);
    public Cidade read(Long id);
    public ArrayList<Cidade> readAll();
    public boolean update(Cidade cidade);
    public boolean delete(Cidade cidade); 
}

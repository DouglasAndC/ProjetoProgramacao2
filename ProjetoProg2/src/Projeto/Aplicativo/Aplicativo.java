
package Projeto.Aplicativo;


public class Aplicativo {
    private long id;
    private String nome;
    private String desenvolvedor;
    private int numeroDownloads;
    
    public Aplicativo(long id, String nome, String desenvolvedor, int numeroDownloads){
        this.id=id;
        this.nome=nome;
        this.desenvolvedor=desenvolvedor;
        this.numeroDownloads=numeroDownloads;
    }
    public long getId(){
        return this.id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public String getDesenvolvedor(){
        return this.desenvolvedor;
    }
    public void setDesenvolvedor(String desenvolvedor){
        this.desenvolvedor=desenvolvedor;
    }
    public int getNumeroDownloads(){
        return this.numeroDownloads;
    }
    public void setNumeroDownloads(int numeroDownloads){
        this.numeroDownloads=numeroDownloads;
    }
}

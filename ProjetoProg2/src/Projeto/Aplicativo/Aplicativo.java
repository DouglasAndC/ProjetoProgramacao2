
package Projeto.Aplicativo;


public class Aplicativo {
    private long id;
    private String nome;
    private String desenvolvedor;
    private int numeroDownloads;
    
    public Aplicativo(){
        this.id=-1;
        this.nome="";
        this.desenvolvedor="";
        this.numeroDownloads=-1;
    }
    public long getId(){
        return this.id;
    }
    public void setId(Long id){
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
    @Override
    public String toString(){
        return "[id: "+id+" ; "
                + "desenvolvedor: "+desenvolvedor+" ; "
                + "nome: "+nome+" ; "
                + "numeroDownloads: "+numeroDownloads+"]";
    }
}

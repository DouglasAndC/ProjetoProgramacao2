
package Projeto.Cidade;


public class Cidade {

    private long id;
    private String nome;
    private String estado;
    private String pais;
    private int populacao;

    public Cidade() {
        this.id = 0;
        this.nome = "";
        this.estado = "";
        this.pais = "";
        this.populacao = 0;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public int getPopulacao(){
        return this.populacao;
    }

    @Override
    public String toString(){
        return "[id: "+id+" ; "
                + "nome: "+nome+" ; "
                + "estado: "+estado+" ; "
                + "pais: "+pais+";" 
                + "populacao: "+populacao+"]";
    }
}

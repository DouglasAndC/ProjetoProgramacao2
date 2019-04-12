
package Projeto.Cidade;


public class Cidade {

    private long id;
    private String nome;
    private String estado;
    private String pais;
    private long populacao;

    public Cidade(long id, String nome, String estado, String pais, long populacao) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
        this.pais = pais;
        this.populacao = populacao;
    }

    public void setId(int id) {
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

    public String getPais(String pais) {
        return this.pais;
    }

    public void setPopulacao(long populacao) {
        this.populacao = populacao;
    }

    public long getPopulacao() {
        return this.populacao;
    }

}

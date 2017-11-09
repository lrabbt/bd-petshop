package br.com.petshop.model.servico;

public class TipoDeServico {
    private String nome;
    private long preco;
    
    public TipoDeServico() {
    	
    }
    public TipoDeServico(String nome, long preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getPreco() {
        return preco;
    }

    public void setPreco(long preco) {
        this.preco = preco;
    }
}

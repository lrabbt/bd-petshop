package br.com.petshop.model.animal;

import br.com.petshop.model.enums.Sexo;
import br.com.petshop.model.pessoa.Cliente;
import br.com.petshop.model.servico.ServicoAgendado;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String nome;
    private Especie especie;
    private String raca;
    private Sexo sexo;
    private int idade;
    private String maturidade;

    private Cliente dono;

    private List<ServicoAgendado> servicosAgendados = new ArrayList<>();
    
    public Animal() {
    	
    }
    public Animal(String nome, Especie especie, String raca, Sexo sexo, int idade, Cliente dono) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.sexo = sexo;
        this.idade = idade;
        this.dono = dono;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getMaturidade() {
        return maturidade;
    }

    public void setMaturidade(String maturidade) {
        this.maturidade = maturidade;
    }

    public Cliente getDono() {
        return dono;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public List<ServicoAgendado> getServicosAgendados() {
        return servicosAgendados;
    }

    public void addServicoAgendado(ServicoAgendado servicoAgendado){
        this.servicosAgendados.add(servicoAgendado);
    }
}

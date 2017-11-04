package br.com.petshop.model.pessoa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Pessoa {
    private String nome;
    private String email;
    private Date dataNasc;
    private String cpf;
    private String senha;
    private String endereco;
    private String telefone1;
    private String telefone2;
    private String telefone3;

    
    public Pessoa() {
    	
    }
    
    public Pessoa(String nome, String email, Date dataNasc, String cpf, String senha, String endereco, String telefone1,
                   String telefone2, String telefone3) {
        this.nome = nome;
        this.email = email;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.senha = senha;
        this.endereco = endereco;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.telefone3 = telefone3;
    }

    public Pessoa(String nome, String email, String dataNasc, String cpf, String senha, String endereco, String telefone1,
                  String telefone2, String telefone3) {
        this.nome = nome;
        this.email = email;

        try {
            this.dataNasc = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dataNasc);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.cpf = cpf;
        this.senha = senha;
        this.endereco = endereco;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.telefone3 = telefone3;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String getSenha() {
        return senha;
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }


    public String getEndereco() {
        return endereco;
    }


    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public String getTelefone1() {
        return telefone1;
    }


    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }


    public String getTelefone2() {
        return telefone2;
    }


    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }


    public String getTelefone3() {
        return telefone3;
    }


    public void setTelefone3(String telefone3) {
        this.telefone3 = telefone3;
    }


    public String getNome() {
        return nome;
    }


    public String getEmail() {
        return email;
    }


    public Date getDataNasc() {
        return dataNasc;
    }


    public String getCpf() {
        return cpf;
    }

}

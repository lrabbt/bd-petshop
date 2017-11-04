package br.com.petshop.model.pessoa;

import br.com.petshop.model.pessoa.horario.HorarioDeTrabalho;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Funcionario extends Pessoa {
    private int registroFuncionario;

    private List<HorarioDeTrabalho> horariosDeTrabalho = new ArrayList<>();

    public Funcionario(String nome, String email, Date dataNasc, String cpf, String senha, String endereco, String telefone1, String telefone2, String telefone3, int registroFuncionario) {
        super(nome, email, dataNasc, cpf, senha, endereco, telefone1, telefone2, telefone3);
        this.registroFuncionario = registroFuncionario;
    }

    public Funcionario(String nome, String email, String dataNasc, String cpf, String senha, String endereco, String telefone1, String telefone2, String telefone3, int registroFuncionario) {
        super(nome, email, dataNasc, cpf, senha, endereco, telefone1, telefone2, telefone3);
        this.registroFuncionario = registroFuncionario;
    }

    public int getRegistroFuncionario() {
        return registroFuncionario;
    }

    public void setRegistroFuncionario(int registroFuncionario) {
        this.registroFuncionario = registroFuncionario;
    }

    public List<HorarioDeTrabalho> getHorariosDeTrabalho() {
        return horariosDeTrabalho;
    }

    public void addHorarioDeTrabalho(HorarioDeTrabalho horarioDeTrabalho){
        this.horariosDeTrabalho.add(horarioDeTrabalho);
    }
}

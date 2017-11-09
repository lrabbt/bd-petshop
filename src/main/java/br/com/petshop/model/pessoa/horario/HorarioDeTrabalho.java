package br.com.petshop.model.pessoa.horario;

import br.com.petshop.model.pessoa.Funcionario;

public class HorarioDeTrabalho {
    private Horario horarioCompleto;
    private Funcionario funcionario;

    private boolean disponivel;
    
    public HorarioDeTrabalho() {
    	
    }
    public HorarioDeTrabalho(Horario horarioCompleto, Funcionario funcionario, boolean disponivel) {
        this.horarioCompleto = horarioCompleto;
        this.funcionario = funcionario;
        this.disponivel = disponivel;
    }

    public Horario getHorarioCompleto() {
        return horarioCompleto;
    }

    public void setHorarioCompleto(Horario horarioCompleto) {
        this.horarioCompleto = horarioCompleto;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}

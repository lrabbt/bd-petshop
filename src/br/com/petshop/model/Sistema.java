package br.com.petshop.model;

import br.com.petshop.model.animal.Especie;
import br.com.petshop.model.pessoa.Pessoa;
import br.com.petshop.model.pessoa.horario.Horario;
import br.com.petshop.model.servico.TipoDeServico;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Sistema {
    private static List<Pessoa> listaPessoas = new ArrayList<>();
    private static List<Especie> listaEspecies = new ArrayList<>();
    private static List<Horario> listaHorarios = new ArrayList<>();
    private static List<TipoDeServico> listaTiposDeServico = new ArrayList<>();

    public static List<Pessoa> getListaPessoas() {
        return listaPessoas;
    }

    public static List<Especie> getListaEspecies() {
        return listaEspecies;
    }

    public static List<Horario> getListaHorarios() {
        return listaHorarios;
    }

    public static List<TipoDeServico> getListaTiposDeServico() {
        return listaTiposDeServico;
    }

    public static void addPessoa(Pessoa pessoa){
        listaPessoas.add(pessoa);
    }

    public static void addEspecie(Especie especie){
        listaEspecies.add(especie);
    }

    public static void addHorario(Horario horario){
        listaHorarios.add(horario);
    }

    public static void addTipoDeServico(TipoDeServico tipoDeServico){
        listaTiposDeServico.add(tipoDeServico);
    }

    public static void start(){
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Sistema.atualiza();
            }
        }, 0, 30 * 1000);
    }

    public static void atualiza(){
//      TODO: Implementar
    }
}

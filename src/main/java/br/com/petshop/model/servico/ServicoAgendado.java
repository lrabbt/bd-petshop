package br.com.petshop.model.servico;

import br.com.petshop.model.animal.Animal;
import br.com.petshop.model.pessoa.horario.HorarioDeTrabalho;

public class ServicoAgendado {
	private Animal animalAtendido;
	private TipoDeServico tipoDeServico;
	private HorarioDeTrabalho horarioDeTrabalho;

	public ServicoAgendado() {

	}
	public ServicoAgendado(Animal animalAtendido, TipoDeServico tipoDeServico, HorarioDeTrabalho horarioDeTrabalho) {
		this.animalAtendido = animalAtendido;
		this.tipoDeServico = tipoDeServico;
		this.horarioDeTrabalho = horarioDeTrabalho;
	}
	public Animal getAnimalAtendido() {
		return animalAtendido;
	}
	public void setAnimalAtendido(Animal animalAtendido) {
		this.animalAtendido = animalAtendido;
	}
	public TipoDeServico getTipoDeServico() {
		return tipoDeServico;
	}
	public void setTipoDeServico(TipoDeServico tipoDeServico) {
		this.tipoDeServico = tipoDeServico;
	}
	public HorarioDeTrabalho getHorarioDeTrabalho() {
		return horarioDeTrabalho;
	}
	public void setHorarioDeTrabalho(HorarioDeTrabalho horarioDeTrabalho) {
		this.horarioDeTrabalho = horarioDeTrabalho;
	}

	
}

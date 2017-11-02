package br.com.petshop.model.pessoa;

import br.com.petshop.model.animal.Animal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente extends Pessoa {

	private List<Animal> animais = new ArrayList<>();

	public Cliente(String nome, String email, Date dataNasc, String cpf, String senha, String endereco, String telefone1, String telefone2, String telefone3) {
		super(nome, email, dataNasc, cpf, senha, endereco, telefone1, telefone2, telefone3);
	}

	public Cliente(String nome, String email, String dataNasc, String cpf, String senha, String endereco, String telefone1, String telefone2, String telefone3) {
		super(nome, email, dataNasc, cpf, senha, endereco, telefone1, telefone2, telefone3);
	}

	public Cliente(String nome, String email, Date dataNasc, String cpf, String senha, String endereco, String telefone1, String telefone2, String telefone3, List<Animal> animais) {
		super(nome, email, dataNasc, cpf, senha, endereco, telefone1, telefone2, telefone3);
		this.animais = animais;
	}

	public List<Animal> getAnimais() {
		return animais;
	}

	public void addAnimal(Animal animal){
		this.animais.add(animal);
	}
}

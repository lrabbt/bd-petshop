package br.com.petshop.model;

public class Client {
	private String nome;
	private String email;
	private String dataNasc;
	private String cpf;
	private String senha;
	private String endereco;
	private String telefone1;
	private String telefone2;
	private String telefone3;
	

	public void setClient(String nome, String email, String dataNasc, String cpf, String senha, String endereco, String telefone1,
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


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setDataNasc(String dataNasc) {
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


	public String getDataNasc() {
		return dataNasc;
	}


	public String getCpf() {
		return cpf;
	}
	
}

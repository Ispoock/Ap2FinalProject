package com.br.mindwestbank.pessoas.modelo;

import com.br.mindwestbank.util.Endereco;

public abstract  class Pessoa {
	protected static int geraId = 0;
	protected String id;
	protected String nome;
	private Endereco endereco;
	
	public Pessoa(String nome,Endereco endereco) {
		setEndereco(endereco);
		setNome(nome);
		geraId++;
	}
	public static int getGeraId() {
		return geraId;
	}
	private String geraId() {
		return this.getClass().getSimpleName()+" : "+this.geraId;
	}
	public String getNome() {
		return this.nome;
	}
	public String getId() {
		return this.id;
	}
	private void setEndereco(Endereco endereco) {
		this.endereco =endereco;
	}
	private void setNome(String n) {
		this.nome = n;
	}
	public Endereco getEndereco() {
		return this.endereco;
	}
	public String toString() {
		return "Pessoa [Id:"+getId()+" Nome:"+getNome()+" Endereco:"+getEndereco().toString()+"]";
	}
}

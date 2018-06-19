package com.br.mindwestbank.pessoas.modelo;

import com.br.mindwestbank.pessoas.exceptions.PessoaException;
import com.br.mindwestbank.util.Endereco;

public class Funcionario extends PessoaFisica {
	protected static int geraId = 0;
	private String cargo;
	public Funcionario(String nome, Endereco endereco, String cpf,String cargo) throws PessoaException {
		super(nome, endereco, cpf);
		setCargo(cargo);
		geraId++;
		
	}
	public String getCargo() {
		return this.cargo;
	}
	private void setCargo(String cargo) {
		this.cargo = cargo;
	}

}

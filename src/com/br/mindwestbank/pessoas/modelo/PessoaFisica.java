package com.br.mindwestbank.pessoas.modelo;

import com.br.mindwestbank.pessoas.exceptions.PessoaException;
import com.br.mindwestbank.pessoas.modelo.Pessoa;
import com.br.mindwestbank.pessoas.util.Validacoes;
import com.br.mindwestbank.util.Endereco;

public class PessoaFisica extends Pessoa {
	protected static int geraId = 0;
	private String cpf;
	public PessoaFisica(String nome,Endereco endereco,String cpf) throws PessoaException{
		super(nome,endereco);
		validaCpf(cpf);
		

		geraId++;
	}

	private void setCpf(String cpf) {
		this.cpf = cpf;
	}
	private boolean validaCpf(String cpf) throws PessoaException{
			if(!Validacoes.validaCpf(cpf)) {
				throw new PessoaException("cpf invalido");
			}else {
				setCpf(cpf);
				return true;
			}
	}
	public String getCpf() {
		return this.cpf;
	}
	
	public String toString() {
		return "Pessoa [Id:"+getId()+" Nome:"+getNome()+" Cpf: "+getCpf()+" Endereco:"+getEndereco().toString()+"]";
		
	}
	

}

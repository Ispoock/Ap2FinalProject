package com.br.mindwestbank.pessoas.modelo;

import com.br.mindwestbank.pessoas.exceptions.PessoaException;
import com.br.mindwestbank.pessoas.modelo.Pessoa;
import com.br.mindwestbank.pessoas.util.Validacoes;
import com.br.mindwestbank.util.Endereco;

public class PessoaJuridica extends Pessoa {
	protected static int gerarId = 0;
	private String cnpj;
	public PessoaJuridica(String nome,Endereco endereco,String cnpj) throws PessoaException {
		super(nome,endereco);
		validaCnpj(cnpj);
		geraId++;
	}

	private void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	private boolean validaCnpj(String cnpj) throws PessoaException{
		if(!Validacoes.validaCnpj(cnpj)) {
			throw new PessoaException("cnpj invalido");
		}else {
			setCnpj(cnpj);
			return true;
		}
}
	public String getCnpj() {
		return this.cnpj;
	}
	@Override
	public String toString() {
		return "Pessoa [Id:"+getId()+" Nome:"+getNome()+" Cnpj: "+getCnpj()+" Endereco:"+getEndereco().toString()+"]";
		
	}
	
}

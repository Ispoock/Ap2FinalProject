package com.br.mindwestbank.pessoas.main;

import com.br.mindwestbank.pessoas.exceptions.PessoaException;
import com.br.mindwestbank.pessoas.modelo.Pessoa;
import com.br.mindwestbank.pessoas.modelo.PessoaFisica;
import com.br.mindwestbank.pessoas.modelo.PessoaJuridica;
import com.br.mindwestbank.pessoas.util.Validacoes;
import com.br.mindwestbank.util.Endereco;

public class TestaPessoa {
	
	public static void main(String[] args) {
		Endereco e1 = new Endereco("teste","teste","teste",1,"teste","teste","teste","teste");
		Pessoa p1 = null;
		Pessoa p2 = null;
		try {
			p1 = new PessoaFisica("Matheus",e1,"70389194158");
		} catch (PessoaException e) {
			e.printStackTrace();
		}
		try {
			p2 = new PessoaJuridica("Matheus",e1,"11324248000124");
		} catch (PessoaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Validacoes.validaCnpj("11324248000124"));
		System.out.println("Teste");
		System.out.println(p2.getNome());
	}
	
}

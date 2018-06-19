package com.br.mindwestbank.contas.main;

import com.br.mindwestbank.contas.exceptions.ContaException;
import com.br.mindwestbank.contas.modelo.Conta;
import com.br.mindwestbank.contas.modelo.ContaCorrente;
import com.br.mindwestbank.pessoas.exceptions.PessoaException;
import com.br.mindwestbank.pessoas.modelo.Pessoa;
import com.br.mindwestbank.pessoas.modelo.PessoaFisica;
import com.br.mindwestbank.util.Endereco;

public class Main {
	public static void main(String[] args) {
		Endereco e1 = new Endereco("teste","teste","teste",1,"teste","teste","teste","teste");
		Pessoa p1 = null ;
		try {
			p1 = new PessoaFisica("Matheus",e1,"70389194158");
		} catch (PessoaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Conta c1 = new ContaCorrente(p1);
		c1.deposito(1000);
		try {
			c1.saque(200000);
		} catch (ContaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}

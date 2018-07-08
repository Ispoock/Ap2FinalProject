package com.br.mindwestbank.pessoas.modelo;

import com.br.mindwestbank.pessoas.exceptions.PessoaException;

public class Teste {
	public static void main(String[] args) {
		
		try {
			Pessoa p1 = new PessoaFisica("70389194158");
		} catch (PessoaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 

}

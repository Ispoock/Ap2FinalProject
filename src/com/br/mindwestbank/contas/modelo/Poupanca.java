package com.br.mindwestbank.contas.modelo;

import com.br.mindwestbank.contas.exceptions.ContaException;
import com.br.mindwestbank.pessoas.modelo.Pessoa;

public class Poupanca extends Conta {
	
	public Poupanca(Pessoa cliente) {
		super();
		setCliente(cliente);
	}

	@Override
	public void saque(double n) throws ContaException{
		if(getSaldo() < n) {
			throw new ContaException("Saldo Insuficiente!!");
		}else {
			setSaldo(getSaldo() - n);
		}
	}

}

package com.br.mindwestbank.contas.modelo;

import com.br.mindwestbank.contas.exceptions.ContaException;
import com.br.mindwestbank.pessoas.modelo.Pessoa;

public class Poupanca extends Conta {
	
	public Poupanca(Pessoa cliente) {
		super();
		setCliente(cliente);
	}

	@Override
	public void saque(double dinheiro) throws ContaException{
		if(getSaldo() < dinheiro) {
			throw new ContaException("Saldo Insuficiente!!");
		}else {
			setSaldo(getSaldo() - dinheiro);
		}
	}

}

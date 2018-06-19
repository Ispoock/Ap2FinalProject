package com.br.mindwestbank.contas.modelo;

import com.br.mindwestbank.contas.exceptions.ContaException;
import com.br.mindwestbank.pessoas.modelo.Pessoa;

public class ContaCorrente extends Conta {
	private double limite;
	private Poupanca contaPoupanca;

	public ContaCorrente(Pessoa cliente) {
		super();
		setCliente(cliente);
	}
	public void setLimite(double n) {
		this.limite = n;
	}
	public double getLimite() {
		return this.limite;
	}

	@Override
	public void saque(double n) throws ContaException{
		if((getSaldo()+ getLimite()) < n) {
			throw new ContaException("Saldo Insuficiente!!");
		}else {
			setSaldo(getSaldo() - n);
		}
	}

}

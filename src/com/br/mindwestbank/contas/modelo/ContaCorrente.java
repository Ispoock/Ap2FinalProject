package com.br.mindwestbank.contas.modelo;

import com.br.mindwestbank.contas.exceptions.ContaException;
import com.br.mindwestbank.pessoas.modelo.Pessoa;

public class ContaCorrente extends Conta {
	private double limite = 0;
	private Poupanca contaPoupanca;

	public ContaCorrente(Pessoa cliente) {
		super();
		setCliente(cliente);
		setLimite(100);
	}
	public void setLimite(double n) {
		this.limite = n;
	}
	public double getLimite() {
		return this.limite;
	}
	@Override
	public void deposito(double dinheiro) {
		setSaldo(getSaldo()+dinheiro);
		this.setLimite(getLimite() + getSaldo());
	}

	@Override
	public void saque(double dinheiro) throws ContaException{
		if((getSaldo()+ getLimite()) < dinheiro) {
			throw new ContaException("Saldo Insuficiente!!");
		}else {
			setSaldo(getSaldo() - dinheiro);
		}
	}

}

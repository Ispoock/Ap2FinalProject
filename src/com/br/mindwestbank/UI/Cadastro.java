
package com.br.mindwestbank.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.br.mindwestbank.contas.modelo.*;
import com.br.mindwestbank.pessoas.exceptions.PessoaException;
import com.br.mindwestbank.pessoas.modelo.*;
import com.br.mindwestbank.util.Endereco;

/**Classe para montagem da tela de cadastro, onde deve ser informado nome, endereço cpf/cnpj.

 * @author Joao Vitor / Lucas Vitor.
 * @version 1.0


 */
public class Cadastro implements ActionListener {
	private JFrame janela1;
	private JButton botao1;
	private JPanel painel;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lbl7;
	private JLabel lbl8;
	private JLabel lbl9;
	private JLabel lbl10;
	private JLabel lbl11;
	private JLabel lbl12;
	private JTextField txtNome;
	private JTextField txt2;
	private JTextField txtCPFCNPJ;
	private JTextField txtTipe;
	private JTextField txttipoDeLogradouro;
	private JTextField txtlogradouro;
	private JTextField txtnumero;
	private JTextField txtbairro;
	private JTextField txtcidade;
	private JTextField txtestado;
	private JTextField txtcep;
	private JRadioButton radioFisica;
	private JRadioButton radioJuridica;
	private JCheckBox checkFuncionario;
	private CadastroFuncionario janelaFuncionario;
	private Pessoa pessoa; //polimorfismo
	private Endereco endereco;
	private Conta conta;

	private JRadioButton contaCorrente;
	private JRadioButton contaPoupanca;
	/** Método construtor da tela*/

	public Cadastro() {

		janela1 = new JFrame("Cadastro");
		lbl1 = new JLabel("Para realiza\u00E7\u00E3o do cadatro, precisaremos dos seguintes dados:");
		lbl1.setBounds(19, 11, 375, 14);
		lbl2 = new JLabel("Nome:");
		lbl2.setBounds(118, 48, 94, 14);
		txtNome = new JTextField(20);
		txtNome.setBounds(118, 65, 166, 20);
		lbl3 = new JLabel("Endereço:");
		txt2 = new JTextField(20);
		lbl4 = new JLabel("CPF/CNPJ:");
		lbl4.setBounds(118, 87, 126, 14);
		txtCPFCNPJ = new JTextField(20);
		txtCPFCNPJ.setBounds(118, 104, 166, 20);
		////

		lbl5 = new JLabel("Tipe:");
		lbl5.setBounds(118, 126, 94, 14);
		txtTipe = new JTextField(20);
		txtTipe.setBounds(118, 141, 166, 20);
		lbl6 = new JLabel("Tipo de logradouro:");
		lbl6.setBounds(118, 164, 154, 14);
		txttipoDeLogradouro = new JTextField(10);
		txttipoDeLogradouro.setBounds(118, 180, 166, 20);
		lbl7 = new JLabel("Logradouro:");
		lbl7.setBounds(118, 202, 154, 14);
		txtlogradouro = new JTextField(15);
		txtlogradouro.setBounds(118, 217, 166, 20);
		lbl8 = new JLabel("Número:");
		lbl8.setBounds(118, 241, 141, 14);
		txtnumero = new JTextField("0",20);
		txtnumero.setBounds(118, 260, 166, 20);
		lbl9 = new JLabel("Bairro:");
		lbl9.setBounds(118, 281, 141, 14);
		txtbairro = new JTextField(20);
		txtbairro.setBounds(118, 300, 166, 20);
		lbl10 = new JLabel("Cidade:");
		lbl10.setBounds(118, 323, 141, 14);
		txtcidade = new JTextField(20);
		txtcidade.setBounds(118, 340, 166, 20);
		lbl11 = new JLabel("Estado:");
		lbl11.setBounds(118, 362, 154, 14);
		txtestado = new JTextField(20);
		txtestado.setBounds(118, 379, 166, 20);
		lbl12 = new JLabel("CEP:");
		lbl12.setBounds(118, 400, 154, 14);
		txtcep = new JTextField(20);
		txtcep.setBounds(118, 415, 166, 20);


		////
		radioFisica = new JRadioButton("Pessoa Física");
		radioFisica.setBounds(83, 448, 116, 23);
		radioJuridica = new JRadioButton("Pessoa Jurídica");
		radioJuridica.setBounds(205, 448, 141, 23);
		botao1 = new JButton("Cadastrar");
		botao1.setBounds(150, 535, 109, 23);

		radioFisica.addActionListener(this);
		radioJuridica.addActionListener(this);
		botao1.addActionListener(this);

		checkFuncionario = new JCheckBox("Funcionário");
		checkFuncionario.setBounds(83, 468, 103, 23);
		checkFuncionario.setEnabled(false);

		contaCorrente = new JRadioButton("Conta Corrente");
		contaCorrente.setBounds(205, 494, 141, 23);
		contaPoupanca = new JRadioButton("Conta Poupança");
		contaPoupanca.setBounds(83, 494, 116, 23);

		painel = new JPanel();
		painel.setLayout(null);
		painel.add(lbl1);
		painel.add(lbl2);
		painel.add(txtNome);

		painel.add(lbl4);
		painel.add(txtCPFCNPJ);
		painel.add(lbl5);
		painel.add(txtTipe);
		painel.add(lbl6);
		painel.add(txttipoDeLogradouro);
		painel.add(lbl7);
		painel.add(txtlogradouro);
		painel.add(lbl8);
		painel.add(txtnumero);
		painel.add(lbl9);
		painel.add(txtbairro);
		painel.add(lbl10);
		painel.add(txtcidade);
		painel.add(lbl11);
		painel.add(txtestado);
		painel.add(lbl12);
		painel.add(txtcep);

		painel.add(radioFisica);
		painel.add(radioJuridica);
		painel.add(checkFuncionario);
		painel.add(contaCorrente);
		painel.add(contaPoupanca);

		contaCorrente.addActionListener(this);
		contaPoupanca.addActionListener(this);

		painel.add(botao1);

		janela1.getContentPane().add(painel);
		janela1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela1.setResizable(false);//não permite redimensionamento
		janela1.setBounds(0, 0, 420, 620);
		janela1.setLocationRelativeTo(null);//centro da tela
		janela1.setVisible(true);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == radioFisica) {
			radioJuridica.setSelected(false);
			checkFuncionario.setEnabled(true);
		}else if(e.getSource() == radioJuridica) {
			radioFisica.setSelected(false);
			checkFuncionario.setEnabled(false);
		}
		if(e.getSource() == contaCorrente) {
			contaPoupanca.setSelected(false);
		}else if(e.getSource() == contaPoupanca) {
			contaCorrente.setSelected(false);
		}
		else if(e.getSource() == botao1) {

			if(radioFisica.isSelected()) {
				this.cadastraEndereco();
				if(checkFuncionario.isSelected()) {

					try {
						janelaFuncionario = new CadastroFuncionario(txtNome.getText(),endereco,txtCPFCNPJ.getText());
						cadastraConta();
						janela1.dispose();

					} catch (PessoaException e1) {
						JOptionPane.showMessageDialog(null, "Por favor, digite um CPF válido", "Atenção", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					try {
						pessoa = new PessoaFisica(txtNome.getText(),endereco,txtCPFCNPJ.getText());
						cadastraConta();
						JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "", JOptionPane.INFORMATION_MESSAGE);

						janela1.dispose();
					} catch (PessoaException e1) {
						JOptionPane.showMessageDialog(null, "Por favor, digite um CPF válido", "Atenção", JOptionPane.ERROR_MESSAGE);
					}
				}

			}
			else if(radioJuridica.isSelected()) {
				this.cadastraEndereco();
				try {
					pessoa = new PessoaJuridica(txtNome.getText(),endereco,txtCPFCNPJ.getText());
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "", JOptionPane.INFORMATION_MESSAGE);
					janela1.dispose();
				} catch (PessoaException e1) {
					JOptionPane.showMessageDialog(null, "Por favor, digite um CNPJ válido", "Atenção", JOptionPane.ERROR_MESSAGE);
				}

			}
			else {
				JOptionPane.showMessageDialog(null, "Por favor, escolha Pessoa Física ou Pessoa Jurídica", "Atenção", JOptionPane.ERROR_MESSAGE);
			}
			 
		}

	}

	public void cadastraConta() {
		if(contaPoupanca.isSelected()) {
			conta = new Poupanca(pessoa);
		}else if(contaCorrente.isSelected()) {
			conta = new ContaCorrente(pessoa);
		}
	}

	public void cadastraEndereco() {
		if(txtTipe.getText() == null) {
			endereco = new Endereco(txttipoDeLogradouro.getText(), txtlogradouro.getText(), Integer.parseInt(txtnumero.getText()), txtbairro.getText(), txtcidade.getText(),
					txtestado.getText(), txtcep.getText());
		}else {
			endereco = new Endereco(txtTipe.getText(), txttipoDeLogradouro.getText(), txtlogradouro.getText(), Integer.parseInt(txtnumero.getText()), txtbairro.getText(), txtcidade.getText(),
					txtestado.getText(), txtcep.getText());
		}
	}
}


package com.br.mindwestbank.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.br.mindwestbank.pessoas.exceptions.PessoaException;
import com.br.mindwestbank.pessoas.modelo.*;
import com.br.mindwestbank.util.Endereco;
/**Classe para montagem da tela de cadastro,onde deve ser informado nome,endereço cpf/cnpj.

 * @author Joao Vitor

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
		
		private Pessoa pessoa; //polimorfismo
		private Endereco endereco;
	    /** Método construtor da tela*/
		public Cadastro() {
			janela1 = new JFrame("Cadastro");
			lbl1 = new JLabel("Insira os dados solicitados:                                ");
			lbl2 = new JLabel("Nome:");
			txtNome = new JTextField(20);
			lbl3 = new JLabel("Endereço:");
			txt2 = new JTextField(20);
			lbl4 = new JLabel("CPF/CNPJ:");
			txtCPFCNPJ = new JTextField(20);
			////
			
			lbl5 = new JLabel("Tipe:");
			txtTipe = new JTextField(20);
			lbl6 = new JLabel("Tipo de logradouro:");
			txttipoDeLogradouro = new JTextField(10);
			lbl7 = new JLabel("Logradouro:");
			txtlogradouro = new JTextField(15);
			lbl8 = new JLabel("Número:");
			txtnumero = new JTextField("0",20);
			lbl9 = new JLabel("Bairro:");
			txtbairro = new JTextField(20);
			lbl10 = new JLabel("Cidade:");
			txtcidade = new JTextField(20);
			lbl11 = new JLabel("Estado:");
			txtestado = new JTextField(20);
			lbl12 = new JLabel("CEP:");
			txtcep = new JTextField(20);
			
			
			////
			radioFisica = new JRadioButton("Pessoa Física");
			radioJuridica = new JRadioButton("Pessoa Jurídica");
			botao1 = new JButton("Cadastrar");
			
			radioFisica.addActionListener(this);
			radioJuridica.addActionListener(this);
			botao1.addActionListener(this);
			
			painel = new JPanel();
			painel.add(lbl1);
			painel.add(lbl2);
			painel.add(txtNome);
			//painel.add(lbl3);
			//painel.add(txt2);
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
			
			painel.add(botao1);
			
			janela1.add(painel);
			janela1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			janela1.setResizable(false);//não permite redimensionamento
			janela1.setBounds(0, 0, 280, 620);
			janela1.setLocationRelativeTo(null);//centro da tela
			janela1.setVisible(true);
			
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == radioFisica) {
				radioJuridica.setSelected(false);
			}else if(e.getSource() == radioJuridica) {
				radioFisica.setSelected(false);
			}
			else if(e.getSource() == botao1) {
				
				if(radioFisica.isSelected()) {
					this.cadastraEndereco();
					try {
						pessoa = new PessoaFisica(txtNome.getText(),endereco,txtCPFCNPJ.getText());
					} catch (PessoaException e1) {
						JOptionPane.showMessageDialog(null, "Por favor, digite um CPF válido", "Atenção", JOptionPane.ERROR_MESSAGE);
					}
				}
				else if(radioJuridica.isSelected()) {
					this.cadastraEndereco();
					try {
						pessoa = new PessoaJuridica(txtNome.getText(),endereco,txtCPFCNPJ.getText());
					} catch (PessoaException e1) {
						JOptionPane.showMessageDialog(null, "Por favor, digite um CNPJ válido", "Atenção", JOptionPane.ERROR_MESSAGE);
					}
					 
				}
				else {
					JOptionPane.showMessageDialog(null, "Por favor, escolha Pessoa Física ou Pessoa Jurídica", "Atenção", JOptionPane.ERROR_MESSAGE);
				}
				
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

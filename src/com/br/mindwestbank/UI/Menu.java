

package com.br.mindwestbank.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
/**Classe para montagem da tela de menu principal.

 * @author Joao Vitor

 * @version 1.0

 */
public class Menu implements ActionListener{
	private JFrame janela;
	private JLabel label1;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JPanel painel;
	private CaixaEletronico caixa;
	private Cadastro dados;
    /** Método construtor da tela*/
	public Menu() {
		janela = new JFrame("Menu");
		label1 = new JLabel("Escolha uma opção");
		btn1 = new JButton("CaixaEletrônico");
		btn2 = new JButton("Cadastro");
		btn3 = new JButton("Sair");
		painel = new JPanel();
		
		
		painel.add(label1);
		painel.add(btn1);
		painel.add(btn2);
		painel.add(btn3);
		janela.add(painel);
		
		btn3.addActionListener(this);
		btn2.addActionListener(this);
		btn1.addActionListener(this);
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setResizable(false);
		janela.setBounds(0, 0, 360, 120);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn3) {//botão sair
			System.exit(0);
		}else if(e.getSource() == btn2) {//botão Dados1
			dados = new Cadastro();
		}else if(e.getSource() == btn1) {//botão CaixaEletrônico
			caixa = new CaixaEletronico();
			if(!((caixa.getDate().getHours()>=7 && caixa.getDate().getHours()<=22) || (caixa.getDate().getHours()==22 && caixa.getDate().getMinutes()==0))) {
				JOptionPane.showMessageDialog(null, "Não é possível realizar operações neste horário!");
				caixa.getJanela().dispose();
			}
		}
		
	}
}

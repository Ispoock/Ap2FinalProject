

package com.br.mindwestbank.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
/**Classe para montagem da tela do ATM,onde deve ser informado o número da conta e a operação a ser realizada (saldo,
saque, deposito). A janela responsável pelo caixa eletrônico deverá exibir a hora atual, e somente deverá ser
possível realizar operações das 7:00hrs às 22:00hrs.

 * @author Joao Vitor

 * @version 1.0

 */
public class CaixaEletronico implements ActionListener, Runnable{
	
	public void run() {
		while(true) {
			data = new Date();
			hms = Integer.toString(this.data.getHours()) + ":" + Integer.toString(this.data.getMinutes())
			+ ":" + Integer.toString(this.data.getSeconds());
			
			horario.setText(hms);
			
			try {
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private JFrame janela;
	private JTextField nConta;
	private JTextField operacao;
	private JButton btn1;
	private JButton btn2;
	private JPanel painel;
	private JLabel label1;
	private JLabel label2;
	private JLabel horario;
	private Date data;
	private String hms;//hora_minuto_segundo
    /** Método construtor da tela*/
	public CaixaEletronico() {
		janela = new JFrame("Caixa eletrônico");
		nConta = new JTextField(15);
		btn1 = new JButton("OK");
		btn2 = new JButton("Voltar");
		painel = new JPanel();
		label1 = new JLabel("Número da conta:");
		label2 = new JLabel("Operação a ser realizada (saldo, saque ou deposito):");
		operacao = new JTextField(10);
		horario = new JLabel("00:00:00");
		Thread contaHora = new Thread(this);
		contaHora.start();
		
		painel.add(label1);
		painel.add(nConta);
		painel.add(label2);
		painel.add(operacao);
		painel.add(btn1);
		painel.add(btn2);
		painel.add(horario);
		janela.add(painel);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setResizable(false);//não permite redimensionamento
		janela.setBounds(0, 0, 450, 140);
		janela.setLocationRelativeTo(null);//centro da tela
		//janela.pack();
		janela.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1) {
			if((this.data.getHours()>=7 && this.data.getHours()<=21) || (this.data.getHours()==22 && this.data.getMinutes()==0)) {
				//realização das operações
			}else {
				JOptionPane.showMessageDialog(null, "Não é possível realizar operações neste horário!");
				janela.dispose();
			}
		}else if(e.getSource()==btn2) {
			janela.dispose();
		}	
	}
	
	public Date getDate() {
		return this.data;
	}
	public JFrame getJanela() {
		return this.janela;
	}
	
	
}



package com.br.mindwestbank.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

/**Classe para montagem da tela do ATM,onde deve ser informado o número da conta e a operação a ser realizada (saldo,
   saque, deposito). A janela responsável pelo caixa eletrônico deverá exibir a hora atual, e somente deverá ser
   possível realizar operações das 7:00hrs às 22:00hrs.

 * @author Joao Vitor / Lucas Vitor.

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
	private JLabel dataTime;
	private Date data;
	private String hms;//hora_minuto_segundo
	
    /** 
     * Método construtor da tela
     */
	
	public CaixaEletronico() {
		janela = new JFrame("Caixa eletrônico");
		nConta = new JTextField(15);
		nConta.setBounds(144, 105, 126, 20);
		btn1 = new JButton("OK");
		btn1.setBounds(188, 145, 47, 23);
		btn2 = new JButton("Voltar");
		btn2.setBounds(10, 145, 61, 23);
		painel = new JPanel();
		label1 = new JLabel("Número da conta:");
		label1.setBounds(144, 40, 100, 14);
		label2 = new JLabel("Operação: (saldo, saque ou deposito):");
		label2.setBounds(144, 90, 255, 14);
		operacao = new JTextField(10);
		operacao.setBounds(144, 56, 126, 20);
		horario = new JLabel("00:00:00");
		horario.setBounds(355, 11, 59, 14);
		Thread contaHora = new Thread(this);
		contaHora.start();
		painel.setLayout(null);

		dataTime = new AtualizaData();
		dataTime.setBounds(10, 11, 64, 14);

		painel.add(label1);
		painel.add(nConta);
		painel.add(label2);
		painel.add(operacao);
		painel.add(btn1);
		painel.add(btn2);
		painel.add(horario);
		painel.add(dataTime);
		janela.getContentPane().add(painel);

		btn1.addActionListener(this);
		btn2.addActionListener(this);

		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setResizable(false);//não permite redimensionamento
		janela.setBounds(0, 0, 440, 214);
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
	public class AtualizaData extends JLabel{

		public AtualizaData() {
			Timer t = new Timer(1000, e -> setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
			t.setInitialDelay(0);
			t.start();
		}
	}
}

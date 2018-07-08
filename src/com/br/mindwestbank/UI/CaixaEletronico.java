package com.br.mindwestbank.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

import com.br.mindwestbank.Data.DataBase;
import com.br.mindwestbank.Data.DataBaseException;
import com.br.mindwestbank.contas.modelo.Conta;

/**Classe para montagem da tela do ATM, onde deve ser informado o n�mero da conta e a opera��o a ser realizada (saldo,
   saque, deposito). A janela respons�vel pelo caixa eletr�nico dever� exibir a hora atual, e somente dever� ser
   poss�vel realizar opera��es das 7:00hrs �s 22:00hrs.

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
	private JTextField operacao;
	private JTextField nConta;
	private JButton btn1;
	private JButton btn2;
	private JPanel painel;
	private JLabel label1;
	private JLabel label2;
	private JLabel horario;
	private JLabel dataTime;
	private Date data;
	private String hms;//hora_minuto_segundo
	private Conta conta;


	/** 
	 * M�todo construtor da tela
	 */

	public CaixaEletronico() {
		janela = new JFrame("Caixa eletronico");
		operacao = new JTextField(15);
		operacao.setBounds(144, 105, 126, 25);
		btn1 = new JButton("OK");
		btn1.setBounds(188, 145, 47, 23);
		btn2 = new JButton("Voltar");
		btn2.setBounds(10, 145, 61, 23);
		painel = new JPanel();
		label1 = new JLabel("Numero da conta:");
		label1.setBounds(144, 40, 100, 14);
		label2 = new JLabel("Operacao: (saldo, saque ou deposito):");
		label2.setBounds(144, 90, 255, 14);
		nConta = new JTextField(10);
		nConta.setBounds(144, 56, 126, 25);
		horario = new JLabel("00:00:00");
		horario.setBounds(355, 11, 59, 14);
		Thread contaHora = new Thread(this);
		contaHora.start();
		painel.setLayout(null);

		dataTime = new AtualizaData();
		dataTime.setBounds(10, 11, 64, 14);

		painel.add(label1);
		painel.add(operacao);
		painel.add(label2);
		painel.add(nConta);
		painel.add(btn1);
		painel.add(btn2);
		painel.add(horario);
		painel.add(dataTime);
		janela.getContentPane().add(painel);

		btn1.addActionListener(this);
		btn2.addActionListener(this);

		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setResizable(false);//n�o permite redimensionamento
		janela.setBounds(0, 0, 440, 214);
		janela.setLocationRelativeTo(null);//centro da tela
		//janela.pack();
		janela.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1) {
			if((this.data.getHours()>=7 && this.data.getHours()<=21) || (this.data.getHours()==22 && this.data.getMinutes()==0)) {
				try {
					
					conta = DataBase.getConta(Integer.parseInt(nConta.getText()));
					
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Digite um n�mero de conta v�lido!", "Aten��o", JOptionPane.ERROR_MESSAGE);
				}catch(DataBaseException e1) {
					JOptionPane.showMessageDialog(null, "Conta n�o encontrada!", "Aten��o", JOptionPane.ERROR_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "N�o � poss�vel realizar opera��es neste hor�rio!");
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



package interfacesGraficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Menu implements ActionListener{
	private JFrame janela;
	private JLabel label1;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JPanel painel;
	private CaixaEletronico caixa;
	private Cadastro dados;
	
	public Menu() {
		janela = new JFrame("Menu");
		label1 = new JLabel("Escolha uma op��o");
		btn1 = new JButton("CaixaEletr�nico");
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
		janela.setBounds(0, 0, 350, 110);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn3) {//bot�o sair
			System.exit(0);
		}else if(e.getSource() == btn2) {//bot�o Dados1
			dados = new Cadastro();
		}else if(e.getSource() == btn1) {//bot�o CaixaEletr�nico
			caixa = new CaixaEletronico();
			if(!((caixa.getDate().getHours()>=7 && caixa.getDate().getHours()<=22) || (caixa.getDate().getHours()==22 && caixa.getDate().getMinutes()==0))) {
				JOptionPane.showMessageDialog(null, "N�o � poss�vel realizar opera��es neste hor�rio!");
				caixa.getJanela().dispose();
			}
		}
		
	}
}

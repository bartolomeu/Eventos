package views;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controllers.NovoEventoController;
import core.Model;
import core.View;

public class NovoEventoView extends JPanel implements View {

	private NovoEventoController novoEventoController;
	private JTextField textoDescricao;
	private JTextField textoEmail;
	private JFormattedTextField date;
	private JCheckBox checkAlarme;
	private JRadioButton radioDiario;
	private JRadioButton radioSemanal;
	private JRadioButton radioMensal;
	
	public NovoEventoView(NovoEventoController novoEventoController) throws ParseException {
		
		this.novoEventoController = novoEventoController;
		
		makeFrame();
		makeCampoDescricao();
		makeCampoEmail();
		makeCampoData();
		makeCampoFrequencia();
		makeAlarme();
		
	}
	
	public void makeFrame() {
		setLayout(null);
	}
	
	public void makeCampoDescricao() {
		
		//label ou rótulo
		JLabel label = new JLabel("Descrição do Evento");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(29, 29, 134, 14);
		add(label);
		
		//campo
		textoDescricao = new JTextField();
		textoDescricao.setBounds(169, 26, 196, 20);
		add(textoDescricao);
		textoDescricao.setColumns(10);
	}
	
	public void makeCampoEmail() {
		
		//label
		JLabel label = new JLabel("Email para Envio");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(29, 71, 104, 14);
		add(label);
		
		//campo
		textoEmail = new JTextField();
		textoEmail.setBounds(169, 68, 196, 20);
		add(textoEmail);
		textoEmail.setColumns(10);
		
	}
	
	public void makeCampoData() throws ParseException {
		
		//label
		JLabel label = new JLabel("Data");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(29, 119, 78, 14);
		add(label);
		
		
		//campo
		date = new JFormattedTextField(new MaskFormatter("##/##/####"));
		date.setBounds(169, 116, 96, 20);
		add(date);
		date.setColumns(10);
	}
	
	public void makeCampoFrequencia() {
		
		ButtonGroup btnGroup = new ButtonGroup();
		
		//label frequencia
		JLabel frequencia = new JLabel("Frequência");
		frequencia.setFont(new Font("Tahoma", Font.BOLD, 11));
		frequencia.setBounds(29, 164, 78, 14);
		add(frequencia);
		
		// campo opção diário
		radioDiario = new JRadioButton("Diário");
		btnGroup.add(radioDiario);
		radioDiario.setSelected(true);
		radioDiario.setBounds(169, 160, 60, 23);
		add(radioDiario);
		
		// campo opção semanal
		radioSemanal = new JRadioButton("Semanal");
		btnGroup.add(radioSemanal);
		radioSemanal.setBounds(253, 160, 67, 23);
		add(radioSemanal);
		
		// campo opção mensal
		radioMensal = new JRadioButton("Mensal");
		btnGroup.add(radioMensal);
		radioMensal.setBounds(347, 160, 78, 23);
		add(radioMensal);
	
	}
	
	public void makeAlarme() {
		
		checkAlarme = new JCheckBox("Alarme");
		checkAlarme.setBounds(29, 220, 89, 23);
		add(checkAlarme);
	}
	
	
	
	@Override
	public void update(Model model, Object data) {
		// TODO Auto-generated method stub
		
	}

}

package controllers;

import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import core.Controller;
import views.ListaEventoView;

public class ListaEventoController extends Controller{

	public ListaEventoView listaEventoView;
	public JTable tabela;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public void addNovaLinha(Object[] values) {
		
		((DefaultTableModel) tabela.getModel()).addRow(values);
		
	}
	
	public Vector<String> getNameColumns(){
		
		Vector<String> nameColumns = new Vector<String>();
		
		nameColumns.add("Data");
		nameColumns.add("Descrição");
		nameColumns.add("Frequência");
		nameColumns.add("Email");
		nameColumns.add("Alarme");
		
		return nameColumns;
		
	}
	
}

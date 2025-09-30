package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import core.Model;
import core.View;

public class EventoIO implements Model {

	private final static String DIRETORIO  = "";
	private final static String FILE = "eventos.txt";
	private List<View> views = new ArrayList<>();
	private String notice;
	
	public void salvarEvento(Evento evento) throws FileNotFoundException {
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(DIRETORIO + FILE));
			writer.write(evento.toString(), 0, evento.toString().length());
			writer.newLine();
			writer.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Vector<Vector<Object>> getEventos(){
		
		Vector<Vector<Object>> dados = new Vector<Vector<Object>>();
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(DIRETORIO + FILE));
			String linha = reader.readLine();
			
			while(linha != null) {
				
				Vector<Object> eventoInfo = new Vector<Object>();
				String[] tokens = linha.split(";");
				
				eventoInfo.add(tokens[0]);
				eventoInfo.add(tokens[1]);
				eventoInfo.add(tokens[2]);
				eventoInfo.add(tokens[3]);
				eventoInfo.add(tokens[4].equals("1") ? "ON" : "OFF");
				
				dados.add(eventoInfo);
				linha = reader.readLine();
				
			}
			
			reader.close();
			
		} catch( Exception e) {
			e.printStackTrace();
		}
		
		return dados;
		
	}
	
	@Override
	public void attach(View view) {
		// TODO Auto-generated method stub
		views.add(view);
	}

	@Override
	public void detach(View view) {
		// TODO Auto-generated method stub
		views.remove(view);
	}

	@Override
	public void notificarViews() {
		// TODO Auto-generated method stub
		for(View v: views) {
			v.update(this, notice);
		}
	}

}

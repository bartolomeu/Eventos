package model;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import core.Model;
import core.View;

public class EventoIO implements Model {

	private final static String DIRETORIO  = "home/lucasrod/";
	private final static String FILE = "evento.txt";
	private List<View> views = new ArrayList<>();
	
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
	
	@Override
	public void attach(View view) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detach(View view) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notificarViews() {
		// TODO Auto-generated method stub
		
	}

}

package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import core.DB;
import core.Model;
import core.View;

public class EventoDB implements Model{

    private Connection conn;
    private List<View> views = new ArrayList<>();
    private String notice;

    public EventoDB() {
		conn = DB.getConnection();
	}

    
	public List<Evento> getAll() {
        List<Evento> eventos = new ArrayList<Evento>();
		
		try {
			
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM evento");
			while(resultSet.next()) {
				
				Evento evento = new Evento(resultSet);
				eventos.add(evento);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return eventos;
    }

    public Vector<Vector<Object>> getEventos() {
    	Vector<Vector<Object>> result = new Vector<Vector<Object>>();
        List<Evento> dados = this.getAll();
        for (Evento evento : dados) {
			Vector<Object> dado = new Vector<Object>();
			dado.add(EventoUtil.formatDate(evento.getDate()));
			dado.add(evento.getDescricaoEvento());
			dado.add(evento.getFrequencia());
			dado.add(evento.getEmail());
			dado.add(evento.isAlarme()? '1': '0');
			result.add(dado);
		}
        return result;
    }

    public void salvarEvento(Evento evento) {
        String sql = "INSERT INTO `evento` (`data`, `descricao`, `frequencia`, `email`, `alarme`) VALUES (?,?,?,?,?)";
        try {
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setDate(1, new Date(evento.getDate().getTime()));
			stat.setString(2, evento.getDescricaoEvento());
			stat.setString(3, evento.getFrequencia().toString());
			stat.setString(4, evento.getEmail());
			stat.setBoolean(5, evento.isAlarme());
			
			int affected = stat.executeUpdate();
			if(affected > 0) {
				System.out.println("Dados inseridos com sucesso");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
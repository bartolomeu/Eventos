package model;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Evento {

  private int id;
	private String descricaoEvento;
	private String email;
	private Date date;
	private boolean alarme;
	private Frequencia frequencia;

  public Evento() {}
  
  public Evento( ResultSet rs) {
		try {
			this.id = rs.getInt("id");
			this.date = rs.getDate("data");
			this.descricaoEvento = rs.getString("descricao");
			this.frequencia = Frequencia.fromString(rs.getString("frequencia"));
			this.alarme = rs.getBoolean("alarme");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public String getDescricaoEvento() {
		return descricaoEvento;
	}
	public void setDescricaoEvento(String descricaoEvento) {
		this.descricaoEvento = descricaoEvento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isAlarme() {
		return alarme;
	}
	public void setAlarme(boolean alarme) {
		this.alarme = alarme;
	}
	public Frequencia getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(Frequencia frequencia) {
		this.frequencia = frequencia;
	}
	
	@Override
	public String toString() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		return sdf.format(date) + ";"
				+ getDescricaoEvento() + ";"
				+ getFrequencia() + ";"
				+ getEmail() + ";"
				+ (isAlarme() == true ? "1" : "0");
		
	}
	
	
	
	
}

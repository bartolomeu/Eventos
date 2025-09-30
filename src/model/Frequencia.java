package model;

public enum Frequencia {
	DIARIO, SEMANAL, MENSAL;

  public static Frequencia fromString(String st){
		switch (st) {
		case "DIARIO":
			return Frequencia.DIARIO;
		case "SEMANAL":
			return Frequencia.SEMANAL;
		case "MENSAL":
			return Frequencia.MENSAL;

		default:
			throw new Error(st + " não possui um correspondente no Enum Frequencia");
		}
	}
}

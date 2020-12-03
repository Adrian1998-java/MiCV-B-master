package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Idioma extends Conocimiento{
	StringProperty certificacion = new SimpleStringProperty();
	
	public Idioma() {
		
	}
	
	public Idioma(String denominacion, String nivel, String certificacion) {
		super();
		this.denominacion.set(denominacion);
		this.nivel.set(nivel);
		this.certificacion.set(certificacion);
	}
	
	
	public StringProperty certificacionProperty() {
		return this.certificacion;
	}
	
	public String getCertificacion() {
		return this.certificacion.get();
	}
	
	public void setCertificacion(String certificacion) {
		this.certificacion.set(certificacion);
	}
}

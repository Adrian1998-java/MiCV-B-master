package model;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Conocimiento {

	StringProperty denominacion = new SimpleStringProperty();
	StringProperty nivel = new SimpleStringProperty();

	public Conocimiento() {

	}

	public Conocimiento(String denominacion, String nivel) {
		super();
		this.denominacion.set(denominacion);
		this.nivel.set(nivel);
	}

	public StringProperty denominacionProperty() {
		return denominacion;
	}

	public String getDenominacion() {
		return this.denominacion.get();
	}

	public void setDenominacion(String denominacion) {
		this.denominacion.set(denominacion);
	}

	public StringProperty nivelProperty() {
		return nivel;
	}

	public String getNivel() {
		return this.nivel.get();
	}

	public void setNivel(String nivel) {
		this.nivel.set(nivel);
	}

}

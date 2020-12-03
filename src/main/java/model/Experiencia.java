package model;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Experiencia {
	private ObjectProperty<LocalDate> fechaDesde = new SimpleObjectProperty<LocalDate>();
	private ObjectProperty<LocalDate> fechaHasta = new SimpleObjectProperty<LocalDate>();
	private StringProperty denominacion = new SimpleStringProperty();
	private StringProperty empleador = new SimpleStringProperty();

	public Experiencia() {

	}

	public Experiencia(String denominacion, String empleador, LocalDate desde, LocalDate hasta) {
		super();
		this.denominacion.set(denominacion);
		this.empleador.set(empleador);
		this.fechaDesde.set(desde);
		this.fechaHasta.set(hasta);
	}

	public ObjectProperty<LocalDate> fechaDesdeProperty() {
		return fechaDesde;
	}

	public void setFechaDesde(ObjectProperty<LocalDate> fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public LocalDate getFechaDesde() {
		return this.fechaDesde.get();
	}

	public ObjectProperty<LocalDate> fechaHastaProperty() {
		return fechaHasta;
	}

	public void setFechaHasta(ObjectProperty<LocalDate> fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public LocalDate getFechaHasta() {
		return this.fechaHasta.get();
	}

	public StringProperty denominacionProperty() {
		return denominacion;
	}

	public void setDenominacion(StringProperty denominacion) {
		this.denominacion = denominacion;
	}

	public String getDenominacion() {
		return this.denominacion.get();
	}

	public StringProperty empleadorProperty() {
		return empleador;
	}

	public void setEmpleador(StringProperty organizador) {
		this.empleador = organizador;
	}

	public String getEmpleador() {
		return this.empleador.get();
	}

	@Override
	public String toString() {
		return "Conocimiento [fechaDesde=" + fechaDesde + ", fechaHasta=" + fechaHasta + ", denominacion="
				+ denominacion + ", empleador=" + empleador + "]";
	}
	
	
}

package model;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Titulo {
	private ObjectProperty<LocalDate> fechaDesde = new SimpleObjectProperty<LocalDate>();
	private ObjectProperty<LocalDate> fechaHasta = new SimpleObjectProperty<LocalDate>();
	private StringProperty denominacion = new SimpleStringProperty();
	private StringProperty organizador = new SimpleStringProperty();
	
	public Titulo() {
		
	}
	
	public Titulo(String denominacion, String organizador, LocalDate desde, LocalDate hasta) {
		super();
		this.denominacion.set(denominacion);
		this.organizador.set(organizador);
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

	public StringProperty organizadorProperty() {
		return organizador;
	}

	public void setOrganizador(StringProperty organizador) {
		this.organizador = organizador;
	}
	
	public String getOrganizador() {
		return this.organizador.get();
	}

	@Override
	public String toString() {
		return "Titulo [fechaDesde=" + fechaDesde + ", fechaHasta=" + fechaHasta + ", denominacion=" + denominacion
				+ ", organizador=" + organizador + "]";
	}
	
	
	
}

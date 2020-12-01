package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Telefono {

	private StringProperty numero = new SimpleStringProperty();
	private StringProperty tipo = new SimpleStringProperty();
	
	public Telefono() {
		
	}
	
	public Telefono(String numero, String tipo) {
		super();
		this.numero.set(numero);
		this.tipo.set(tipo);
	}
	
	public String getNumero() {
		return numero.get();
	}
	
	public StringProperty numeroProperty() {
		return numero;
	}
	
	public final void setNumero(final String numero) {
		this.numero.set(numero);
	}
	
	public String getTipo() {
		return tipo.get();
	}
	
	public void setTipo(String tipo) {
		this.tipo.set(tipo);
	}
	
	public StringProperty tipoProperty() {
		return this.tipo;
	}

	@Override
	public String toString() {
		return numero.get() + " | " + tipo.get();
	}
	
	
	
	
}

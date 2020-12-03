package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Email {
	private StringProperty direccion = new SimpleStringProperty();
	
	public Email() {
		
	}

	public Email(String direccion) {
		super();
		this.direccion.set(direccion);
	}

	public StringProperty direccionProperty() {
		return direccion;
	}
	
	public String getDireccion() {
		return direccion.get();
	}

	public void setDireccion(StringProperty direccion) {
		this.direccion = direccion;
	}
	
	
}

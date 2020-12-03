package model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

public class Formacion {
	ListProperty<Titulo> titulos = new SimpleListProperty<Titulo>(FXCollections.observableArrayList());
	
	public Formacion(){
		
	}

	public ListProperty<Titulo> titulosProperty() {
		return titulos;
	}

	public void setTitulos(ListProperty<Titulo> titulos) {
		this.titulos = titulos;
	}
	
	
}

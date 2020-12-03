package model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

public class Experiencia {
	ListProperty<Conocimiento> conocimientos = new SimpleListProperty<Conocimiento>(
			FXCollections.observableArrayList());

	public Experiencia() {

	}

	public ListProperty<Conocimiento> conocimientosProperty() {
		return conocimientos;
	}

	public void setConocimientos(ListProperty<Conocimiento> conocimientos) {
		this.conocimientos = conocimientos;
	}
}

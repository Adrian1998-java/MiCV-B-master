package model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

public class Contacto {
	private ListProperty<Telefono> numeros = new SimpleListProperty<Telefono>(FXCollections.observableArrayList());
	private ListProperty<String> emails = new SimpleListProperty<String>(FXCollections.observableArrayList());
	private ListProperty<String> webs = new SimpleListProperty<String>(FXCollections.observableArrayList());
	
	public ListProperty<Telefono> numerosProperty() {
		return numeros;
	}
	public void setNumeros(ListProperty<Telefono> numeros) {
		this.numeros = numeros;
	}
	public ListProperty<String> emailsProperty() {
		return emails;
	}
	public void setEmails(ListProperty<String> emails) {
		this.emails = emails;
	}
	public ListProperty<String> websProperty() {
		return webs;
	}
	public void setWebs(ListProperty<String> webs) {
		this.webs = webs;
	}
	
	
}

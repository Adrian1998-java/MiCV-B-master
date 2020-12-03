package model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

public class Contacto {
	private ListProperty<Telefono> numeros = new SimpleListProperty<Telefono>(FXCollections.observableArrayList());
	private ListProperty<Email> emails = new SimpleListProperty<Email>(FXCollections.observableArrayList());
	private ListProperty<Url> webs = new SimpleListProperty<Url>(FXCollections.observableArrayList());
	
	public ListProperty<Telefono> numerosProperty() {
		return numeros;
	}
	public void setNumeros(ListProperty<Telefono> numeros) {
		this.numeros = numeros;
	}
	public ListProperty<Email> emailsProperty() {
		return emails;
	}
	public void setEmails(ListProperty<Email> emails) {
		this.emails = emails;
	}
	public ListProperty<Url> websProperty() {
		return webs;
	}
	public void setWebs(ListProperty<Url> webs) {
		this.webs = webs;
	}
	
	
}

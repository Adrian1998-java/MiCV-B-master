package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;
import model.Contacto;
import model.Email;
import model.Telefono;
import model.Url;

public class ContactoController implements Initializable {

	private ObjectProperty<Contacto> contacto = new SimpleObjectProperty<>();

	@FXML
	private AnchorPane view;

	@FXML
	private TableView tableTelefono;

	@FXML
	private TableColumn<Telefono, String> columnNumero;

	@FXML
	private TableColumn<Telefono, String> columnTipo;

	@FXML
	private Button btnAgregarTelefono;

	@FXML
	private Button btnEliminarTelefono;

	@FXML
	private TableView<Email> tableEmail;

	@FXML
	private TableColumn<Email, String> columnEmail;

	@FXML
	private Button btnAgregarEmail;

	@FXML
	private Button btnEliminarEmail;

	@FXML
	private TableView<Url> tableUrl;

	@FXML
	private TableColumn<Url, String> columnUrl;

	@FXML
	private Button btnAgregarUrl;

	@FXML
	private Button btnEliminarUrl;

	@FXML
	void eliminarTelefono(ActionEvent event) {
		Telefono telefono = (Telefono) tableTelefono.getSelectionModel().getSelectedItem();

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setHeaderText(null);
		alert.setTitle("Eliminar telefono");
		alert.setContentText("¿Estas seguro de que quieres borrar este telefono? \n " + telefono);
		Optional<ButtonType> action = alert.showAndWait();

		if (action.get() == ButtonType.OK) {
			tableTelefono.getItems().remove(telefono);
		}

	}

	@FXML
	void agregarTelefono(ActionEvent event) {
		// Create the custom dialog.
		Dialog<Pair<String, String>> dialog = new Dialog<>();
		dialog.setTitle("Nuevo telefono");
		dialog.setHeaderText("Agregar un nuevo telefono");

		ButtonType loginButtonType = new ButtonType("Agregar", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		TextField telefono = new TextField();
		telefono.setPromptText("Numero");
		ComboBox tipo = new ComboBox();
		tipo.setPromptText("Seleccione un tipo");
		tipo.getItems().addAll("Móvil", "Fijo");

		grid.add(new Label("Número: "), 0, 0);
		grid.add(telefono, 1, 0);
		grid.add(new Label("Tipo: "), 0, 1);
		grid.add(tipo, 1, 1);

		dialog.getDialogPane().setContent(grid);

		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				return new Pair<>(telefono.getText().toString(), tipo.getSelectionModel().getSelectedItem().toString());
			}
			return null;
		});

		Optional<Pair<String, String>> result = dialog.showAndWait();

		if (result.isPresent()) {
			Pair<String, String> eleccion = result.get();
			Telefono nuevo = new Telefono(eleccion.getKey(), eleccion.getValue().toString());

			tableTelefono.getItems().add(nuevo);
		}
	}

	@FXML
	void agregarEmail(ActionEvent event) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Agregar Email");
		dialog.setHeaderText("Agregar un nuevo email de contacto");
		dialog.setContentText("Por favor escriba su email");

		Optional<String> result = dialog.showAndWait();

		// The Java 8 way to get the response value (with lambda expression).
		result.ifPresent(name -> {
			tableEmail.getItems().add( new Email(name));
		});
	}


	@FXML
	void eliminarEmail(ActionEvent event) {
		Email email = tableEmail.getSelectionModel().getSelectedItem();

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setHeaderText(null);
		alert.setTitle("Eliminar email");
		alert.setContentText("¿Estas seguro de que quieres borrar este email? \n " + email);
		Optional<ButtonType> action = alert.showAndWait();

		if (action.get() == ButtonType.OK) {
			tableEmail.getItems().remove(email);
		}

	}
	
	@FXML
	void agregarUrl(ActionEvent event) {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Agregar Url");
		dialog.setHeaderText("Agregar una nueva Url de contacto");
		dialog.setContentText("Por favor escriba su Url");

		Optional<String> result = dialog.showAndWait();

		// The Java 8 way to get the response value (with lambda expression).
		result.ifPresent(name -> tableUrl.getItems().add(new Url(name)));
	}
	
	@FXML
	void eliminarUrl(ActionEvent event) {
		Url url = tableUrl.getSelectionModel().getSelectedItem();

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setHeaderText(null);
		alert.setTitle("Eliminar Url");
		alert.setContentText("¿Estas seguro de que quieres borrar esta Url? \n " + url);
		Optional<ButtonType> action = alert.showAndWait();

		if (action.get() == ButtonType.OK) {
			tableUrl.getItems().remove(url);
		}

	}

	private void onContactoChanged(ObservableValue<? extends Contacto> o, Contacto ov, Contacto nv) {

		System.out.println("ov=" + ov + "/nv=" + nv);

		if (ov != null) {

			tableTelefono.itemsProperty().unbindBidirectional(ov.numerosProperty());
			tableEmail.itemsProperty().unbindBidirectional(ov.emailsProperty());
			tableUrl.itemsProperty().unbindBidirectional(ov.websProperty());
			// TODO desbindear el resto de propiedades

		}

		if (nv != null) {

			tableTelefono.itemsProperty().bindBidirectional(nv.numerosProperty());
			tableEmail.itemsProperty().bindBidirectional(nv.emailsProperty());
			tableUrl.itemsProperty().bindBidirectional(nv.websProperty());
			// TODO bindear el resto de propiedades

		}

	}

	public ContactoController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ContactoView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		contacto.addListener((o, ov, nv) -> onContactoChanged(o, ov, nv));

		columnNumero.setCellValueFactory(new PropertyValueFactory<Telefono, String>("numero"));
		columnNumero.setCellFactory(TextFieldTableCell.forTableColumn());
		columnTipo.setCellValueFactory(new PropertyValueFactory<Telefono, String>("tipo"));
		columnTipo.setCellFactory(ChoiceBoxTableCell.forTableColumn("Fijo", "Movil"));
		columnUrl.setCellValueFactory(new PropertyValueFactory<Url, String>("direccion") );
		columnUrl.setCellFactory(TextFieldTableCell.forTableColumn());
		columnEmail.setCellValueFactory(new PropertyValueFactory<Email, String>("direccion"));
		columnEmail.setCellFactory(TextFieldTableCell.forTableColumn());

		
	}

	public AnchorPane getView() {
		return view;
	}

	public final ObjectProperty<Contacto> contactoProperty() {
		return this.contacto;
	}

	public final Contacto getContacto() {
		return this.contactoProperty().get();
	}

	public final void setContacto(final Contacto contacto) {
		this.contactoProperty().set(contacto);
	}

}

package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import model.Titulo;

public class FormacionController implements Initializable {

	private ListProperty<Titulo> formacion = new SimpleListProperty<>(FXCollections.observableArrayList());

	@FXML
	private GridPane view;

	@FXML
	private TableView<Titulo> tableFormacion;

	@FXML
	private TableColumn<Titulo, LocalDate> columnDesde;

	@FXML
	private TableColumn<Titulo, LocalDate> columnHasta;

	@FXML
	private TableColumn<Titulo, String> columnDenominacion;

	@FXML
	private TableColumn<Titulo, String> columnOrganizador;

	@FXML
	private Button btnAgregar;

	@FXML
	private Button btnEliminar;

	public FormacionController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FormacionView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		formacion.addListener((o, ov, nv) -> onFormacionChanged(o, ov, nv));

		columnDesde.setCellValueFactory(v -> v.getValue().fechaDesdeProperty());
		columnHasta.setCellValueFactory(v -> v.getValue().fechaHastaProperty());
		columnDenominacion.setCellValueFactory(v -> v.getValue().denominacionProperty());
		columnOrganizador.setCellValueFactory(v -> v.getValue().organizadorProperty());

		columnDenominacion.setCellFactory(TextFieldTableCell.forTableColumn());
		columnOrganizador.setCellFactory(TextFieldTableCell.forTableColumn());

	}

	private void onFormacionChanged(ObservableValue<? extends ObservableList<Titulo>> o, ObservableList<Titulo> ov,
			ObservableList<Titulo> nv) {

		System.out.println("ov=" + ov + "/nv=" + nv);

		if (ov != null) {

			tableFormacion.setItems(null);

		}

		if (nv != null) {

			tableFormacion.setItems(nv);

		}

	}

	@FXML
	void agregarFormacion(ActionEvent event) {
		Dialog<Titulo> dialog = new Dialog<>();
		dialog.setTitle("Nueva titulo");
		dialog.setHeaderText("Agregar una nueva titulo");

		ButtonType loginButtonType = new ButtonType("Agregar", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		DatePicker desde = new DatePicker();
		DatePicker hasta = new DatePicker();
		TextField denominacion = new TextField();
		TextField organizador = new TextField();

		grid.add(new Label("Denominación: "), 0, 0);
		grid.add(denominacion, 1, 0);
		grid.add(new Label("Organizador"), 0, 1);
		grid.add(organizador, 1, 1);
		grid.add(new Label("Desde:"), 0, 2);
		grid.add(desde, 1, 2);
		grid.add(new Label("Hasta:"), 0, 3);
		grid.add(hasta, 1, 3);

		dialog.getDialogPane().setContent(grid);

		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				return new Titulo(denominacion.getText().toString(), organizador.getText().toString(), desde.getValue(),
						hasta.getValue());
			}
			return null;
		});

		Optional<Titulo> result = dialog.showAndWait();

		if (result.isPresent()) {
			tableFormacion.getItems().add(result.get());
		}
	}

	@FXML
	void eliminarTitulo(ActionEvent event) {
		Titulo titulo = tableFormacion.getSelectionModel().getSelectedItem();

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setHeaderText(null);
		alert.setTitle("Eliminar Titulo");
		alert.setContentText("¿Estas seguro de que quieres borrar este titulo? \n " + titulo);
		Optional<ButtonType> action = alert.showAndWait();

		if (action.get() == ButtonType.OK) {
			tableFormacion.getItems().remove(titulo);
		}

	}

	public GridPane getView() {
		return view;
	}

	public final ListProperty<Titulo> formacionProperty() {
		return this.formacion;
	}

	public final ObservableList<Titulo> getFormacion() {
		return this.formacionProperty().get();
	}

	public final void setFormacion(final ObservableList<Titulo> formacion) {
		this.formacionProperty().set(formacion);
	}

}

package controller;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import model.Conocimiento;
import model.Experiencia;
import model.Idioma;

public class ConocimientoController implements Initializable {

	private ListProperty<Conocimiento> conocimiento = new SimpleListProperty<>(FXCollections.observableArrayList());

	@FXML
	private GridPane view;

	@FXML
	private TableView<Conocimiento> tableConocimiento;

	@FXML
	private TableColumn<Conocimiento, String> columnDenominacion;

	@FXML
	private TableColumn<Conocimiento, String> columnNivel;

	@FXML
	private Button btnConocimiento;

	@FXML
	private Button btnIdioma;

	@FXML
	private Button btnEliminar;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		conocimiento.addListener((o, ov, nv) -> onConocimientoChanged(o, ov, nv));

		columnDenominacion.setCellValueFactory(v -> v.getValue().denominacionProperty());
		columnNivel.setCellValueFactory(v -> v.getValue().nivelProperty());

		columnDenominacion.setCellFactory(TextFieldTableCell.forTableColumn());
		columnNivel.setCellFactory(TextFieldTableCell.forTableColumn());

	}

	public ConocimientoController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ConocimientosView.fxml"));
		loader.setController(this);
		loader.load();
	}

	private void onConocimientoChanged(ObservableValue<? extends ObservableList<Conocimiento>> o,
			ObservableList<Conocimiento> ov, ObservableList<Conocimiento> nv) {
		// TODO Auto-generated method stub
		System.out.println("ov=" + ov + "/nv=" + nv);

		if (ov != null) {

			tableConocimiento.setItems(null);
			// TODO desbindear el resto de propiedades

		}

		if (nv != null) {
			tableConocimiento.setItems(nv);
			// TODO bindear el resto de propiedades

		}
	}

	@FXML
	void agregarConocimiento(ActionEvent event) {
		Dialog<Conocimiento> dialog = new Dialog<>();
		dialog.setTitle("Nueva conocimiento");
		dialog.setHeaderText("Agregar un nuevo conocimiento");

		ButtonType loginButtonType = new ButtonType("Agregar", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		ComboBox nivel = new ComboBox();
		nivel.getItems().addAll("Básico", "Medio", "Avanzado");
		TextField denominacion = new TextField();
		Button btnReset = new Button("X");
		btnReset.setOnAction(d -> {
			nivel.getSelectionModel().clearSelection();
		});

		grid.add(new Label("Denominación: "), 0, 0);
		grid.add(denominacion, 1, 0);
		grid.add(new Label("Nivel:"), 0, 1);
		grid.add(nivel, 1, 1);
		grid.add(btnReset, 2, 1);

		dialog.getDialogPane().setContent(grid);

		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				return new Conocimiento(denominacion.getText(), nivel.getSelectionModel().getSelectedItem().toString());
			}
			return null;
		});

		Optional<Conocimiento> result = dialog.showAndWait();

		if (result.isPresent()) {
			tableConocimiento.getItems().add(result.get());
		}
	}

	@FXML
	void eliminarConocimiento(ActionEvent event) {
		Conocimiento con = tableConocimiento.getSelectionModel().getSelectedItem();

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setHeaderText(null);
		alert.setTitle("Eliminar Conocimiento");
		alert.setContentText("¿Estas seguro de que quieres borrar este conocimiento? \n " + con);
		Optional<ButtonType> action = alert.showAndWait();

		if (action.get() == ButtonType.OK) {
			tableConocimiento.getItems().remove(con);
		}

	}

	@FXML
	void agregarIdioma(ActionEvent event) {
		Dialog<Idioma> dialog = new Dialog<>();
		dialog.setTitle("Nueva conocimiento");
		dialog.setHeaderText("Agregar un nuevo conocimiento");

		ButtonType loginButtonType = new ButtonType("Agregar", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 150, 10, 10));

		ComboBox nivel = new ComboBox();
		nivel.getItems().addAll("Básico", "Medio", "Avanzado");
		TextField denominacion = new TextField();
		TextField certificacion = new TextField();
		Button btnReset = new Button("X");
		btnReset.setOnAction(d -> {
			nivel.getSelectionModel().clearSelection();
		});

		grid.add(new Label("Denominación: "), 0, 0);
		grid.add(denominacion, 1, 0);
		grid.add(new Label("Nivel:"), 0, 1);
		grid.add(nivel, 1, 1);
		grid.add(btnReset, 2, 1);
		grid.add(new Label("Certificación: "), 0, 2);
		grid.add(certificacion, 1, 2);

		dialog.getDialogPane().setContent(grid);

		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == loginButtonType) {
				return new Idioma(denominacion.getText(), nivel.getSelectionModel().getSelectedItem().toString(),
						certificacion.getText());
			}
			return null;
		});

		Optional<Idioma> result = dialog.showAndWait();

		if (result.isPresent()) {
			tableConocimiento.getItems().add(result.get());
		}
	}

	public GridPane getView() {
		return view;
	}

	public final ListProperty<Conocimiento> conocimientoProperty() {
		return this.conocimiento;
	}

	public final ObservableList<Conocimiento> getConocimiento() {
		return this.conocimientoProperty().get();
	}

	public final void setExperiencia(final ObservableList<Conocimiento> conocimiento) {
		this.conocimientoProperty().set(conocimiento);
	}
}

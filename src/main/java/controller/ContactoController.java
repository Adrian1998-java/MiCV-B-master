package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class ContactoController implements Initializable {
	
	 @FXML
	    private AnchorPane view;

	    @FXML
	    private TableView<?> tableTelefono;

	    @FXML
	    private TableColumn<?, ?> columnNumero;

	    @FXML
	    private TableColumn<?, ?> columnTipo;

	    @FXML
	    private Button btnAgregarTelefono;

	    @FXML
	    private Button btnEliminarTelefono;

	    @FXML
	    private TableView<?> tableEmail;

	    @FXML
	    private TableColumn<?, ?> collnEmail;

	    @FXML
	    private Button btnAgregarEmail;

	    @FXML
	    private Button btnEliminarEmail;

	    @FXML
	    private TableView<?> tableUrl;

	    @FXML
	    private TableColumn<?, ?> columnUrl;

	    @FXML
	    private Button btnAgregarUrl;

	    @FXML
	    private Button btnEliminarUrl;

    
    public ContactoController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ContactoView.fxml"));
		loader.setController(this);
		loader.load();
	}
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	public AnchorPane getView() {
		return view;
	}
    
    
}

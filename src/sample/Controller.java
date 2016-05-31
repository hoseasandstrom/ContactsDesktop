package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    TextField name;
    @FXML
    TextField number;
    @FXML
    TextField email;
    @FXML
    ListView list;

    ObservableList<Contact> contacts = FXCollections.observableArrayList();

    public void onAdd() throws IOException {
        Contact contact = new Contact(name.getText(), number.getText(), email.getText());
        if (!name.getText().isEmpty() && !number.getText().isEmpty() && !email.getText().isEmpty()){
            contacts.add(contact);
        }
    }
    public void onRemove(){
        SelectionModel model = list.getSelectionModel();
        Contact info = (Contact) model.getSelectedItem();
        contacts.remove(info);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(contacts);
    }

}

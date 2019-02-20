package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Button btnAddAnimal;
    public ComboBox cmbSpecies;
    public TextField txtBadHabits;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void btnAddAnimal_Click(ActionEvent actionEvent) {
        System.out.println("Clicked");
    }

    public void cmbSpecies_Changed(ActionEvent actionEvent) {

        String selectedSpecies = (String)cmbSpecies.getValue();
        if(selectedSpecies.compareTo(Species.Cat.toString()) == 0){
            txtBadHabits.setDisable(false);
        }else {
            txtBadHabits.setDisable(true);
        }
    }
}

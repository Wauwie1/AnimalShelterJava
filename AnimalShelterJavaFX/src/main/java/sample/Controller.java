package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.Animal.Animal;
import sample.Animal.AnimalFactory;
import sample.Animal.Cat;
import sample.Animal.Gender;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    // Controls
    public Button btnAddAnimal;
    public ComboBox cmbSpecies;
    public TextField txtBadHabits;
    public TextField txtName;
    public ListView lstAnimals;
    public ToggleGroup tglgGender;
    public RadioButton tglMale;
    public RadioButton tglFemale;
    public Button btnReserve;
    public TextField txtResName;
    //

    private String selectedSpecies;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            initToggle();
    }

    private void initToggle(){
        tglgGender = new ToggleGroup();
        tglMale.setToggleGroup(tglgGender);
        tglMale.setUserData(Gender.Male);
        tglMale.setSelected(true);
        tglFemale.setToggleGroup(tglgGender);
        tglFemale.setUserData(Gender.Female);
    }

    public void btnAddAnimal_Click(ActionEvent actionEvent) {
        AnimalFactory animalFactory = new AnimalFactory();
        Gender selectedGender = (Gender)tglgGender.getSelectedToggle().getUserData();
        Animal animal = animalFactory.MakeAnimal(selectedSpecies, txtName.getText(), selectedGender, txtBadHabits.getText());

        lstAnimals.getItems().add(animal);
    }

    public void cmbSpecies_Changed(ActionEvent actionEvent) {

        selectedSpecies = (String)cmbSpecies.getValue();
        if(selectedSpecies.compareTo(Species.Cat.toString()) == 0){
            txtBadHabits.setDisable(false);
        }else {
            txtBadHabits.setDisable(true);
        }
    }

    public void btnReserve_Click(ActionEvent actionEvent) {
        Animal selectedAnimal = (Animal)lstAnimals.getSelectionModel().getSelectedItem();

        if(selectedAnimal != null) {
            selectedAnimal.reserve(txtResName.getText());
            lstAnimals.refresh();
        }else{
            System.out.println("No animal selected.");
        }
    }
}

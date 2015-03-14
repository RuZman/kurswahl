package de.ruzman.kurswahl.controller;

import static io.datafx.controller.context.ApplicationContext.getInstance;
import static javafx.collections.FXCollections.observableArrayList;
import io.datafx.controller.FXMLController;
import io.datafx.controller.context.ApplicationContext;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import javax.annotation.PostConstruct;

import de.ruzman.kurswahl.DBJahrgang;

@FXMLController("../fxml/Login.fxml")
public class LoginController {
	private ApplicationContext context = getInstance();
	private DBJahrgang dbJahrgang;

	@FXML private ComboBox<String> dropDownCourse;
	@FXML private ComboBox<String> dropDownName;
	@FXML private ComboBox<String> dropDownBirthDay;
	@FXML private ComboBox<String> dropDownBirthMonth;
	@FXML private ComboBox<String> dropDownBirthYear;

	@PostConstruct
	public void initialize() {
		dbJahrgang = context.getRegisteredObject(DBJahrgang.class);
		dropDownCourse.setItems(observableArrayList(dbJahrgang.gibKurse()));
		dropDownBirthDay.setItems(observableArrayList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11",
				"12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
				"29", "30", "31"));
		dropDownBirthMonth.setItems(observableArrayList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
				"11", "12"));
		dropDownBirthYear.setItems(observableArrayList(dbJahrgang.gibJahre()));

		dropDownCourse.getItems().add(0, "- Auswählen -");
		dropDownName.getItems().add(0, "- Auswählen -");

		dropDownName.setDisable(true);

		dropDownCourse.setValue(dropDownCourse.getItems().get(0));
		dropDownName.setValue(dropDownName.getItems().get(0));
		dropDownBirthMonth.setValue(dropDownBirthMonth.getItems().get(0));
		dropDownBirthDay.setValue(dropDownBirthDay.getItems().get(0));
		dropDownBirthYear.setValue(dropDownBirthYear.getItems().get(0));
	}
}

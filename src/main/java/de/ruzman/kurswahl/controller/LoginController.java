package de.ruzman.kurswahl.controller;

import static javafx.collections.FXCollections.observableArrayList;
import static javafx.scene.paint.Color.BLACK;
import static javafx.scene.paint.Color.RED;
import io.datafx.controller.FXMLController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import de.ruzman.kurswahl.DBJahrgang;

@FXMLController("../fxml/Login.fxml")
public class LoginController {
	@Inject private DBJahrgang dbJahrgang;

	@FXML private Label courseLabel;
	@FXML private Label nameLabel;
	@FXML private Label birthDateLabel;
	@FXML private Label birthPlace1Label;
	@FXML private Label birthPlace2Label;

	@FXML private ComboBox<String> courseComboBox;
	@FXML private ComboBox<String> nameComboBox;
	@FXML private ComboBox<String> birthDayComboBox;
	@FXML private ComboBox<String> birthMonthComboBox;
	@FXML private ComboBox<String> birthYearComboBox;

	@FXML private TextField birthPlaceTextfield;

	@FXML private Button loginButton;

	@PostConstruct
	public void init() {
		courseComboBox.getItems().addAll(observableArrayList(dbJahrgang.gibKurse()));
		courseComboBox.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (isSelected(courseComboBox)) {
					resetTextFill();
					dbJahrgang.gibSchueler().setzeKurs(newValue);
					nameComboBox.getItems().remove(1, nameComboBox.getItems().size());
					nameComboBox.getItems().addAll(dbJahrgang.gibNamen());
				}
				nameComboBox.setDisable(!isSelected(courseComboBox));
				selectFirstItem(nameComboBox);
			}
		});

		birthYearComboBox.setItems(observableArrayList(dbJahrgang.gibJahre()));
		selectFirstItem(birthYearComboBox);

		loginButton.setOnAction((e) -> onLogin());

		// TODO: Disable RED Color
		// TODO: Use ActionTrigger
	}

	private void onLogin() {
		// FIXME: Replace with CSS-Style
		if (!isSelected(courseComboBox)) {
			courseLabel.setTextFill(RED);
		} else if (!isSelected(nameComboBox)) {
			nameLabel.setTextFill(RED);
		} else {
			dbJahrgang.gibSchueler().setzeName(nameComboBox.getSelectionModel().getSelectedItem());
			String birthDate = birthDayComboBox.getSelectionModel().getSelectedItem() + "."
					+ birthMonthComboBox.getSelectionModel().getSelectedItem() + "."
					+ birthYearComboBox.getSelectionModel().getSelectedItem();

			if (dbJahrgang.gibSchueler().istGeburtsort(birthPlaceTextfield.getText())
					&& dbJahrgang.gibSchueler().istGeburtsdatum(birthDate)) {
				// TODO: Link to Kurswahl
			} else {
				birthDateLabel.setTextFill(RED);
				birthPlace1Label.setTextFill(RED);
				birthPlace2Label.setTextFill(RED);
			}
		}
	}

	private void resetTextFill() {
		// TODO: Replace with CSS-Style
		courseLabel.setTextFill(BLACK);
		nameLabel.setTextFill(BLACK);
		birthDateLabel.setTextFill(BLACK);
		birthPlace1Label.setTextFill(BLACK);
		birthPlace2Label.setTextFill(BLACK);
	}

	private boolean isSelected(ComboBox<String> comboBox) {
		return comboBox.getSelectionModel().getSelectedIndex() != 0;
	}

	private void selectFirstItem(ComboBox<String> comboBox) {
		comboBox.setValue(comboBox.getItems().get(0));
	}
}

package de.ruzman.kurswahl.controller;

import static io.datafx.controller.context.ApplicationContext.getInstance;
import io.datafx.controller.FXMLController;
import io.datafx.controller.context.ApplicationContext;

import javax.annotation.PostConstruct;

import de.ruzman.kurswahl.DBJahrgang;

@FXMLController("../fxml/Login.fxml")
public class LoginController {
	ApplicationContext context = getInstance();

	private DBJahrgang dbJahrgang;

	@PostConstruct
	public void initialize() {
		dbJahrgang = context.getRegisteredObject(DBJahrgang.class);
	}
}

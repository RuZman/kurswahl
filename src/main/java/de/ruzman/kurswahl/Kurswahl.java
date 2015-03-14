package de.ruzman.kurswahl;

import static java.util.Locale.GERMAN;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.context.ViewFlowContext;

import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.stage.Stage;
import de.ruzman.kurswahl.controller.LoginController;

public class Kurswahl extends Application {
	public static void main(String[] args) {
		launch(Kurswahl.class);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		String baseName = getClass().getPackage().getName() + ".labels.labels";
		FlowI18n flow = new FlowI18n(LoginController.class, baseName, GERMAN);
		flow.startInStage(primaryStage);
	}

	private class FlowI18n extends Flow {
		private String baseName;

		public FlowI18n(Class<?> startViewControllerClass, String baseName, Locale locale) {
			super(startViewControllerClass);
			this.baseName = baseName;
			getViewConfiguration().setResources(getResourceBundle(locale));
		}

		@Override
		public FlowHandler createHandler(ViewFlowContext flowContext) {
			return new FlowHandler(this, flowContext, getViewConfiguration());
		}

		private ResourceBundle getResourceBundle(Locale locale) {
			return ResourceBundle.getBundle(baseName, locale);
		}
	}
}

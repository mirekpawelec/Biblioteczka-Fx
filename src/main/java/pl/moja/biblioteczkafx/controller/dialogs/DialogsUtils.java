package pl.moja.biblioteczkafx.controller.dialogs;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;
import java.util.ResourceBundle;

public class DialogsUtils {
    static ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages");

    public static void dialogAboutApplication() {
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle(bundle.getString("about.title"));
        informationAlert.setHeaderText(bundle.getString("about.header"));
        informationAlert.setContentText(bundle.getString("about.content"));
        informationAlert.showAndWait();
    }

    public static Optional<ButtonType> confirmationDialog() {
        Alert informationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        informationAlert.setTitle(bundle.getString("exit.title"));
        informationAlert.setHeaderText(bundle.getString("exit.header"));
        return informationAlert.showAndWait();
    }
}

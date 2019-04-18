package pl.moja.biblioteczkafx.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;

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

    public static void errorDialog(String error) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(bundle.getString("error.title"));
        alert.setHeaderText(bundle.getString("error.header"));

        TextArea textArea = new TextArea(error);
        alert.getDialogPane().setContent(textArea);
        alert.showAndWait();
    }

    public static String editDialog(String value) {
        TextInputDialog textInputDialog = new TextInputDialog(value);
        textInputDialog.setTitle(bundle.getString("edit.title"));
        textInputDialog.setHeaderText(bundle.getString("edit.header"));
        textInputDialog.setContentText(bundle.getString("edit.content"));
        Optional<String> result = textInputDialog.showAndWait();
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}

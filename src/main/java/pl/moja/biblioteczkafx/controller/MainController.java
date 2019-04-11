package pl.moja.biblioteczkafx.controller;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.moja.biblioteczkafx.utils.DialogsUtils;
import pl.moja.biblioteczkafx.utils.FxmlUtils;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private BorderPane borderPane;

    @FXML
    private TopMenuButtonController topMenuButtonsController;

    public void initialize(URL location, ResourceBundle resources) {
        topMenuButtonsController.setMainController(this);
    }

    public void setCenter(String fxmlPath) {
        borderPane.setCenter(FxmlUtils.fxmlLoader(fxmlPath));
    }

    @FXML
    public void closeApplication(ActionEvent actionEvent) {
        if (DialogsUtils.confirmationDialog().get() == ButtonType.OK) {
            Platform.exit();
            System.exit(0);
        }
    }

    @FXML
    public void setCaspian(ActionEvent actionEvent) {
        Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN);
    }

    @FXML
    public void setModena(ActionEvent actionEvent) {
        Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
    }

    @FXML
    public void setAlwaysOnTop(ActionEvent actionEvent) {
        Stage stage = (Stage) borderPane.getScene().getWindow();
        boolean value = ((CheckMenuItem) actionEvent.getSource()).selectedProperty().get();
        stage.setAlwaysOnTop(value);
    }

    @FXML
    public void about(ActionEvent actionEvent) {
        DialogsUtils.dialogAboutApplication();
    }
}

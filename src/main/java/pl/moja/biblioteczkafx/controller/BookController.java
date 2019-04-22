package pl.moja.biblioteczkafx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import pl.moja.biblioteczkafx.modelfx.AuthorFx;
import pl.moja.biblioteczkafx.modelfx.CategoryFx;

import java.net.URL;
import java.util.ResourceBundle;

public class BookController implements Initializable {

    @FXML
    private ComboBox<CategoryFx> categoryComboBox;
    @FXML
    private ComboBox<AuthorFx> authorComboBox;
    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private Slider ratingSlider;
    @FXML
    private TextField titleTextField;
    @FXML
    private TextField isbnTextField;
    @FXML
    private DatePicker dateOfReleaseDatePicker;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}

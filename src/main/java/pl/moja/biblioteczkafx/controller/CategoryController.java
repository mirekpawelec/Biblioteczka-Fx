package pl.moja.biblioteczkafx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import pl.moja.biblioteczkafx.modelfx.CategoryFx;
import pl.moja.biblioteczkafx.modelfx.CategoryModel;

import java.net.URL;
import java.util.ResourceBundle;

public class CategoryController implements Initializable {

    @FXML
    private TextField categoryTextField;
    @FXML
    private Button addCategoryButton;
    @FXML
    private ComboBox<CategoryFx> categoryComboBox;
    @FXML
    private Button deleteCategoryButton;

    CategoryModel categoryModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.categoryModel = new CategoryModel();
        this.categoryModel.init();
        this.categoryComboBox.setItems(categoryModel.getCategoryObservableList());
        initBindings();
    }

    private void initBindings() {
        addCategoryButton.disableProperty().bind(categoryTextField.textProperty().isEmpty());
        deleteCategoryButton.disableProperty().bind(this.categoryModel.categoryProperty().isNull());
    }

    public void addCategory() {
        categoryModel.saveCategoryInDataBase(categoryTextField.getText());
        this.categoryTextField.clear();
    }

    public void deleteCategory() {
        this.categoryModel.deleteCategoryById();
    }

    public void onActionComboBox() {
        this.categoryModel.setCategory(this.categoryComboBox.getSelectionModel().getSelectedItem());
    }
}

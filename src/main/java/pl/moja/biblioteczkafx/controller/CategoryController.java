package pl.moja.biblioteczkafx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import pl.moja.biblioteczkafx.modelfx.CategoryFx;
import pl.moja.biblioteczkafx.modelfx.CategoryModel;
import pl.moja.biblioteczkafx.utils.DialogsUtils;
import pl.moja.biblioteczkafx.utils.exceptions.ApplicationException;

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
    @FXML
    private Button editCategoryButton;

    CategoryModel categoryModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.categoryModel = new CategoryModel();
        try {
            this.categoryModel.init();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        this.categoryComboBox.setItems(categoryModel.getCategoryObservableList());
        initBindings();
    }

    private void initBindings() {
        addCategoryButton.disableProperty().bind(categoryTextField.textProperty().isEmpty());
        deleteCategoryButton.disableProperty().bind(this.categoryModel.getCategoryProperty().isNull());
        editCategoryButton.disableProperty().bind(this.categoryModel.getCategoryProperty().isNull());
    }

    public void addCategory() {
        try {
            categoryModel.saveCategoryInDataBase(categoryTextField.getText());
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
        this.categoryTextField.clear();
    }

    public void deleteCategory() {
        try {
            this.categoryModel.deleteCategoryById();
        } catch (ApplicationException e) {
            DialogsUtils.errorDialog(e.getMessage());
        }
    }

    public void onActionComboBox() {
        this.categoryModel.setCategory(this.categoryComboBox.getSelectionModel().getSelectedItem());
    }

    public void editCategory() {
        String newCategoryName = DialogsUtils.editDialog(this.categoryModel.getCategoryProperty().getName());
        if (newCategoryName != null) {
            this.categoryModel.getCategory().setName(newCategoryName);
            try {
                this.categoryModel.updateCategoryInDataBase();
            } catch (ApplicationException e) {
                DialogsUtils.errorDialog(e.getMessage());
            }
        }
    }
}

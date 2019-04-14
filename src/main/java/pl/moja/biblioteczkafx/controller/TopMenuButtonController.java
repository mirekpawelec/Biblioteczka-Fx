package pl.moja.biblioteczkafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class TopMenuButtonController {

    public static final String LIBRARY_FXML = "/fxml/Library.fxml";
    public static final String LIST_BOOKS_FXML = "/fxml/ListBooks.fxml";
    public static final String STATISTICS_FXML = "/fxml/Statistics.fxml";
    public static final String ADD_BOOK_FXML = "/fxml/AddBook.fxml";
    public static final String ADD_CATEGORY_FXML = "/fxml/AddCategory.fxml";

    private MainController mainController;

    @FXML
    private ToggleGroup toggleButtons;

    @FXML
    public void openLibrary(ActionEvent actionEvent) {
        System.out.println("openLibrary");
        mainController.setCenter(LIBRARY_FXML);
    }

    @FXML
    public void openListBooks(ActionEvent actionEvent) {
        System.out.println("openListBooks");
        mainController.setCenter(LIST_BOOKS_FXML);
    }

    @FXML
    public void OpenStatistics(ActionEvent actionEvent) {
        System.out.println("OpenStatistics");
        mainController.setCenter(STATISTICS_FXML);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    public void addBook(ActionEvent actionEvent) {
        System.out.println("addBook");
        resetToogleButtons();
        mainController.setCenter(ADD_BOOK_FXML);
    }

    @FXML
    public void addCategory(ActionEvent actionEvent) {
        resetToogleButtons();
        mainController.setCenter(ADD_CATEGORY_FXML);
    }

    private void resetToogleButtons() {
        if (toggleButtons.getSelectedToggle() != null) {
            toggleButtons.getSelectedToggle().setSelected(false);
        }
    }
}

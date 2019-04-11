package pl.moja.biblioteczkafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pl.moja.biblioteczkafx.database.dbutils.DbManager;
import pl.moja.biblioteczkafx.utils.FxmlUtils;

public class Main extends Application {

    public static final String BORDER_PANE_MAIN_FXML = "/fxml/BorderPaneMain.fxml";

    public static void main(String[] args) {
        Application.launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
//        Locale.setDefault(new Locale("en"));
        Pane borderPane = FxmlUtils.fxmlLoader(BORDER_PANE_MAIN_FXML);
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle(FxmlUtils.getResourceBundle().getString("tittle.application"));
        primaryStage.show();

        DbManager.initDatabase();
    }
}

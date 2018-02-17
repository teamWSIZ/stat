package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ui/ui.fxml"));
        stage.setTitle("Hello World");
        stage.setScene(new Scene(root, 700, 800));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

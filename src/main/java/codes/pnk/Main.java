package codes.pnk;

import codes.pnk.controller.ViewController;
import codes.pnk.view.FxmlController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view.fxml"));
        FxmlController controller = new FxmlController(stage);
        fxmlLoader.setController(controller);

        Scene scene = new Scene(new ViewController(stage).getView(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
package codes.pnk;

import codes.pnk.controller.ViewController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(final Stage stage) {
        Scene scene = new Scene(new ViewController(stage).getView(), 400, 300);
        stage.setTitle("trithemius vault");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
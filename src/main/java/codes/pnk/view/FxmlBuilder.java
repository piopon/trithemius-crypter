package codes.pnk.view;

import codes.pnk.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.util.Builder;

import java.io.IOException;

public class FxmlBuilder  implements Builder<Region> {
    private final Stage stage;

    public FxmlBuilder(Stage stage) {
        this.stage = stage;
    }

    @Override
    public Region build() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view.fxml"));
            FxmlController controller = new FxmlController(stage);
            fxmlLoader.setController(controller);
            return fxmlLoader.load();
        } catch (IOException e) {
            return new BorderPane();
        }
    }
}

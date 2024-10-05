package codes.pnk.controller;

import codes.pnk.view.FxmlBuilder;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ViewController {
    private final FxmlBuilder viewBuilder;

    public ViewController(Stage stage) {
        this.viewBuilder = new FxmlBuilder(stage);
    }

    public Region getView() {
        return viewBuilder.build();
    }
}

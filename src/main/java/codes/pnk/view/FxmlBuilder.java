package codes.pnk.view;

import codes.pnk.Main;
import codes.pnk.model.presentation.ViewModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.util.Builder;

import java.io.IOException;

public class FxmlBuilder  implements Builder<Region> {
    private final ViewModel viewModel;
    private final Stage stage;

    public FxmlBuilder(final ViewModel viewModel, final Stage stage) {
        this.viewModel = viewModel;
        this.stage = stage;
    }

    @Override
    public Region build() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view.fxml"));
            FxmlController controller = new FxmlController(viewModel, stage);
            fxmlLoader.setController(controller);
            return fxmlLoader.load();
        } catch (IOException e) {
            return new BorderPane();
        }
    }
}

package codes.pnk.view;

import codes.pnk.Main;
import codes.pnk.model.presentation.ViewConfig;
import codes.pnk.model.presentation.ViewModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class FxmlController implements Initializable {
    private final Map<String, TabController> tabControllers;

    @FXML
    private TabPane tabPane;
    @FXML
    private BorderPane mainPane;

    public FxmlController(final ViewModel viewModel, final ViewConfig viewConfig) {
        this.tabControllers = Map.of("embed", new TabEmbedController(viewModel, viewConfig),
                                     "extract", new TabExtractController(viewModel, viewConfig));
    }

    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
        refreshContent(tabPane.getSelectionModel().getSelectedItem().getText());
        tabPane.getSelectionModel().selectedItemProperty()
               .addListener((observableValue, tab, t1) -> refreshContent(t1.getText()));
    }

    private void refreshContent(final String tabName) {
        mainPane.setCenter(getContent(tabName));
    }

    private Pane getContent(final String tabName) {
        try {
            URL tabViewFile = Main.class.getResource("tab-" + tabName.toLowerCase() + ".fxml");
            if (tabViewFile != null) {
                return getErrorPane("Cannot find view file for tab: " + tabName.toLowerCase());
            }
            TabController controller = tabControllers.get(tabName.toLowerCase());
            if (controller == null) {
                return getErrorPane("Cannot find controller for tab: " + tabName.toLowerCase());
            }
            FXMLLoader fxmlLoader = new FXMLLoader(tabViewFile);
            fxmlLoader.setController(controller);
            return fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return getErrorPane(e.getMessage());
        }
    }

    private Pane getErrorPane(final String message) {
        BorderPane errorPane = new BorderPane();
        VBox appContent = new VBox(new Text(message));
        appContent.setPadding(new Insets(100));
        appContent.setAlignment(Pos.CENTER);
        errorPane.setCenter(appContent);
        return errorPane;
    }
}
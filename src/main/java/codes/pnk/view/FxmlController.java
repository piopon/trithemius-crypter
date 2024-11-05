package codes.pnk.view;

import codes.pnk.Main;
import codes.pnk.model.presentation.ViewConfig;
import codes.pnk.model.presentation.ViewModel;
import javafx.beans.property.ObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Map;
import java.util.ResourceBundle;

public class FxmlController implements Initializable {
    private final static String EMPTY_TEXT_FIELD = "-- none selected --";

    private final FileChooser fileChooser = new FileChooser();
    private final DirectoryChooser pathChooser = new DirectoryChooser();
    private final Map<String, TabController> controllers;
    private final ViewConfig viewConfig;
    private final ViewModel viewModel;

    @FXML
    private TextField fieldImageExtract;
    @FXML
    private TextField fieldOutExtract;
    @FXML
    private Button buttonImageExtract;
    @FXML
    private Button buttonOutExtract;
    @FXML
    private Button buttonActionExtract;
    @FXML
    private TabPane tabPane;
    @FXML
    private BorderPane mainPane;

    public FxmlController(final ViewModel viewModel, final ViewConfig viewConfig) {
        this.viewConfig = viewConfig;
        this.viewModel = viewModel;
        this.controllers = Map.of("embed", new TabEmbedController(viewModel, viewConfig));
    }

    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
        refreshContent(tabPane.getSelectionModel().getSelectedItem().getText());
        tabPane.getSelectionModel().selectedItemProperty()
               .addListener((observableValue, tab, t1) -> refreshContent(t1.getText()));
    }

    private void initializeFileField(TextField field, Button button, ObjectProperty<File> property) {
        updateTextField(field, property);
        button.setOnAction(actionEvent -> {
            File file = fileChooser.showOpenDialog(viewConfig.stage());
            if (file != null) {
                property.setValue(file);
                updateTextField(field, property);
            }
        });
    }

    private void initializePathField(TextField field, Button button, ObjectProperty<Path> property) {
        updateTextField(field, property);
        button.setOnAction(actionEvent -> {
            File file = pathChooser.showDialog(viewConfig.stage());
            if (file != null) {
                property.setValue(file.toPath());
                updateTextField(field, property);
            }
        });
    }

    private <T> void updateTextField(final TextField field, final ObjectProperty<T> modelValue) {
        field.setText(modelValue.isNotNull().get() ? modelValue.getValue().toString() : EMPTY_TEXT_FIELD);
    }

    private void refreshContent(final String tabName) {
        mainPane.setCenter(getContent(tabName));
    }

    private Pane getContent(final String tabName) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("tab-" + tabName.toLowerCase() + ".fxml"));
            TabController controller = controllers.get(tabName.toLowerCase());
            if (controller != null) {
                fxmlLoader.setController(controller);
                return fxmlLoader.load();
            }
            return new BorderPane();
        } catch (IOException e) {
            e.printStackTrace();
            return new BorderPane();
        }
    }
}
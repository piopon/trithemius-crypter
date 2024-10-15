package codes.pnk.view;

import codes.pnk.model.presentation.ViewConfig;
import codes.pnk.model.presentation.ViewModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.util.Optional;
import java.util.ResourceBundle;

public class FxmlController implements Initializable {
    private final FileChooser fileChooser = new FileChooser();
    private final ViewConfig viewConfig;
    private final ViewModel viewModel;

    @FXML
    private TextField fieldTextFile;
    @FXML
    private TextField fieldImageFile;
    @FXML
    private TextField fieldOutPath;
    @FXML
    private Button buttonTextFile;
    @FXML
    private Button buttonImageFile;
    @FXML
    private Button buttonOutPath;
    @FXML
    private Button buttonActionEmbed;

    public FxmlController(final ViewModel viewModel, final ViewConfig viewConfig) {
        this.viewConfig = viewConfig;
        this.viewModel = viewModel;
    }

    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
        initializeFileField(fieldTextFile, buttonTextFile, viewModel.getTextFile());
        initializeFileField(fieldImageFile, buttonImageFile, viewModel.getImageFile());
        initializeFileField(fieldOutPath, buttonOutPath, viewModel.getOutputPath());
        buttonActionEmbed.setOnAction(actionEvent -> viewConfig.action().accept(0));
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
            Path path = fileChooser.showOpenDialog(viewConfig.stage()).toPath();
            if (path != null) {
                property.setValue(path);
                updateTextField(field, property);
            }
        });
    }

    private void updateTextField(final TextField field, final ObjectProperty<File> modelValue) {
        if (modelValue.isNotNull().get()) {
            field.setText(modelValue.getValue().toString());
        } else {
            field.setText("No file selected");
        }
    }
}
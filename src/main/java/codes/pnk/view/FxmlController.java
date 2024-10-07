package codes.pnk.view;

import codes.pnk.model.presentation.ViewConfig;
import codes.pnk.model.presentation.ViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class FxmlController implements Initializable {
    private final FileChooser fileChooser = new FileChooser();
    private final ViewConfig viewConfig;
    private final ViewModel viewModel;

    @FXML
    private TextField welcomeText;
    @FXML
    private Button button;

    public FxmlController(final ViewModel viewModel, final ViewConfig viewConfig) {
        this.viewConfig = viewConfig;
        this.viewModel = viewModel;
    }

    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
        updateTextField(welcomeText, viewModel.getTextFile());
        button.setOnAction(actionEvent -> {
            File file = fileChooser.showOpenDialog(viewConfig.stage());
            if (file != null) {
                viewModel.setTextFile(file);
                updateTextField(welcomeText, viewModel.getTextFile());
                viewConfig.action().accept(0);
            }
        });
    }

    private <T> void updateTextField(final TextField field, final Optional<T> modelValue) {
        modelValue.ifPresentOrElse(value -> field.setText(value.toString()), () -> field.setText("No file selected"));
    }
}
package codes.pnk.view;

import codes.pnk.model.presentation.ViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class FxmlController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private Button button;
    private FileChooser fileChooser = new FileChooser();
    private final ViewModel viewModel;
    private Stage stage;

    public FxmlController(ViewModel viewModel, Stage stage) {
        this.viewModel = viewModel;
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        welcomeText.setText("No file selected");
        button.setOnAction(actionEvent -> {
            File file = fileChooser.showOpenDialog(stage);
            if (file != null) {
                welcomeText.setText(file.toString());
            }
        });
    }
}
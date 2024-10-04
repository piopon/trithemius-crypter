package codes.pnk;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private Button button;
    private FileChooser fileChooser;
    private Stage stage;

    public HelloController(Stage stage) {
        this.fileChooser = new FileChooser();
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
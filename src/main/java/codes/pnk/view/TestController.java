package codes.pnk.view;

import codes.pnk.model.presentation.ViewActionType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class TestController implements Initializable {

    @FXML
    private TextField testText;
    @FXML
    private Button testButton;

    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
        testButton.setOnAction(action -> testText.setText("PRESSED!"));
    }
}

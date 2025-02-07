package codes.pnk.view;

import codes.pnk.model.presentation.FileType;
import codes.pnk.model.presentation.ViewActionType;
import codes.pnk.model.presentation.ViewConfig;
import codes.pnk.model.presentation.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class TabEmbedController extends TabController {
    @FXML
    private TextField fieldTextEmbed;
    @FXML
    private TextField fieldImageEmbed;
    @FXML
    private TextField fieldOutEmbed;
    @FXML
    private Button buttonTextEmbed;
    @FXML
    private Button buttonImageEmbed;
    @FXML
    private Button buttonOutEmbed;
    @FXML
    private Button buttonActionEmbed;

    public TabEmbedController(final ViewModel viewModel, final ViewConfig viewConfig) {
        super(viewModel, viewConfig);
    }

    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
        initializeFileField(fieldTextEmbed, FileType.TEXT, buttonTextEmbed, getViewModel().textFile());
        initializeFileField(fieldImageEmbed, FileType.JPEG, buttonImageEmbed, getViewModel().imageFile());
        initializePathField(fieldOutEmbed, buttonOutEmbed, getViewModel().outputPath());
        buttonActionEmbed.setOnAction(actionEvent -> getViewConfig().action().accept(ViewActionType.EMBED));
        buttonActionEmbed.disableProperty().bind(fieldTextEmbed.textProperty().isEqualTo(EMPTY_TEXT_FIELD)
             .or(fieldImageEmbed.textProperty().isEqualTo(EMPTY_TEXT_FIELD))
             .or(fieldOutEmbed.textProperty().isEqualTo(EMPTY_TEXT_FIELD)));
    }
}

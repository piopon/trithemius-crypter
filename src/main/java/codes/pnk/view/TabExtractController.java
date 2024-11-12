package codes.pnk.view;

import codes.pnk.model.presentation.ViewActionType;
import codes.pnk.model.presentation.ViewConfig;
import codes.pnk.model.presentation.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class TabExtractController extends TabController {
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

    public TabExtractController(final ViewModel viewModel, final ViewConfig viewConfig) {
        super(viewModel, viewConfig);
    }

    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
        initializeFileField(fieldImageExtract, buttonImageExtract, getViewModel().imageFile());
        initializePathField(fieldOutExtract, buttonOutExtract, getViewModel().outputPath());
        buttonActionExtract.setOnAction(actionEvent -> getViewConfig().action().accept(ViewActionType.EXTRACT));
        buttonActionExtract.disableProperty().bind(fieldImageExtract.textProperty().isEqualTo(EMPTY_TEXT_FIELD)
            .or(fieldOutExtract.textProperty().isEqualTo(EMPTY_TEXT_FIELD)));
    }
}

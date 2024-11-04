package codes.pnk.view;

import codes.pnk.model.presentation.ViewConfig;
import codes.pnk.model.presentation.ViewModel;
import javafx.beans.property.ObjectProperty;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.nio.file.Path;

public abstract class TabController implements Initializable {
    private final static String EMPTY_TEXT_FIELD = "-- none selected --";

    private final FileChooser fileChooser = new FileChooser();
    private final DirectoryChooser pathChooser = new DirectoryChooser();
    private final ViewConfig viewConfig;
    private final ViewModel viewModel;

    public TabController(final ViewModel viewModel, final ViewConfig viewConfig) {
        this.viewConfig = viewConfig;
        this.viewModel = viewModel;
    }

    protected ViewConfig getViewConfig() {
        return this.viewConfig;
    }

    protected ViewModel getViewModel() {
        return this.viewModel;
    }

    protected void initializeFileField(TextField field, Button button, ObjectProperty<File> property) {
        updateTextField(field, property);
        button.setOnAction(actionEvent -> {
            File file = fileChooser.showOpenDialog(viewConfig.stage());
            if (file != null) {
                property.setValue(file);
                updateTextField(field, property);
            }
        });
    }

    protected void initializePathField(TextField field, Button button, ObjectProperty<Path> property) {
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
}

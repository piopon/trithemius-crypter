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
    protected final static String EMPTY_TEXT_FIELD = "-- none selected --";

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

    protected void initializeFileField(final TextField field, final Button button, final ObjectProperty<File> prop) {
        updateTextField(field, prop);
        button.setOnAction(actionEvent -> {
            File file = fileChooser.showOpenDialog(viewConfig.stage());
            if (file != null) {
                prop.setValue(file);
                updateTextField(field, prop);
            }
        });
    }

    protected void initializePathField(final TextField field, final Button button, final ObjectProperty<Path> prop) {
        updateTextField(field, prop);
        button.setOnAction(actionEvent -> {
            File file = pathChooser.showDialog(viewConfig.stage());
            if (file != null) {
                prop.setValue(file.toPath());
                updateTextField(field, prop);
            }
        });
    }

    private <T> void updateTextField(final TextField field, final ObjectProperty<T> modelValue) {
        field.setText(modelValue.isNotNull().get() ? modelValue.getValue().toString() : EMPTY_TEXT_FIELD);
    }
}

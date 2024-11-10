package codes.pnk.model.presentation;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.io.File;
import java.nio.file.Path;
import java.util.Objects;

public record ViewModel(ObjectProperty<File> imageFile, ObjectProperty<File> textFile,
                        ObjectProperty<Path> outputPath) {
    public ViewModel() {
        this(null, null, null);
    }
}

package codes.pnk.model.presentation;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.io.File;
import java.nio.file.Path;
import java.util.Objects;

public final class ViewModel {
    private final ObjectProperty<File> imageFile;
    private final ObjectProperty<File> textFile;
    private final ObjectProperty<Path> outputPath;

    public ViewModel() {
        this(null, null, null);
    }

    public ViewModel(final File imageFile, final File textFile, final Path outputPath) {
        this.imageFile = new SimpleObjectProperty<>(imageFile);
        this.textFile = new SimpleObjectProperty<>(textFile);
        this.outputPath = new SimpleObjectProperty<>(outputPath);
    }

    public ObjectProperty<File> getImageFile() {
        return imageFile;
    }

    public ObjectProperty<File> getTextFile() {
        return textFile;
    }

    public ObjectProperty<Path> getOutputPath() {
        return outputPath;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ViewModel) obj;
        return Objects.equals(this.imageFile, that.imageFile) && Objects.equals(this.textFile, that.textFile)
               && Objects.equals(this.outputPath, that.outputPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageFile, textFile, outputPath);
    }

    @Override
    public String toString() {
        return "ViewModel[imageFile=" + imageFile + ", textFile=" + textFile + ", outputPath=" + outputPath + ']';
    }
}

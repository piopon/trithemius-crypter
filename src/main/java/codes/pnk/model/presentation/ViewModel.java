package codes.pnk.model.presentation;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.File;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Optional;

public final class ViewModel {
    private StringProperty imageFile;
    private StringProperty textFile;
    private StringProperty outputPath;

    public ViewModel() {
        this(null, null, null);
    }

    public ViewModel(final File imageFile, final File textFile, final Path outputPath) {
        this.imageFile = new SimpleStringProperty(imageFile == null ? "" : imageFile.toString());
        this.textFile = new SimpleStringProperty(textFile == null ? "" : textFile.toString());
        this.outputPath = new SimpleStringProperty(outputPath == null ? "" : outputPath.toString());
    }

    public Optional<StringProperty> getImageFile() {
        return Optional.ofNullable(imageFile);
    }

    public Optional<StringProperty> getTextFile() {
        return Optional.ofNullable(textFile);
    }

    public Optional<StringProperty> getOutputPath() {
        return Optional.ofNullable(outputPath);
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

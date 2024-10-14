package codes.pnk.model.presentation;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.File;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Optional;

public final class ViewModel {
    private File imageFile;
    private StringProperty textFile;
    private Path outputPath;

    public ViewModel() {
        this(null, null, null);
    }

    public ViewModel(final File imageFile, final File textFile, final Path outputPath) {
        this.imageFile = imageFile;
        this.textFile = new SimpleStringProperty(textFile.toString());
        this.outputPath = outputPath;
    }

    public Optional<File> getImageFile() {
        return Optional.ofNullable(imageFile);
    }

    public void setImageFile(final File imageFile) {
        this.imageFile = imageFile;
    }

    public Optional<StringProperty> getTextFile() {
        return Optional.ofNullable(textFile);
    }

    public void setTextFile(final File textFile) {
        this.textFile = new SimpleStringProperty(textFile.toString());
    }

    public Optional<Path> getOutputPath() {
        return Optional.ofNullable(outputPath);
    }

    public void setOutputPath(final Path outputPath) {
        this.outputPath = outputPath;
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

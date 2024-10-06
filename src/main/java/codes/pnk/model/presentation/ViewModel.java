package codes.pnk.model.presentation;

import java.io.File;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Optional;

public final class ViewModel {
    private Optional<File> imageFile;
    private Optional<File> textFile;
    private Optional<Path> outputPath;

    public ViewModel(Optional<File> imageFile, Optional<File> textFile, Optional<Path> outputPath) {
        this.imageFile = imageFile;
        this.textFile = textFile;
        this.outputPath = outputPath;
    }

    public ViewModel() {
        this(Optional.empty(), Optional.empty(), Optional.empty());
    }

    public Optional<File> getImageFile() {
        return imageFile;
    }

    public void setImageFile(Optional<File> imageFile) {
        this.imageFile = imageFile;
    }

    public Optional<File> getTextFile() {
        return textFile;
    }

    public void setTextFile(Optional<File> textFile) {
        this.textFile = textFile;
    }

    public Optional<Path> getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(Optional<Path> outputPath) {
        this.outputPath = outputPath;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        var that = (ViewModel) obj;
        return Objects.equals(this.imageFile, that.imageFile) && Objects.equals(this.textFile,
                                                                                that.textFile) && Objects.equals(
                this.outputPath, that.outputPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageFile, textFile, outputPath);
    }

    @Override
    public String toString() {
        return "ViewModel[" + "imageFile=" + imageFile + ", " + "textFile=" + textFile + ", " + "outputPath=" + outputPath + ']';
    }
}

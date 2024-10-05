package codes.pnk.model.presentation;

import java.io.File;
import java.nio.file.Path;
import java.util.Optional;

public record ViewModel(Optional<File> imageFile, Optional<File> textFile, Optional<Path> outputPath) {
    public ViewModel() {
        this(Optional.empty(), Optional.empty(), Optional.empty());
    }
}

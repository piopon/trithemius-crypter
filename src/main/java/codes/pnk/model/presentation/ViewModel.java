package codes.pnk.model.presentation;

import java.io.File;
import java.nio.file.Path;

public record ViewModel(File imageFile, File textFile, Path outputPath) {
    public ViewModel() {
        this(null, null, null);
    }
}

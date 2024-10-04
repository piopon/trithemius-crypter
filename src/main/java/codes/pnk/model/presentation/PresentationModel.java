package codes.pnk.model.presentation;

import java.io.File;
import java.nio.file.Path;

public record PresentationModel(File imageFile, File textFile, Path outputPath) {
}

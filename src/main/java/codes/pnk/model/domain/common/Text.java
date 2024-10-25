package codes.pnk.model.domain.common;

import java.io.File;

public class Text {
    private final File sourceFile;

    public Text(final File file) {
        this.sourceFile = file;
    }

    public String getPath() {
        return sourceFile.getAbsolutePath();
    }

    public byte[] getData() {
        return null;
    }
}

package codes.pnk.model.domain.common;

import java.io.File;

public class Image {

    private final File sourceFile;
    private final byte[] data;

    public Image(final File file) throws ImageException {
        this.sourceFile = file;
    }

    }
}

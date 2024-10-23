package codes.pnk.model.domain.common;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class Image {
    private static final int BUFFER_SIZE = 512;

    private final File sourceFile;
    private final byte[] data;

    public Image(final File file) throws ImageException {
        this.sourceFile = file;
    }

    private byte[] fileStreamToBytes(InputStream is) throws ImageException {
        try (ByteArrayOutputStream stream = new ByteArrayOutputStream()) {
            int bytesRead;
            byte[] data = new byte[BUFFER_SIZE];
            while ((bytesRead = is.read(data, 0, BUFFER_SIZE)) >= 0) {
                stream.write(data, 0, bytesRead);
            }
            return stream.toByteArray();
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }
}

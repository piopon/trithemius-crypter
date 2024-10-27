package codes.pnk.model.domain.common;

import codes.pnk.model.domain.exception.TextException;

import java.io.*;

public class Text {
    private static final int BUFFER_SIZE = 512;

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

    private byte[] streamToBytes(InputStream is) throws TextException {
        try (ByteArrayOutputStream stream = new ByteArrayOutputStream()) {
            int bytesRead;
            byte[] data = new byte[BUFFER_SIZE];
            while ((bytesRead = is.read(data, 0, BUFFER_SIZE)) >= 0) {
                stream.write(data, 0, bytesRead);
            }
            return stream.toByteArray();
        } catch (IOException e) {
            throw new TextException(e);
        }
    }
}

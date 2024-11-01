package codes.pnk.model.domain.common;

import codes.pnk.model.domain.exception.TextException;

import java.io.*;

public class Text {
    private static final int BUFFER_SIZE = 512;

    private final File sourceFile;
    private final byte[] data;

    public Text(final File file) throws TextException {
        this.sourceFile = file;
        try (InputStream is = new FileInputStream(file)) {
            this.data = streamToBytes(is);
        } catch (IOException e) {
            throw new TextException("Cannot read image file: " + file.getAbsolutePath());
        }
    }

    public String getPath() {
        return sourceFile.getAbsolutePath();
    }

    public byte[] getData() {
        return data;
    }

    private byte[] streamToBytes(final InputStream is) throws TextException {
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

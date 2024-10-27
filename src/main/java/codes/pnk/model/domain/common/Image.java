package codes.pnk.model.domain.common;

import codes.pnk.model.domain.exception.ImageException;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;

public class Image {
    private static final int BUFFER_SIZE = 512;

    private final File sourceFile;
    private final byte[] data;

    public Image(final File file) throws ImageException {
        this.sourceFile = file;
        try (InputStream is = new FileInputStream(file)) {
            this.data = streamToBytes(is);
        } catch (IOException e) {
            throw new ImageException("Cannot read image file: " + file.getAbsolutePath());
        }
    }

    public Image(final String imagePath, final BufferedImage bufferedImage) throws ImageException {
        this.sourceFile = new File(imagePath);
        this.data = bufferedImageToData(bufferedImage);
    }

    public String getPath() {
        return sourceFile.getAbsolutePath();
    }

    public byte[] getRawImageData() {
        return data;
    }

    public BufferedImage getBufferedImageData() throws ImageException {
        return streamToBufferedImage(new ByteArrayInputStream(this.data));
    }

    private byte[] streamToBytes(InputStream is) throws ImageException {
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

    private BufferedImage streamToBufferedImage(InputStream is) throws ImageException {
        try {
            ImageInputStream imageStream = ImageIO.createImageInputStream(is);
            Iterator<ImageReader> readers = ImageIO.getImageReaders(imageStream);
            if (!readers.hasNext()) {
                return null;
            }
            ImageReader reader = readers.next();
            reader.setInput(imageStream);
            return reader.read(0);
        } catch (IOException e) {
            throw new ImageException(e);
        }
    }

    private byte[] bufferedImageToData(final BufferedImage bufferedImage) throws ImageException {
        String imageName = sourceFile.getName();
        String imageType = imageName.substring(imageName.lastIndexOf('.') + 1).toLowerCase();
        if (imageType.equals("jp2")) {
            imageType = "jpeg 2000";
        }
        ByteArrayOutputStream barrOS = new ByteArrayOutputStream();
        try {
            ImageWriter writer = ImageIO.getImageWritersByFormatName(imageType).next();
            writer.setOutput(ImageIO.createImageOutputStream(barrOS));
            writer.write(null, new IIOImage(bufferedImage, null, null), null);
        } catch (IOException e) {
            throw new ImageException(e);
        }
        return barrOS.toByteArray();
    }
}

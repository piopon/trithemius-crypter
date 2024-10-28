package codes.pnk.model.domain.algorithm.dh.lsb;

import codes.pnk.model.domain.common.Image;
import codes.pnk.model.domain.exception.ImageException;
import codes.pnk.model.domain.common.Text;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

public class LsbOutputStream extends OutputStream {
    private final Image image;
    private final Text text;
    private BufferedImage output;
    private int pixelX = 0;
    private int pixelY = 0;
    private int colorChannelBits = 1;

    public LsbOutputStream(final Image image, final Text text) throws ImageException {
        this.image = image;
        this.text = text;
        this.output = initializeOutputImage();
    }

    @Override
    public void write(int b) throws IOException {
        return;
    }

    public BufferedImage getOutput() {
        return this.output;
    }

    private BufferedImage initializeOutputImage() throws ImageException {
        int imageWidth = this.image.getBufferedImageData().getWidth();
        int imageHeight = this.image.getBufferedImageData().getHeight();
        BufferedImage newImg = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < imageWidth; x++) {
            for (int y = 0; y < imageHeight; y++) {
                newImg.setRGB(x, y, this.image.getBufferedImageData().getRGB(x, y));
            }
        }
        return newImg;
    }

    private int getPixelRGB() {
        int maskPerByte = (int) (Math.pow(2, this.colorChannelBits) - 1);
        int mask = (maskPerByte << 16) + (maskPerByte << 8) + maskPerByte;
        return this.output.getRGB(this.pixelX, this.pixelY) & (0xFFFFFFFF - mask);
    }

    private void nextPixel() {
        this.pixelX++;
        if (this.pixelX == this.output.getWidth()) {
            this.pixelX = 0;
            this.pixelY++;
        }
    }

}

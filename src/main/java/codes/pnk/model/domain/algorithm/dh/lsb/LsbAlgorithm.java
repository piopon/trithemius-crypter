package codes.pnk.model.domain.algorithm.dh.lsb;

import codes.pnk.model.domain.algorithm.Algorithm;
import codes.pnk.model.domain.common.Image;
import codes.pnk.model.domain.exception.AlgorithmException;
import codes.pnk.model.domain.exception.ImageException;
import codes.pnk.model.domain.common.Text;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class LsbAlgorithm extends Algorithm {
    @Override
    public byte[] embed(final Text secretText, final Image coverImage) throws AlgorithmException {
        try {
            BufferedImage outputImage;
            try (LsbOutputStream lsbOS = new LsbOutputStream(coverImage)) {
                lsbOS.write(secretText.getData());
                lsbOS.flush();
                outputImage = lsbOS.getOutput();
            }
            return new Image(secretText.getPath(), outputImage).getRawImageData();
        } catch (IOException | ImageException e) {
            throw new AlgorithmException(e);
        }
    }

    @Override
    public byte[] extract(final Image image) throws AlgorithmException {
        return new byte[0];
    }
}

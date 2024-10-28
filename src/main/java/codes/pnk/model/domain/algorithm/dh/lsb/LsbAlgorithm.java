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
    public byte[] embed(Text inText, Image inImage) throws AlgorithmException {
        try {
            BufferedImage outputImage = null;
            try (LsbOutputStream lsbOS = new LsbOutputStream(inImage)) {
                lsbOS.write(inText.getData());
                lsbOS.flush();
                outputImage = lsbOS.getOutput();
            }
            return new Image(inImage.getPath(), outputImage).getRawImageData();
        } catch (IOException | ImageException e) {
            throw new AlgorithmException(e);
        }
    }

    @Override
    public byte[] extract(Image inImage) throws AlgorithmException {
        return new byte[0];
    }
}

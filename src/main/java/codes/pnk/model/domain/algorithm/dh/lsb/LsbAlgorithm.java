package codes.pnk.model.domain.algorithm.dh.lsb;

import codes.pnk.model.domain.algorithm.Algorithm;
import codes.pnk.model.domain.common.Image;
import codes.pnk.model.domain.common.ImageException;
import codes.pnk.model.domain.common.Text;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class LsbAlgorithm extends Algorithm {
    @Override
    public byte[] embed(Text inText, Image inImage) throws ImageException {
        return new byte[0];
    }

    @Override
    public byte[] extract(byte[] inData) throws ImageException {
        return new byte[0];
    }
}

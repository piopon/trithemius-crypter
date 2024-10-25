package codes.pnk.model.domain.algorithm.dh.lsb;

import codes.pnk.model.domain.common.Image;
import codes.pnk.model.domain.common.ImageException;
import codes.pnk.model.domain.common.Text;

import java.io.IOException;
import java.io.OutputStream;

public class LsbOutputStream extends OutputStream {
    private final Image image;
    private final Text text;

    public LsbOutputStream(final Image image, final Text text) throws ImageException {
        this.image = image;
        this.text = text;
    }

    @Override
    public void write(int b) throws IOException {
        return;
    }
}

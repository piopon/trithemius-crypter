package codes.pnk.model.domain.common;

import javax.imageio.metadata.IIOMetadata;
import java.awt.image.BufferedImage;

public class Image {
    private String name;
    private BufferedImage data;
    private IIOMetadata metadata;

    public Image(final String name, final BufferedImage data, final IIOMetadata metadata) {
        this.name = name;
        this.data = data;
        this.metadata = metadata;
    }

    public Image(final String name, final byte[] data) {
        this.name = name;
    }
}

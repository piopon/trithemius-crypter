package codes.pnk.model.domain.algorithm;

import codes.pnk.model.domain.common.Image;
import codes.pnk.model.domain.exception.AlgorithmException;
import codes.pnk.model.domain.common.Text;

public abstract class Algorithm {

    /**
     * Method used to embed text data into image
     * @param secretText text file to be embedded into image
     * @param coverImage image file in which the text should be embedded
     * @return output image data with embedded text
     */
    public abstract byte[] embed(Text secretText, Image coverImage) throws AlgorithmException;

    /**
     * Method used to extract text data from image data
     * @param image image file from which the text should be extracted
     * @return extracted text data
     */
    public abstract byte[] extract(Image image) throws AlgorithmException;
}

package codes.pnk.model.domain.algorithm;

public abstract class Algorithm {

    /**
     * Method used to embed text data into image
     * @param inText text contents to be embedded into image
     * @param inImage image in which the text should be embedded
     * @return output image data with embedded text
     */
    public abstract byte[] embed(byte[] inText, byte[] inImage);

    /**
     * Method used to extract text data from image data
     * @param inData image from which the text should be extracted
     * @return extracted text data
     */
    public abstract byte[] extract(byte[] inData);
}

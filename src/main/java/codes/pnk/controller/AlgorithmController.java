package codes.pnk.controller;

import codes.pnk.model.domain.algorithm.Algorithm;
import codes.pnk.model.domain.common.Image;
import codes.pnk.model.domain.common.Text;
import codes.pnk.model.domain.exception.AlgorithmException;
import codes.pnk.model.domain.exception.ImageException;
import codes.pnk.model.domain.exception.TextException;
import codes.pnk.model.presentation.ViewActionType;
import codes.pnk.model.presentation.ViewModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class AlgorithmController {
    private final Algorithm algorithm;

    public AlgorithmController(final Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void start(ViewModel viewModel, ViewActionType action) {
        switch (action) {
            case EMBED -> {
                try {
                    final Text secret = new Text(viewModel.getTextFile().getValue());
                    final Image cover = new Image(viewModel.getImageFile().getValue());
                    final byte[] data = algorithm.embed(secret, cover);
                    final File outputFile = viewModel.getOutputPath().getValue().resolve(cover.getName()).toFile();
                    try (OutputStream os = new FileOutputStream(outputFile)) {
                        os.write(data);
                    } catch (IOException e) {
                        throw new AlgorithmException(e.getMessage());
                    }
                } catch (TextException e) {
                    System.out.println("Unable to resolve text file: " + e.getMessage());
                } catch (ImageException e) {
                    System.out.println("Unable to resolve image file: " + e.getMessage());
                } catch (AlgorithmException e) {
                    System.out.println("Embedding problem: " + e.getMessage());
                }
            }
            default -> System.out.println("Unsupported action type: " + action);
        }
    }
}

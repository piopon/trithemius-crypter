package codes.pnk.controller;

import codes.pnk.model.domain.algorithm.Algorithm;
import codes.pnk.model.domain.algorithm.dh.lsb.LsbAlgorithm;
import codes.pnk.model.domain.common.Image;
import codes.pnk.model.domain.common.Text;
import codes.pnk.model.domain.exception.AlgorithmException;
import codes.pnk.model.domain.exception.ImageException;
import codes.pnk.model.domain.exception.TextException;
import codes.pnk.model.presentation.ViewActionType;
import codes.pnk.model.presentation.ViewConfig;
import codes.pnk.model.presentation.ViewModel;
import codes.pnk.view.FxmlBuilder;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.File;

public class ViewController {
    private final ViewModel viewModel = new ViewModel();
    private final FxmlBuilder viewBuilder;

    public ViewController(final Stage stage) {
        this.viewBuilder = new FxmlBuilder(viewModel, new ViewConfig(stage, this::startSteganography));
    }

    public Region getView() {
        return viewBuilder.build();
    }

    private void startSteganography(ViewActionType action) {
        switch (action) {
            case EMBED:
                try {
                    Algorithm algorithm = new LsbAlgorithm();
                    final Text secret = new Text(viewModel.getTextFile().getValue());
                    final Image cover = new Image(viewModel.getImageFile().getValue());
                    final byte[] data = algorithm.embed(secret, cover);
                    final File outputFile = viewModel.getOutputPath().getValue().resolve(cover.getName()).toFile();
                    System.out.println("Output file: " + outputFile.getPath());
                } catch (TextException e) {
                    System.out.println("Unable to resolve text file: " + e.getMessage());
                } catch (ImageException e) {
                    System.out.println("Unable to resolve image file: " + e.getMessage());
                } catch (AlgorithmException e) {
                    System.out.println("Embedding problem: " + e.getMessage());
                }
                break;
            case EXTRACT:
            default:
                System.out.println("Unsupported action type: " + action);
                break;
        }
    }
}

package codes.pnk.controller;

import codes.pnk.model.presentation.ViewConfig;
import codes.pnk.model.presentation.ViewModel;
import codes.pnk.view.FxmlBuilder;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ViewController {
    private final ViewModel viewModel = new ViewModel();
    private final FxmlBuilder viewBuilder;

    public ViewController(final Stage stage) {
        this.viewBuilder = new FxmlBuilder(viewModel, new ViewConfig(stage, this::startSteganography));
    }

    public Region getView() {
        return viewBuilder.build();
    }

    private void startSteganography(int mode) {
        System.out.println("Selected text file:   " + viewModel.getTextFile().get().getValue());
        System.out.println("Selected image file:  " + viewModel.getImageFile().get().getValue());
        System.out.println("Selected output path: " + viewModel.getOutputPath().get().getValue());
        if(mode == 0) {
            System.out.println("Start EMBED action");
        } else {
            System.out.println("startSteganography -> " + mode);
        }
    }
}

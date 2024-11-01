package codes.pnk.controller;

import codes.pnk.model.domain.algorithm.dh.lsb.LsbAlgorithm;
import codes.pnk.model.domain.exception.AlgorithmException;
import codes.pnk.model.presentation.ViewActionType;
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

    private void startSteganography(final ViewActionType action) {
        try {
            AlgorithmController controller = new AlgorithmController(new LsbAlgorithm());
            controller.start(viewModel, action);
        } catch (AlgorithmException e) {
            System.out.println("Error while executing " + action + " action: " + e.getMessage());
        }
    }
}

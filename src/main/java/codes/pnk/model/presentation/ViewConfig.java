package codes.pnk.model.presentation;

import javafx.stage.Stage;

import java.util.function.Consumer;

public record ViewConfig(Stage stage, Consumer<Integer> action) {
}

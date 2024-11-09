module codes.pnk {
    requires java.desktop;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    exports codes.pnk;
    exports codes.pnk.view;
    exports codes.pnk.model.presentation;

    opens codes.pnk to javafx.fxml;
    opens codes.pnk.view to javafx.fxml;
    opens codes.pnk.controller to javafx.fxml;
}
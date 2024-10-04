module codes.pnk {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens codes.pnk to javafx.fxml;

    exports codes.pnk;
    opens codes.pnk.controller to javafx.fxml;
    exports codes.pnk.view;
    opens codes.pnk.view to javafx.fxml;
}
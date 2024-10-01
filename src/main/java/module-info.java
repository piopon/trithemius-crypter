module codes.pnk.trithemiusvault {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
                        requires org.kordamp.bootstrapfx.core;
            
    opens codes.pnk.trithemiusvault to javafx.fxml;
    exports codes.pnk.trithemiusvault;
}
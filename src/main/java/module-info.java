module org.example.fisicosfamosos {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.example.fisicosfamosos to javafx.fxml;
    exports org.example.fisicosfamosos;
}
module org.example.fisicosfamosos {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens co.rdario45.fisicosfamosos to javafx.fxml;
    exports co.rdario45.fisicosfamosos;
}
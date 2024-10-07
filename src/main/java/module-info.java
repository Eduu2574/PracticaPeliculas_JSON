module org.example.practicajson_eduardodominguez {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.fasterxml.jackson.databind;

    opens org.example.practicajson_eduardodominguez to javafx.fxml;
    exports org.example.practicajson_eduardodominguez;
}
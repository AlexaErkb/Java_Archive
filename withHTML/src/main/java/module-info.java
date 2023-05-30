module com.example.withhtml {
    requires javafx.controls;
    requires javafx.fxml;

    requires javafx.web;

    opens com.example.withhtml to javafx.fxml;
    exports com.example.withhtml;
}
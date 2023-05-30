module com.example.exclass {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.exclass to javafx.fxml;
    exports com.example.exclass;
}
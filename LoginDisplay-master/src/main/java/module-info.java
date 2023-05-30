module com.example.logindisplay {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.logindisplay to javafx.fxml;
    exports com.example.logindisplay;
}
module com.example.sashakakasha {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sashakakasha to javafx.fxml;
    exports com.example.sashakakasha;
}
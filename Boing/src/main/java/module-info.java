module com.example.cs115 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cs115 to javafx.fxml;
    exports com.example.cs115;
}
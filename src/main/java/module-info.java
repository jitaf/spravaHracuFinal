module org.example.spravahracu {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens org.example.spravahracu to javafx.fxml;
    exports org.example.spravahracu;
}
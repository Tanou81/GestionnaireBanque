module com.example.gestionnairebanque {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens com.example.gestionnairebanque to javafx.fxml;
    exports com.example.gestionnairebanque;
    exports com.example.gestionnairebanque.tests;
    opens com.example.gestionnairebanque.tests to javafx.fxml;
}
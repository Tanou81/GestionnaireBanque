module com.example.gestionnairebanque {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.gestionnairebanque to javafx.fxml;
    exports com.example.gestionnairebanque;
}
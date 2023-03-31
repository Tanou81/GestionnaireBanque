package com.example.gestionnairebanque;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Controleur {

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TextField tfNom;

    @FXML
    private TextField tfMontant;

    @FXML
    private ListView<Label> lvListeEtudiant;

    private ObservableList<Label> observableList;

    /***
     * Méthode appelée automatiquement par JavaFX lors de l'initialisation de la fenêtre.
     */
    public void initialize() {
        GestionnaireBancaire GestionnaireBancaire = new GestionnaireBancaire(); // Créer un objet GestionnaireEtudiant qui charge le fichier de critères.

        observableList = FXCollections.observableArrayList(); // Créer une observableList<Label> liée à la ListView dans la méthode initialize()
        lvListeEtudiant.setItems(observableList); // Lier la ListView à l'observableList


    }
/**
     * Méthode appelée lors de l'appui sur le bouton "Enregistrer" de la fenêtre.
     * @param event
     */
    @FXML
    public void actionEnregistrer(ActionEvent event) {
        System.out.println("Enregistrer");
        String nom = tfNom.getText();
        System.out.println("Montant is "+tfMontant.getText());
        Double montant =0.0;
        try {
            montant = Double.parseDouble(tfMontant.getText());
        } catch (NumberFormatException e) {
            System.out.println("Montant is not a number");
        }

        String type = comboBox.getValue();
        char c = 'D'; // Par défaut, c'est un débit
        if (type.equals("Crédit")) {
            c = 'C';
        }
        Transaction transaction = new Transaction(nom, c, montant);
        System.out.println("SO is "+transaction.toString());
        tfNom.clear();
        tfMontant.clear();
        comboBox.getSelectionModel().clearSelection();

        Label label = new Label(transaction.toString());

        observableList.add(label);
    }

/*
    @FXML
    void actionEnregistrer(ActionEvent event) {
        System.out.println("Enregistrer");
        String nom = tfNom.getText();
        String prenom = tfPrenom.getText();
        String moyenneStr = tfMoyenne.getText();

        System.out.println("Nom: " + nom + " Prenom: " + prenom + " Moyenne: " + moyenneStr);
        double moyenne = Double.parseDouble(tfMoyenne.getText());

        // Créer un objet Etudiant
        Etudiant etudiant = new Etudiant(nom, prenom, moyenne);

        // Ajouter l'étudiant à la promotion dans l'objet GestionnaireEtudiant
        gestionnaireEtudiant.ajouterEtudiant(etudiant);

        // Sauvegarder la promotion dans un fichier

        // Ajouter un Label dans la ListView
        Label label = new Label(etudiant.toString());
        label.setTextFill(gestionnaireEtudiant.choisirRgb(etudiant)); // Colorer le label selon le critère applicable à l'étudiant enregistré
        observableList.add(label);
    }
    public void afficherListeTransactions() {
        lvListeEtudiant.setItems(FXCollections.observableArrayList(
               // GestionnaireBancaire.getInstance().getTransactions().toString()));
    }
   */

}
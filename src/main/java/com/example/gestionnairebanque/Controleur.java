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
    private Label tSolde;
    @FXML
    private ListView<Label> lvListeEtudiant;

    private ObservableList<Label> observableList;

    private GestionnaireBancaire gestionnaireBancaire;
    /***
     * Méthode appelée automatiquement par JavaFX lors de l'initialisation de la fenêtre.
     */
    public void initialize() {
         gestionnaireBancaire = com.example.gestionnairebanque.GestionnaireBancaire.getInstance(); // Créer un objet GestionnaireBancaire qui charge le fichier de critères.

        observableList = FXCollections.observableArrayList(); // Créer une observableList<Label> liée à la ListView dans la méthode initialize()
        lvListeEtudiant.setItems(observableList); // Lier la ListView à l'observableList

        tSolde.setText(String.valueOf(gestionnaireBancaire.getSolde()));
    }

    /**
     * Méthode appelée lors de l'appui sur le bouton "Enregistrer" de la fenêtre.
     * elle ajoute une transaction à la liste des transactions.
     * elle ajoute une ligne à la ListView.
     * elle efface les champs de saisie.
     * elle met à jour le solde.
     * @param event
     */
    @FXML
    public void actionEnregistrer(ActionEvent event) {
        System.out.println("Enregistrer");
        String nom = tfNom.getText();
        System.out.println("Montant is " + tfMontant.getText());
        Double montant = 0.0;
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
        System.out.println("SO is " + transaction.toString());
        gestionnaireBancaire.ajouterTransaction(transaction);
        tfNom.clear();
        tfMontant.clear();
        comboBox.getSelectionModel().clearSelection();
        Label label = new Label(transaction.toString());

        tSolde.setText(gestionnaireBancaire.getSoldeString());
        observableList.add(label);
    }


}
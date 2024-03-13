package jeu;

import utils.LectureFichier;

import javax.swing.*;

public class ModelePendu {

    private String motSecret;
    private StringBuilder motAffiche;
    private int nbEssaisRestants;

    private StringBuilder lettreEntree;

    /**
     * Le constructeur doit initier le motAffiche qui doit avoir un nombre de "_ " égal au nombre de lettre du
     * mot entré en paramètre lors de la création du constructeur.
     * @param motSecret mot à faire deviner qui a été généré aléatoirement
     */
    public ModelePendu(String motSecret) {
        this.lettreEntree = new StringBuilder();
        this.motSecret = motSecret;
        motAffiche = new StringBuilder();
        for (int i = 0; i < motSecret.length(); i++) {
            if (motSecret.charAt(i) == '-') {
                motAffiche.append("- ");
            } else {
                motAffiche.append("_ ");
            }
        }
        nbEssaisRestants = 10;
    }

    public String getMotAffiche() {
        return motAffiche.toString();
    }

    public String getMotSecret() {
        return motSecret;
    }

    public int getNbEssaisRestants() {
        return nbEssaisRestants;
    }

    public StringBuilder getLettreEntree() {
        return lettreEntree;
    }

    public void setLettreEntree(char lettreEntree) {
        this.lettreEntree.append(lettreEntree + " ");
    }

    /**
     *
     * @param letter lettre entré par l'utilisateur pour trouver si elle se trouve dans le mot à deviner ou non
     * @return true si la lettre se trouve dans le mot à faire deviner
     */
    public boolean devinerLetter(char letter) {
        boolean trouve = false;
        for (int i = 0; i < motSecret.length(); i++) {
            if (motSecret.charAt(i) == letter) {
                motAffiche.setCharAt(i * 2, letter);
                trouve = true;
            }
        }
        if (!trouve) {
            nbEssaisRestants--;
        }
        return trouve;
    }

    public boolean isMotDevine() {
        return motAffiche.toString().replace(" ", "").equals(motSecret);
    }

    /**
     * Affiche la définition du mot à deviner si le texte est à blanc ou met le texte à blanc si la définition est affiché
     * @param definitionTextArea
     */
    public void afficherDefinition(JTextArea definitionTextArea) {
        if (definitionTextArea.getText().isBlank()) {
            definitionTextArea.setText(LectureFichier.getDefinition(motSecret));
        } else {
            definitionTextArea.setText("");
        }
    }
}

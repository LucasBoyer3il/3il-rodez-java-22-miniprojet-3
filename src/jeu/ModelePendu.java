package jeu;

import utils.LectureFichier;

import javax.swing.*;

public class ModelePendu {

    private String motSecret;
    private StringBuilder motAffiche;
    private int nbEssaisRestants;

    private StringBuilder lettreEntree;

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

    public boolean guessLetter(char letter) {
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

    public void afficherDefinition(JTextArea definitionTextArea) {
        if (definitionTextArea.getText().isBlank()) {
            definitionTextArea.setText(LectureFichier.getDefinition(motSecret));
        } else {
            definitionTextArea.setText("");
        }
    }
}

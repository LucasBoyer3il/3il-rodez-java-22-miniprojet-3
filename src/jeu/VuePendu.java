package jeu;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;

public class VuePendu {

    private JLabel label;
    public VuePendu(String mot) {
        JFrame fenetre = new JFrame("Pendu");
        fenetre.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int longueur = mot.length();
        JLabel label = new JLabel(String.join("", Collections.nCopies(longueur, "_ ")));
        label.setSize(300, 300);
        fenetre.add(label);
        JTextField entree = new JTextField(20);
        entree.setToolTipText("Proposez une lettre ici");
        entree.setSize(100, 100);
        fenetre.add(entree);
        fenetre.setVisible(true);
    }


}

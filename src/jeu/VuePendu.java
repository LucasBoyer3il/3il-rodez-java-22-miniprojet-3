package jeu;

import utils.LectureFichier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class VuePendu {
    private ModelePendu model;
    private JLabel motLabel;
    private JLabel essaisLabel;

    private JLabel lettreDevinees;

    private JTextField entreeJoueur;

    private JButton boutonDefinition;

    private JButton boutonRejouer;

    private JTextArea definitionTextArea;

    private JLabel imagePendu;

    public VuePendu(ModelePendu model) {
        this.model = model;

        JFrame fenetre = new JFrame("Jeu du Pendu");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(1920, 500);
        //fenetre.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        motLabel = new JLabel(model.getMotAffiche());
        essaisLabel = new JLabel("Essais restants : " + model.getNbEssaisRestants());
        entreeJoueur = new JTextField(2);
        lettreDevinees = new JLabel("Lettres proposées : ");
        boutonDefinition = new JButton("Afficher la définition");
        boutonRejouer = new JButton("Rejouer");
        definitionTextArea = new JTextArea(2, 100); // Création du JTextArea
        imagePendu = new JLabel();
        ImageIcon imageIcon = new ImageIcon("/img/Pendu.PNG");
        imagePendu.setIcon(imageIcon);
        definitionTextArea.setEditable(false);
        boutonDefinition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.afficherDefinition(definitionTextArea);
            }
        });
        boutonRejouer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fenetre.getContentPane().removeAll();
                fenetre.getContentPane().revalidate();
                fenetre.add(panel);
                fenetre.repaint();
            }
        });
        entreeJoueur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String entree = entreeJoueur.getText();
                if (entree.length() == 1 && Character.isLetter(entree.charAt(0))) {
                    char letter = entree.charAt(0);
                    boolean trouve = model.guessLetter(letter);
                    if(!trouve) {
                        model.setLettreEntree(letter);
                    }
                    if (!trouve && model.getNbEssaisRestants() == 0) {
                        afficherMessageFin("Perdu ! Le mot était : " + model.getMotSecret());
                        System.exit(0);
                    }
                    updateVue();
                    if (model.isMotDevine()) {
                        afficherMessageFin("Bravo ! Vous avez deviné le mot : " + model.getMotSecret());
                        fenetre.getContentPane().removeAll();
                        fenetre.getContentPane().revalidate();
                        JPanel panelRejouer = new JPanel();
                        panelRejouer.add(boutonRejouer);
                        fenetre.add(panelRejouer);
                        fenetre.repaint();
                    }
                    entreeJoueur.setText("");
                }
            }
        });

        panel.add(motLabel);
        panel.add(essaisLabel);
        panel.add(entreeJoueur);
        panel.add(boutonDefinition);
        panel.add(definitionTextArea);
        panel.add(lettreDevinees);
        panel.add(imagePendu);
        fenetre.add(panel);

        fenetre.setVisible(true);
    }

    public void updateVue() {
        motLabel.setText(model.getMotAffiche());
        essaisLabel.setText("Essais restants : " + model.getNbEssaisRestants());
        lettreDevinees.setText("Lettres proposées : " + model.getLettreEntree());
    }

    public JLabel getMotLabel() {
        return motLabel;
    }

    public void afficherMessageFin(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public void afficherImage() {
        ImageIcon imageIcon = new ImageIcon("/img/Pendu.PNG"); // Chargement de l'image visible
        imagePendu.setIcon(imageIcon);
    }
}

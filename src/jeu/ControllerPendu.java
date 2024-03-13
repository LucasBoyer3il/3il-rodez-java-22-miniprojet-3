package jeu;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerPendu {
    private ModelePendu modele;
    private VuePendu vue;

    private boolean finDePartie;

    public ControllerPendu(ModelePendu modele, VuePendu vue) {
        this.modele = modele;
        this.vue = vue;
        this.finDePartie = false;
        vue.updateVue();

        vue.getEntreeJoueur().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String entree = vue.getEntreeJoueur().getText();
                if (entree.length() == 1 && Character.isLetter(entree.charAt(0))) {
                    char letter = entree.charAt(0);
                    boolean trouve = modele.devinerLetter(letter);
                    if(!trouve) {
                        modele.setLettreEntree(letter);
                    }
                    if (!trouve && modele.getNbEssaisRestants() == 0) {
                        vue.afficherMessageFin("Perdu ! Le mot était : " + modele.getMotSecret());
                        finDePartie();
                    }
                    vue.updateVue();
                    if (modele.isMotDevine()) {
                        vue.afficherMessageFin("Bravo ! Vous avez deviné le mot : " + modele.getMotSecret());
                        finDePartie();
                    }
                    vue.getEntreeJoueur().setText("");
                }
            }
        });
    }

    private void finDePartie() {
        this.finDePartie = true;
        vue.getFenetre().getContentPane().removeAll();
        vue.getFenetre().getContentPane().revalidate();
        JPanel panelRejouer = new JPanel();
        panelRejouer.add(vue.getBoutonRejouer());
        vue.getFenetre().add(panelRejouer);
        vue.getFenetre().repaint();
    }

    public boolean getFinDePartie() {
        return finDePartie;
    }
}


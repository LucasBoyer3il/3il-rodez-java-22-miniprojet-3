package jeu;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VuePendu extends JFrame {
    private ModelePendu model;

    private JFrame fenetre;
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

        fenetre = new JFrame("Jeu du Pendu");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(1920, 500);
        //fenetre.setExtendedState(JFrame.MAXIMIZED_BOTH); //Mettre le jeu en plein écran au lancement

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

    public JTextField getEntreeJoueur() {
        return entreeJoueur;
    }

    public JButton getBoutonRejouer() {
        return boutonRejouer;
    }

    public JFrame getFenetre() {
        return fenetre;
    }

    public void updateVue() {
        motLabel.setText(model.getMotAffiche());
        essaisLabel.setText("Essais restants : " + model.getNbEssaisRestants());
        lettreDevinees.setText("Lettres proposées : " + model.getLettreEntree());
    }

    public void afficherMessageFin(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public void afficherImage() {
        ImageIcon imageIcon = new ImageIcon("/img/Pendu.PNG"); // Chargement de l'image visible
        imagePendu.setIcon(imageIcon);
    }
}

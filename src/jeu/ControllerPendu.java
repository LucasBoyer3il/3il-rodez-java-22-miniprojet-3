package jeu;

import javax.swing.*;

public class ControllerPendu {

    VuePendu vuePendu;

    ModelePendu modelePendu;
    JButton bouton;

    public ControllerPendu(ModelePendu modelePendu, VuePendu vuePendu) {
        this.modelePendu = modelePendu;
        this.vuePendu = vuePendu;

    }
}

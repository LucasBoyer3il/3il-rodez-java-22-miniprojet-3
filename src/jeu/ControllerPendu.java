package jeu;


public class ControllerPendu {
    private ModelePendu modele;
    private VuePendu vue;

    public ControllerPendu(ModelePendu modele, VuePendu vue) {
        this.modele = modele;
        this.vue = vue;
        vue.updateVue();
    }
}


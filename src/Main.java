import jeu.ControllerPendu;
import jeu.ModelePendu;
import jeu.VuePendu;
import utils.Aleatoire;
import utils.LectureFichier;

import java.nio.file.Paths;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer , String> mots = LectureFichier.lireLignes(Paths.get("mots.txt"));
        int nombreAleatoire = Aleatoire.genererAleatoire(0, mots.size());
        String motAleatoire = mots.get(nombreAleatoire);
        System.out.println("mot aléatoire : " + motAleatoire);
        System.out.println("Définition : " + LectureFichier.getDefinition(nombreAleatoire));
        System.out.println("Définition : " + LectureFichier.getDefinition(mots.get(nombreAleatoire)));

        ModelePendu modelePendu = new ModelePendu();
        VuePendu vuePendu = new VuePendu(motAleatoire);
        ControllerPendu controllerPendu = new ControllerPendu(modelePendu, vuePendu);

    }
}

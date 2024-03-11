import utils.Aleatoire;
import utils.LectureFichier;

import java.nio.file.Paths;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer , String> motsEtDefinition = LectureFichier.lireLignes(Paths.get("mots.txt"));
        int nombreAleatoire = Aleatoire.genererAleatoire(0, motsEtDefinition.size());
        System.out.println("mot aléatoire : " + motsEtDefinition.get(nombreAleatoire));
    }
}

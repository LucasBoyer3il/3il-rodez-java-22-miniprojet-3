package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class LectureFichier {

    private static Map<Integer, String> mots = new HashMap<>();
    private static Map<String, String> definitions = new HashMap<>();

    public static Map<Integer , String> lireLignes(Path fichier) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(fichier)) {
            String lectureLigne = bufferedReader.readLine();
            Integer numeroLigne = 0;
            do {
                String[] ligneDecoupee = lectureLigne.split(" ");
                String mot = ligneDecoupee[0];
                String definition = lectureLigne.substring(mot.length());
                mots.put(numeroLigne, mot);
                definitions.put(mot, definition);
                lectureLigne = bufferedReader.readLine();
                numeroLigne++;
            } while (lectureLigne != null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mots;
    }

    public static String getDefinition(String mot) {
        return definitions.get(mot);

    }
}

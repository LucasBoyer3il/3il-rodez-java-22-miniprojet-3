package utils;

public class Aleatoire {

    public static int genererAleatoire(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}

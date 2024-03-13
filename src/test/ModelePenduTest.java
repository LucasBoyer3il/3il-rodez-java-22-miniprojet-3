package test;

import jeu.ModelePendu;
import org.junit.Assert;
import org.junit.Test;

public class ModelePenduTest {

    /**
     * Test du constructeur de la classe ModelePendu.
     * Le motAffiche de la classe doit avoir un nombre de "_ " égal au nombre de lettre du
     * mot entré en paramètre lors de la création du constructeur.
     */
    @Test
    public void testConstructeur() {
        ModelePendu modelePendu = new ModelePendu("test");
        Assert.assertEquals("_ _ _ _ ", modelePendu.getMotAffiche());
    }

    /**
     * Test de la méthode devinerLettre quand le caractère entré se trouve dans le mot à deviner.
     * La méthode doit renvoyer true si le caratère entré en paramètre se trouve dans le mot à deviner
     * et le nombre d'essais restant ne doit pas changer
     */
    @Test
    public void testDevinerLettreReussi() {
        ModelePendu modelePendu = new ModelePendu("test");
        Assert.assertTrue(modelePendu.devinerLetter('e'));
        Assert.assertEquals(10, modelePendu.getNbEssaisRestants());
    }

    /**
     * Test de la méthode devinerLettre quand le caractère entré ne se trouve pas dans le mot à deviner
     * la méthode doit renvoyer false si le caractère entré en paramètre ne se trouve pas dans le mot à deviner
     * et le nombre d'essais restant doit réduire de 1
     */
    @Test
    public void testDevinerLettreRate() {
        ModelePendu modelePendu = new ModelePendu("test");
        Assert.assertFalse(modelePendu.devinerLetter('r'));
        Assert.assertEquals(9, modelePendu.getNbEssaisRestants());
    }
}

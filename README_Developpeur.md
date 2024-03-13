1. Lecture aléatoire d'un mot à deviner à partir d'un fichier texte donné à la racine du projet.
- Un mot est chosis aléatoirement suivant une liste de mot dans un fichier texte et la définitio du mot est associé au mot
2. Affichage graphique de l'interface du jeu à l'aide de Swing.
- Réalisation d'un modèle MVC avec l'outil Swing.
3. Affichage graphique du pendu qui évolue en fonction des erreurs du joueur.
- Tentative d'implémentation mais les images ne s'affichent pas
4. Affichage graphique des lettres déjà proposées par le joueur.
- Réalisé en bas de la page du jeu
5. Affichage (ou non) de la définition (niveau de difficulté).
- Réalisé avec un bouton qui affiche ou non la définition du mot à deviner
6. Utilisation (ou non) d'un timer (niveau de difficulté).
- Aucune tentative de faite
7. Gestion des entrées utilisateur pour proposer des lettres.
- Un champ de texte a été implémenté pour que l'utilisateur rentre une lettre
8. Vérification de la validité des entrées utilisateur (lettre de l'alphabet uniquement).
- Implémenté grâce à la méthode "isLetter" dans le controller
9. Gestion du décompte des tentatives restantes.
- Implémenté en dessous du mot à deviner
10. Gestion de la victoire ou de la défaite du joueur.
- La victoire arrive quand le joueur trouve toutes les lettres du mot à deviner (quand le mot caché est égal au mot à deviner)
- La défaite arrive quand le joueur n'a plus d'essai possible pour deviner des lettres.
11. Possibilité de rejouer une partie après la fin d'une partie.
- à la fin d'une partie, le jeu n'affiche qu'un bouton "rejouer" o* l'utilisateur peut rejouter mais le jeu ne change pas de mot, la partie dernière est encore chargée.
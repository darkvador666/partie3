package machine;

import java.awt.Color;

public enum CouleurDisponible
{
//	ROUGE,
//	VERT,
//	BLEU,
//	JAUNE;
	

	ORANGE(Color.ORANGE), 
	ROUGE(Color.RED), 
	VERT(Color.GREEN),
	BLEU(Color.BLUE),
	JAUNE(Color.YELLOW);
	
    private Color couleur;
    
    CouleurDisponible(Color couleur) {
        this.couleur = couleur;
    }
 
    public Color getCouleur() {
        return couleur;
    }
    
    /**
     * renvoie le nom de l'élément dont la couleur est celle donnée en paramètre
     * @param couleur une Color
     * @return un string
     */
    public static String getNom(Color couleur)
    {
    	String retour = "";
    	for (CouleurDisponible c : CouleurDisponible.values())
    	{
    		if (c.getCouleur() == couleur)
    			retour = c.name();
    	}
    	return retour;
    }
}

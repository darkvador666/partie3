package couleur;

/**
 * Interface présentant une méthode colorier() servant à changer la couleur
 * courante
 * 
 * @author boilleau
 *
 */
public interface IColorable
{
	/**
	 * Change la couleur de l'objet
	 */
	public void colorier(CouleurDisponible c);
}

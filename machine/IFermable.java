package machine;

/**
 * Interface présentant une méthode fermer() appelable par exemple par un
 * WindowListener pour fermer la fenêtre courante.
 * 
 * @author boilleau
 *
 */
public interface IFermable
{
	/**
	 * Doit effectuer la fermeture de l'objet
	 */
	public void fermer();
}

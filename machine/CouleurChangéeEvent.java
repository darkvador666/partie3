package machine;

@SuppressWarnings(
{ "serial" })
public class CouleurChangéeEvent extends java.util.EventObject
{
	private CouleurDisponible couleur; // une couleur

	public CouleurChangéeEvent(Object source, CouleurDisponible couleur)
	{
		super(source);
	}

	/**
	 * Constructeur sans couleur
	 */
	public CouleurChangéeEvent(Object source)
	{
		// appel du constructeur à couleur, avec par défaut le blanc
		this(source, CouleurDisponible.VERT);
	}
	
	/**
	 * Affecte la couleur donnée en paramètre
	 */
	public void setCouleur(CouleurDisponible couleur)
	{
		this.couleur = couleur;
	}

	/**
	 * renvoie la couleur
	 */
	public CouleurDisponible getCouleur()
	{
		return this.couleur;
	}
}

package couleur;

@SuppressWarnings({ "unused" })
public class CouleurChangéeÉcouteur implements CouleurChangéeEventListener
{
	private IColorable cible; // la cible à qui on envoie les ordres
	
	/**
	 * Constructeur
	 */
	public CouleurChangéeÉcouteur(IColorable elem)
	{
		this.cible = elem;
	}
	
	/**
	 * 
	 */
	@Override
	public void traiter(CouleurChangéeEvent e)
	{
		this.cible.colorier(e.getCouleur());
	}

}

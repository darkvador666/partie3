package couleur;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({ "unused" })
public class Couleur
{
	private CouleurDisponible couleur; // la couleur
	
	/**
	 * Constructeur
	 */
	public Couleur(CouleurDisponible c)
	{
		this.setCouleur(c);
	}
	
	/**
	 * Affecte à couleur la couleur donnée par son nom
	 * et émet un événement CouleurChangée
	 * @params nomCouleurDispo un nom de CouleurDisponible
	 */
	public void setCouleur(String nomCouleurDispo)
	{
		// on récupère la CouleurDisponible correspondant à ce nom
		// et on appelle le setteur adéquat
		CouleurDisponible c = CouleurDisponible.valueOf(nomCouleurDispo);
		this.setCouleur(c);
	}
	
	/**
	 * Affecte à couleur la couleur donnée
	 * et émet un événement CouleurChangée
	 * @params c une CouleurDisponible
	 */
	public void setCouleur(CouleurDisponible c)
	{
		// affectation de la couleur
		this.couleur = c;
		
		// création et émission d'un événement CouleurChangéeEvent
		CouleurChangéeEvent ce = new CouleurChangéeEvent(this);
		ce.setCouleur(c);
		this.fireCouleurChangéeEvent(ce);
	}
	
	/**
	 * IMPLÉMENTATION D'UN DÉCLENCHEMENT D'ÉVÉNEMENT
	 */
	
	/**
	 * Liste de listeners pour l'événement CouleurChangéeEvent
	 */
	private List<CouleurChangéeEventListener> maliste = new ArrayList<CouleurChangéeEventListener>();

	/**
	 * ajout d'un listener
	 * 
	 * @param l
	 */
	public void addCouleurChangéeEventListener(CouleurChangéeEventListener l)
	{
		maliste.add(l);
	}

	/**
	 * suppression d'un listener
	 * 
	 * @param l
	 */
	public void removeCouleurChangéeEventListener(CouleurChangéeEventListener l)
	{
		maliste.remove(l);
	}

	/**
	 * envoi d'un événement à tous les listeners
	 * 
	 * @param e
	 */
	protected void fireCouleurChangéeEvent(CouleurChangéeEvent e)
	{
		for (CouleurChangéeEventListener ecouteur : maliste)
		{
			ecouteur.traiter(e);
		}
	}
}

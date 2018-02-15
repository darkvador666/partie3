package machine;

import java.awt.Color;
import java.awt.Component;
import java.awt.Event;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({ "serial", "unused" })
public abstract class ColorPanel extends Panel implements IColorable
{
	/**
	 * Constructeur
	 */
	public ColorPanel()
	{
		super();
	}
	
	/**
	 * Change la couleur du panneau et
	 * de tous ses composants
	 * @param couleur 
	 */
	@Override
	public void setBackground(Color couleur)
	{
		super.setBackground(couleur);
		for (Component c : this.getComponents())
		{
			c.setBackground(couleur);
		}
		
		this.selectComposantCorrespondant(couleur);
	}
	
	/**
	 * choisit le composant correspondant à la couleur donnée
	 */
	abstract protected void selectComposantCorrespondant(Color couleur);

	/**
	 * Abonne les composants à l'écouteur donné
	 * @params 
	 */
	abstract public void abonnerComposants(ActionUtilisateurÉcouteur écouteur);
	
	/**
	 * Affecte la couleur donnée
	 */
	public void colorier(CouleurDisponible c)
	{
		this.setBackground(c.getCouleur());
	}
}

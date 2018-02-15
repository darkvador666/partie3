package machine;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

@SuppressWarnings(
{ "serial", "unused" })
public class PanelRadio extends ColorPanel 
{
	// groupe, nécessaire pour que nos checkbox deviennent des radiobuttons
	private CheckboxGroup radioGroup;

	/**
	 * Constructeur
	 */
	public PanelRadio()
	{
		super();

		// le layout
		this.setLayout(new GridLayout(CouleurDisponible.values().length, 1, 10, 10));

		// le groupe
		this.radioGroup = new CheckboxGroup();

		// instanciation et ajout des boutons radio
		for (CouleurDisponible c : CouleurDisponible.values() )
		{
			// on crée autant de cb que de couleurs existantes, et 
			// on donne à chacune le nom de la couleur
			Checkbox cb = new Checkbox(c.name(), this.radioGroup, true);
			this.add(cb);
		}

	}
	
	/**
	 * coche la case correspondant à la couleur donnée
	 * @param couleur une Color
	 */
	protected void selectComposantCorrespondant(Color couleur)
	{
		// récupère le nom de la Couleur correspondant à la Color donnée, et
		// select la checkbox dont le label est cette Couleur
		this.radioGroup.setSelectedCheckbox(this.getChecboxByLabel(CouleurDisponible.getNom(couleur))); 
	}
	
	/**
	 * Renvoie la checkbox dont le label est le sring donné
	 * @params label un string
	 */
	private Checkbox getChecboxByLabel(String label)
	{
		Checkbox retour = null;
		for (Component c : this.getComponents())
		{
			if (((Checkbox)c).getLabel() == label)
			{
				retour = (Checkbox)c;
			}
		}
		return retour;
	}

	/**
	 * abonne les radiobuttons au listener donné en paramètre
	 * 
	 * @param écouteur
	 *            un ActionListener
	 */
	@Override
	public void abonnerComposants(ActionUtilisateurÉcouteur écouteur)
	{
		for (Component c : this.getComponents())
		{
			try
			{
				((Checkbox) c).addItemListener(écouteur);
			}
			catch (Exception e)
			{
				e.printStackTrace();
				System.out.println("souci à l'abonnement des composants au listener");
			}
		}
	}

}

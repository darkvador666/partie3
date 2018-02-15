package machine;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Event;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.util.EventObject;

@SuppressWarnings(
{ "serial", "unused" })
public class PanelBouton extends ColorPanel
{
	/**
	 * Constructeur
	 */
	public PanelBouton()
	{
		super();

		// le layout
		this.setLayout(new GridLayout(CouleurDisponible.values().length, 1, 10, 10));

		// instanciation et ajout des boutons
		for (CouleurDisponible c : CouleurDisponible.values() )
		{
			Button b = new Button(c.name());
			b.setActionCommand(c.name());
			this.add(b);
		}

	}

	/**
	 * abonne les composants au listener donné en paramètre
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
				((Button) c).addActionListener(écouteur);

			}
			catch (Exception e)
			{
				e.printStackTrace();
				System.out.println("souci à l'abonnement des composants au listener");
			}
		}
	}

	/**
	 * à laisser vide, inutile ici
	 */
	@Override
	protected void selectComposantCorrespondant(Color couleur)
	{
		// Auto-generated method stub
	}
}

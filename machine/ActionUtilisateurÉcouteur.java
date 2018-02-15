package machine;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

@SuppressWarnings({ "unused" })
public class ActionUtilisateurÉcouteur implements ActionListener, ItemListener, TextListener
{
	private Couleur cible; // la cible à qui on envoie les ordres

	/**
	 * Constructeur
	 */
	public ActionUtilisateurÉcouteur(Couleur c)
	{
		this.cible = c;
	}

	/**
	 * Sur clic d'un des boutons
	 * 
	 * @param arg0
	 *            l'événement reçu
	 */
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		this.cible.setCouleur(((Button)arg0.getSource()).getActionCommand());
	}

	/**
	 * Sur changement d'item dans la liste déroulante ou le checkboxgroup
	 * 
	 * @params arg0 l'événement reçu
	 */
	@Override
	public void itemStateChanged(ItemEvent arg0)
	{
		// demande au panneau cible de créer un événement de couleur changée,
		// avec comme couleur le texte de l'item
		this.cible.setCouleur(arg0.getItem().toString());
	}

	/**
	 * Sur changement de texte
	 * @param arg0 l'événement reçu
	 */
	@Override
	public void textValueChanged(TextEvent arg0)
	{
		// à faire : ajouter un bouton à côté du textarea pour soumettre le texte
		// TODO
		
		// ça là en-dessous c'est de la merde
//		this.cible.créerCouleurChangéeEvent(arg0.toString());
//		System.out.println(arg0.toString());
	}

}

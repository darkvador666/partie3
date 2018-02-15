package machine;

import java.awt.Choice;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;

@SuppressWarnings(
{ "serial", "unused" })
public class PanelDivers extends ColorPanel
{
	private final static String DÉBUTLABEL = "Couleur courante : ";
	private Label labelSaisie; // label attaché à la textarea, invitant à la saisise
	private TextArea texte; // textarea pour saisir une couleur
	private Label labelAffichage; // label pour affichage de la couleur en cours
	private Choice listeDéroulante; // liste déroulante

	/**
	 * Constructeur
	 */
	public PanelDivers()
	{
		super();
		
		// le layout
		this.setLayout(new GridLayout(3, 1, 10, 10));
		
		// panneau de saisie
		Panel panneauSaisie = new Panel();
		panneauSaisie.setLayout(new GridLayout(2, 1, 1, 1));

		this.labelSaisie = new Label("Saisie :");
		this.texte = new TextArea();

		panneauSaisie.add(this.labelSaisie);
		panneauSaisie.add(this.texte);

		// panneau d'affichage
		Panel panneauAffichage = new Panel();
		panneauAffichage.setLayout(new GridLayout(1, 1, 1, 1));
		this.labelAffichage = new Label(DÉBUTLABEL);
		panneauAffichage.add(this.labelAffichage);

		// panneau de liste
		Panel panneauListe = new Panel();
		this.listeDéroulante = new Choice();
		
		// pour chaque couleur disponible 
		// on crée un item dans la liste
		for (CouleurDisponible c : CouleurDisponible.values())
		{
			this.listeDéroulante.add(c.name());
		}
		panneauListe.add(this.listeDéroulante);

		// ajout des panneaux
		this.add(panneauSaisie);
		this.add(panneauAffichage);
		this.add(panneauListe);
	}

	/**
	 * abonne la liste au listener donné
	 * 
	 * @param écouteur
	 *            un ItemListener
	 */
	@Override
	public void abonnerComposants(ActionUtilisateurÉcouteur écouteur)
	{
		this.listeDéroulante.addItemListener(écouteur);
		this.texte.addTextListener(écouteur);
	}

	/**
	 * Choisit dans la liste déroulante l'item correspondant à la couleur donnée
	 * et affecte également au label d'affichage la couleur donnée
	 * 
	 * @param couleur
	 *            Color
	 */
	@Override
	protected void selectComposantCorrespondant(Color couleur)
	{
		this.listeDéroulante.select(CouleurDisponible.getNom(couleur));
		this.labelAffichage.setText(DÉBUTLABEL + CouleurDisponible.getNom(couleur));
		this.texte.setText(CouleurDisponible.getNom(couleur));
	}


}

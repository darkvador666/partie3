package machine;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings({ "serial", "unused" })
public class Fenêtre extends Frame implements IFermable
{
	private PanelBouton panneauBouton; // le panneau contenant les boutons
	private PanelRadio panneauRadio; // panneau à boutons radio
	private PanelDivers panneauDivers; // panneau à trucs divers

	private Couleur couleur; // la couleur

	/**
	 * Constructeur
	 */
	public Fenêtre()
	{
		super();
		
		this.couleur = Couleur.getInstance();

		// titre
		this.setTitle("Ultra Fenêtre");

		// dimensionnement
		this.setBounds(500, 150, 1000, 800);

		// le layout
		this.setLayout(new GridLayout(1, 3, 10, 10));

		// instanciation des panneaux
		this.panneauBouton = new PanelBouton();
		this.panneauRadio = new PanelRadio();
		this.panneauDivers = new PanelDivers();
		this.add(this.panneauBouton);
		this.add(this.panneauRadio);
		this.add(this.panneauDivers);
		
		// abonnement des panneaux à un écouteur qui cible la couleur
		ActionUtilisateurÉcouteur aue = new ActionUtilisateurÉcouteur(this.couleur);
		this.panneauBouton.abonnerComposants(aue);
		this.panneauDivers.abonnerComposants(aue);
		this.panneauRadio.abonnerComposants(aue);
		
		// abonnement de la couleur à des écouteurs ciblant les panneaux
		// TODO : faire un seul écouteur avec une liste de cibles
		this.couleur.addCouleurChangéeEventListener(new CouleurChangéeÉcouteur(this.panneauBouton));
		this.couleur.addCouleurChangéeEventListener(new CouleurChangéeÉcouteur(this.panneauRadio));
		this.couleur.addCouleurChangéeEventListener(new CouleurChangéeÉcouteur(this.panneauDivers));

		// auto-écoute de la fenêtre, juste
		// pour le bouton fermer
		this.addWindowListener(new WindowÉcouteur(this));

		this.setVisible(true);
	}

	/**
	 * Fermeture de la fenêtre
	 */
	@Override
	public void fermer()
	{
		System.exit(0);
	}

}

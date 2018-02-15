package machine;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


@SuppressWarnings({ "unused" })
public class WindowÉcouteur implements WindowListener
{
	private IFermable cible; // l'objet à qui on envoie les ordres

	/**
	 * Constructeur
	 */
	public WindowÉcouteur(IFermable f)
	{
		this.cible = f;
	}

	/**
	 * Sur clic sur le bouton fermer
	 */
	@Override
	public void windowClosing(WindowEvent e)
	{
		this.cible.fermer();
	}

	@Override
	public void windowActivated(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

}

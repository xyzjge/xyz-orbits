package ar.com.xyz.orbits;

import ar.com.xyz.gameengine.AbstractGameState;
import ar.com.xyz.gameengine.util.MenuItem;

public class EjemploUnoMenuItem extends MenuItem {

	public static EjemploUnoMenuItem getInstance() { return ejemploUnoMenuItem ; }
	
	private static final EjemploUnoMenuItem ejemploUnoMenuItem = new EjemploUnoMenuItem() ;
	
	private static final EjemploUnoGameState ejemploUnoGameState = new EjemploUnoGameState() ;

	public EjemploUnoMenuItem() {
		setText("UNO");
	}

	@Override
	public AbstractGameState getGameStateInstance() {
		return ejemploUnoGameState;
	}

}

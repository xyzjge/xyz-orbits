package ar.com.xyz.orbits;

import ar.com.xyz.gameengine.AbstractGameState;
import ar.com.xyz.gameengine.util.MenuItem;

public class EjemploDosMenuItem extends MenuItem {

	public static EjemploDosMenuItem getInstance() { return ejemploDosMenuItem ; }
	
	private static final EjemploDosMenuItem ejemploDosMenuItem = new EjemploDosMenuItem() ;
	
	private static final EjemploDosGameState ejemploDosGameState = new EjemploDosGameState() ;

	public EjemploDosMenuItem() {
		setText("DOS");
	}

	@Override
	public AbstractGameState getGameStateInstance() {
		return ejemploDosGameState;
	}

}

package ar.com.xyz.orbits;

import ar.com.xyz.gameengine.AbstractGameState;
import ar.com.xyz.gameengine.util.MenuItem;

public class OrbitsMenuMenuItem extends MenuItem {

	public static OrbitsMenuMenuItem getInstance() { return orbitsMenuMenuItem ; }
	
	private static final OrbitsMenuMenuItem orbitsMenuMenuItem = new OrbitsMenuMenuItem() ;
	
	private static final OrbitsMenuGameState orbitsMenuGameState = new OrbitsMenuGameState("ZIPCLOSE.wav", "black.png") ;
	
	public OrbitsMenuMenuItem() {
		setText("MENU PRINCIPAL");
	}

	@Override
	public AbstractGameState getGameStateInstance() {
		return orbitsMenuGameState ;
	}

}

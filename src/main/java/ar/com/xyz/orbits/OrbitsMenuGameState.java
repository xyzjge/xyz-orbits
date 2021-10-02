package ar.com.xyz.orbits;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;

import ar.com.xyz.gameengine.input.manager.EventOriginEnum;
import ar.com.xyz.gameengine.util.AbstractMenuItemBasedMenuGameState;
import ar.com.xyz.gameengine.util.FontSpec;
import ar.com.xyz.gameengine.util.MenuItem;
import ar.com.xyz.orbits.one.EjemploUnoMenuItem;
import ar.com.xyz.orbits.two.EjemploDosMenuItem;

public class OrbitsMenuGameState extends AbstractMenuItemBasedMenuGameState {

	private static FontSpec normalFontSpec = new FontSpec("arial", 2f, new Vector3f(.5f, .5f, .5f));
	private static FontSpec seleccionadoFontSpec = new FontSpec("arial", 2f, new Vector3f(1f, 1f, 1f));
	
	public OrbitsMenuGameState(String sound, String background) {
		super(normalFontSpec, seleccionadoFontSpec, sound, background, 0.05f, "EXIT", EventOriginEnum.MOUSE) ;
	}

	private List<MenuItem> menuItemList = new ArrayList<MenuItem>() ;

	@Override
	protected List<MenuItem> getMenuItemList() {
		if (menuItemList.size() == 0) {
			menuItemList.add(EjemploUnoMenuItem.getInstance());
			menuItemList.add(EjemploDosMenuItem.getInstance());
		}
		return menuItemList;
	}

	@Override
	public void tick() {
		
	}
	
}

package ar.com.xyz.orbits;

import ar.com.xyz.gameengine.AbstractMainGameLoop;
import ar.com.xyz.gameengine.audio.AudioMaster;
import ar.com.xyz.gameengine.singleton.SingletonManager;
// import ar.com.xyz.simpledemo.gamestate.menuitem.SimpleDemoMenuMenuItem;
//import ar.com.xyz.simpledemo.gamestate.SimpleDemoMenuGameState;

public class XYZOrbitsMainGameLoop extends AbstractMainGameLoop {

//	private static final int WIDTH = 800 ;
//	private static final int HEIGHT = 600 ;
	
	private static final int WIDTH = 1280 ;
	private static final int HEIGHT = 720 ;
	// private static final int HEIGHT = 1280 ;
	
	private static final boolean FULL_SCREEN = false;
	
	public XYZOrbitsMainGameLoop(String title) {
		super(title, WIDTH, HEIGHT, FULL_SCREEN) ;
	}

	public static void main(String[] args) {
		SingletonManager.getInstance().getTextureManager().addTexturePath("/texture");
		SingletonManager.getInstance().getTextureManager().addTexturePath("/textures");
		SingletonManager.getInstance().getTextureManager().addTexturePath("/textures/heightmaps");
		
		// TODO: SingletonManager.getInstance().get ...
		AudioMaster.addSoundPath("/sounds") ;
		XYZOrbitsMainGameLoop mainGameLoop = new XYZOrbitsMainGameLoop("Orbits - XYZ Java Game Engine") ;
		// mainGameLoop.setNextGameState(new XYZDemoLevelGameState(mainGameLoop));
		// mainGameLoop.setNextGameState(new SimpleDemoMenuGameState(mainGameLoop, "ZIPCLOSE.wav", "stone.png")) ;
		mainGameLoop.setNextGameState(OrbitsMenuMenuItem.getInstance().getGameStateInstance()) ;
		mainGameLoop.loop();
	}

}

package ar.com.xyz.orbits;

import ar.com.xyz.gameengine.AbstractGameState;

/**
 * Un control que ocupe toda la pantalla y que detecte mouse over y click
 * @author alfredo
 *
 */
public class EjemploUnoGameState extends AbstractGameState {
	
	private static final float RED = 0.5f ;
	private static final float GREEN = 0.5f ;
	private static final float BLUE = 0.5f ;
	
	public EjemploUnoGameState() {
		
//		grabMouseIfNotGrabbed() ;
		
		getDefaultColor().x = RED ;
		getDefaultColor().y = GREEN ;
		getDefaultColor().z = BLUE ;
		
	}
	
	@Override
	public void tick(float tpf) {
		
	}
	
}

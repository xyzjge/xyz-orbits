package ar.com.xyz.orbits;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

import ar.com.xyz.gameengine.AbstractGameState;
import ar.com.xyz.gameengine.entity.spec.EntitySpec;
import ar.com.xyz.gameengine.enumerator.ColorEnum;
import ar.com.xyz.gameengine.enumerator.EntityCollisionTypeEnum;
import ar.com.xyz.gameengine.input.manager.EventOriginEnum;
import ar.com.xyz.gameengine.input.manager.EventTypeEnum;
import ar.com.xyz.gameengine.input.manager.InputEventListener;
import ar.com.xyz.gameengine.singleton.SingletonManager;

/**
 * Un control que ocupe toda la pantalla y que detecte mouse over y click
 * @author alfredo
 *
 */
public class EjemploUnoGameState extends AbstractGameState implements InputEventListener {
	
	private static final float RED = 0.5f ;
	private static final float GREEN = 0.5f ;
	private static final float BLUE = 0.5f ;
	
	public EjemploUnoGameState() {
		
		grabMouseIfNotGrabbed() ;
		
		getDefaultColor().x = RED ;
		getDefaultColor().y = GREEN ;
		getDefaultColor().z = BLUE ;
		
		{
			EntitySpec entitySpec = new EntitySpec("esfera") ;
			entitySpec.setTexture(ColorEnum.RED.getName());
			entitySpec.setPosition(new Vector3f(0, 0, 0));
//			entitySpec.setWireframe(false);
			entitySpec.setEntityCollisionType(EntityCollisionTypeEnum.NONE);
//			entitySpec.setScale(new Vector3f(.1f,.1f,.1f));
//			entitySpec.setEntityController(xEntityController);
			createEntity(entitySpec);
		}
		
		setupPlayerAndCamera();
	}
	
	@Override
	public void attachedToMainLoop() {
		super.attachedToMainLoop();
		if (getInputManager().getNumberOfConfiguredInputEventListener() == 0) {
			setupInputEventListeners(getMainGameLoop(), getPlayer(), null) ;
			addInputEventListener(this) ;
		}
	}
	
	///////////////////////////
	@Override
	public boolean handleEvent(EventOriginEnum origin, EventTypeEnum type, int keyOrButton, boolean isRepeatEvent) {
		switch (keyOrButton) {
		case Keyboard.KEY_G: {
		}
		break;
		case Keyboard.KEY_1:
		default:
			break;
		}
		return false;
		
	}

	@Override
	public boolean accept(EventOriginEnum origin, EventTypeEnum type, int keyOrButton, boolean isRepeatEvent) {
		if (origin == EventOriginEnum.KEYBOARD) {
			return true ;
		}
		return false;
	}

	@Override
	public void tick() {
		
	}
	////////////////////////////
	@Override
	public void tick(float tpf) {
		
	}
	
	private void setupPlayerAndCamera() {

		setupPlayerAndCamera(
			new Vector3f(-6, 10, -21),
			new Vector3f(0, 0, 0), // new Vector3f(0, 0, 0),
			new Vector3f(1, 1, 1),
			false,
			new Vector3f(.5f, 1f, .5f),
			new Vector3f(.5f, .5f, .5f), null, true,
			null, true
		) ;

		// getCamera().decPitch(-90);
		
//		getPlayer().setCrushHandler(this);
		
//		SingletonManager.getInstance().getEntityUtil().lookAt(getPlayer(), new Vector3f(0, 0, 0));
		
		Vector3f lookAt = SingletonManager.getInstance().getEntityUtil().lookAt3d(getCamera().getCameraController().getPosition(), new Vector3f(0, 0, 0));
		
		System.out.println("lookAt: " + lookAt);
		
/*		getCamera().getCameraController().getRotation().x = -lookAt.x ;
		getCamera().getCameraController().getRotation().y = lookAt.y ;
		getCamera().getCameraController().getRotation().z = lookAt.z ;*/

		this.enableDebug(getPlayer());
		
		getPlayer().setGravity(0);
		
		enableDebugKeys();
	}
}

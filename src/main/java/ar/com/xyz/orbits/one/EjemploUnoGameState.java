package ar.com.xyz.orbits.one;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

import ar.com.xyz.gameengine.AbstractGameState;
import ar.com.xyz.gameengine.cameracontroller.LookAtEntityCameraController;
import ar.com.xyz.gameengine.cameracontroller.ShipCameraController;
import ar.com.xyz.gameengine.entity.spec.EntitySpec;
import ar.com.xyz.gameengine.enumerator.ColorEnum;
import ar.com.xyz.gameengine.enumerator.EntityCollisionTypeEnum;
import ar.com.xyz.gameengine.input.manager.EventOriginEnum;
import ar.com.xyz.gameengine.input.manager.InputEvent;
import ar.com.xyz.gameengine.input.manager.InputEventListener;

/**
 * En https://www.youtube.com/watch?v=73nvOjR8BqA dice que la velocidad de escape es la raiz cuadrada de 2G *(M/R).
 * Probarlo en la simulacion
 * @author alfredo
 *
 */
public class EjemploUnoGameState extends AbstractGameState implements InputEventListener {
	
	private static final float RED = 0 ; // 0.5f ;
	private static final float GREEN = 0 ; // 0.5f ;
	private static final float BLUE = 0 ; // 0.5f ;
	
	EarthEntityController earthEntityController = new EarthEntityController() ;
	
	public EjemploUnoGameState() {
		
		grabMouseIfNotGrabbed() ;
		
		getDefaultColor().x = RED ;
		getDefaultColor().y = GREEN ;
		getDefaultColor().z = BLUE ;
		
		{	// Sun
			EntitySpec entitySpec = new EntitySpec("esfera") ;
			entitySpec.setTexture(ColorEnum.RED.getName());
			entitySpec.setPosition(new Vector3f(0, 0, 0));
			entitySpec.setWireframe(true);
			entitySpec.setEntityCollisionType(EntityCollisionTypeEnum.NONE);
			createEntity(entitySpec);
		}
		
		{	// Plano orbital (ponele)
			EntitySpec entitySpec = new EntitySpec("esfera") ;
			entitySpec.setTexture(ColorEnum.WHITE.getName());
//			entitySpec.setColour(ColorEnum.WHITE.getColor());
			entitySpec.setPosition(new Vector3f(0, 0, 0));
			entitySpec.setWireframe(true);
			entitySpec.setScale(new Vector3f(16f,.01f,16f));
			entitySpec.setEntityCollisionType(EntityCollisionTypeEnum.NONE);
			createEntity(entitySpec);
		}
		
		{	// Planeta que orbita
			EntitySpec entitySpec = new EntitySpec("esfera") ;
			entitySpec.setTexture(ColorEnum.GREEN.getName());
			entitySpec.setPosition(new Vector3f(10, 0, 10));
//			entitySpec.setWireframe(false);
			entitySpec.setEntityCollisionType(EntityCollisionTypeEnum.NONE);
//			entitySpec.setScale(new Vector3f(.1f,.1f,.1f));
			entitySpec.setEntityController(earthEntityController);
			createEntity(entitySpec);
		}
		
		setCameraController(new LookAtEntityCameraController(new Vector3f(25,10,25), earthEntityController.getEntity()));
		
		setCameraController(new ShipCameraController(new Vector3f(3,1,3), new Vector3f(0,-10,0))) ;

	}
	
	@Override
	public void attachedToMainLoop() {
		super.attachedToMainLoop();
		if (getInputManager().getNumberOfConfiguredInputEventListener() == 0) {
//			TODO: mejorar esto ... ( setupInputEventListeners )
//			setupInputEventListeners(getMainGameLoop(), getPlayer(), null) ;
			addInputEventListener(this) ;
			addInputEventListener((InputEventListener)getCamera().getCameraController());
		}
	}
	
	///////////////////////////
	@Override
	public boolean handleEvent(InputEvent inputEvent) {
		switch (inputEvent.getEventKeyOrButton()) {
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
	public boolean accept(InputEvent inputEvent) {
		if (inputEvent.getOrigin() == EventOriginEnum.KEYBOARD) {
			return true ;
		}
		return false;
	}

	////////////////////////////
	@Override
	public void tick(float tpf) {
		
	}

	@Override
	public void tickInputEventListener(float tpf) {
		// TODO Auto-generated method stub
		
	}
	
}

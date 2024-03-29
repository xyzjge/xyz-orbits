package ar.com.xyz.orbits.two;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

import ar.com.xyz.gameengine.AbstractGameState;
import ar.com.xyz.gameengine.cameracontroller.ShipCameraController;
import ar.com.xyz.gameengine.entity.spec.EntitySpec;
import ar.com.xyz.gameengine.enumerator.ColorEnum;
import ar.com.xyz.gameengine.enumerator.EntityCollisionTypeEnum;
import ar.com.xyz.gameengine.input.manager.EventOriginEnum;
import ar.com.xyz.gameengine.input.manager.InputEvent;
import ar.com.xyz.gameengine.input.manager.InputEventListener;

/**
 * En https://www.youtube.com/watch?v=73nvOjR8BqA dice que la velocidad de escape es la raiz cuadrada de 2G * (M/R).
 * Probarlo en la simulacion
 * @author alfredo
 *
 */
public class EjemploDosGameState extends AbstractGameState implements InputEventListener {
	
	public static final int DISTANCIA_LOCA = 10;
	private static final float RED = 0.1f ;
	private static final float GREEN = 0.1f ;
	private static final float BLUE = 0.1f ;
	

	Body earth ;
	BodySystem bodySystem = new BodySystem() ;
	
	public EjemploDosGameState() {
		
		grabMouseIfNotGrabbed() ;
		
		getDefaultColor().x = RED ;
		getDefaultColor().y = GREEN ;
		getDefaultColor().z = BLUE ;
		
		for(PlanetasEarthEnum planeta : PlanetasEarthEnum.values()) {
			EntitySpec entitySpec = new EntitySpec("esfera") ;
			entitySpec.setId(planeta.name());
			entitySpec.setTexture(ColorEnum.RED.getName());
			System.out.println(planeta);
			System.out.println("semieje mayor: " + planeta.getSemiejeMayorEnUnidadesTerrestres());
			entitySpec.setPosition(new Vector3f(planeta.getSemiejeMayorEnUnidadesTerrestres() * DISTANCIA_LOCA, 0, 0));
			entitySpec.setWireframe(true);
			entitySpec.setEntityCollisionType(EntityCollisionTypeEnum.NONE);
			
			System.out.println("velocidad en perihelio: " + planeta.getVelocidadPerihelioEnUnidadesTerrestres());
			System.out.println("masa: " + planeta.getMasaEnUnidadesTerrestres());
			Body body ;
			if (planeta == PlanetasEarthEnum.SOL) {
				body = new Body(
					new Vector3f(0, 0, 0),
					new Vector3f(),
					planeta.getMasaEnUnidadesTerrestres(),
					true
				) ;
			} else {
				body = new Body(
					new Vector3f(0, 0, planeta.getVelocidadPerihelioEnUnidadesTerrestres() * 10), 
					new Vector3f(),
					planeta.getMasaEnUnidadesTerrestres()
				) ;
			}
			entitySpec.setEntityController(body);
			
			createEntity(entitySpec);
			bodySystem.add(body);
			
			if (planeta == PlanetasEarthEnum.TIERRA) {
				earth = body ;
			}
		}
/*
		{	// Sun
			
			EntitySpec entitySpec = new EntitySpec("esfera") ;
			entitySpec.setTexture(ColorEnum.RED.getName());
			entitySpec.setPosition(new Vector3f(0, 0, 0));
			entitySpec.setWireframe(true);
			entitySpec.setEntityCollisionType(EntityCollisionTypeEnum.NONE);
			
			Body body = new Body(new Vector3f(0, 0, 0), new Vector3f(), ((float)(1.98e+30 / PlanetasEarthEnum.TIERRA.getMasa())) / 1000000f, true) ;
			entitySpec.setEntityController(body);
			
			createEntity(entitySpec);
			bodySystem.add(body);
			
//			EntitySpec entitySpec = new EntitySpec("esfera") ;
//			entitySpec.setTexture(ColorEnum.RED.getName());
//			entitySpec.setPosition(new Vector3f(0, 0, 0));
//			entitySpec.setWireframe(true);
//			entitySpec.setEntityCollisionType(EntityCollisionTypeEnum.NONE);
//			createEntity(entitySpec);
		}
*/
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
 
/*		{
			EntitySpec entitySpec = new EntitySpec("esfera") ;
			entitySpec.setTexture(ColorEnum.RED.getName());
			entitySpec.setPosition(new Vector3f(0, -1, 0));
			entitySpec.setWireframe(true);
			entitySpec.setEntityCollisionType(EntityCollisionTypeEnum.NONE);
			createEntity(entitySpec);
		}*/
		
		setCameraController(new ShipCameraController(new Vector3f(3,1,3), new Vector3f(0,-10,0))) ;
	}
	
	@Override
	public void attachedToMainLoop() {
		super.attachedToMainLoop();
		if (getInputManager().getNumberOfConfiguredInputEventListener() == 0) {
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
		bodySystem.update(tpf);
		System.out.println("position: " + earth.getEntity().getPosition());
	}

	@Override
	public void tickInputEventListener(float tpf) {
		// TODO Auto-generated method stub
		
	}
	
}

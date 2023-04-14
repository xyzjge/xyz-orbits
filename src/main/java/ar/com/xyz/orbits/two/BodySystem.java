package ar.com.xyz.orbits.two;

import java.util.ArrayList;
import java.util.List;

public class BodySystem {

	private List<Body> bodyList = new ArrayList<>() ;
	
	private static final float G = .01f ;
	
	// Para particionar los calculos (TODO)
	private static final float NREPS = 10 ;

	public void add(Body body) {
		bodyList.add(body) ;
	}

	public void update(float dt) {
		for (int i = 0; i < NREPS; i++)
			this.updateOnce(dt / NREPS);
	}
	
	private void updateOnce(float dt) {
		// set all accelerations to zero
//		this.bodies[i].ax = this.bodies[i].ay = 0;
		for (Body body : bodyList) {
			body.clearAcceleration() ;
		}
		// calculate accelerations for pairs of bodies
		for (int i = 0; i < bodyList.size(); i++)
			for (int j = i+1; j < bodyList.size(); j++)
				calcAcc(bodyList.get(i), bodyList.get(j));
		// update velocities and positions for all bodies
		for (Body body : bodyList)
			body.update2(dt);
	}

	private void calcAcc(Body body1, Body body2) {
		float dx = body2.getEntity().getPosition().x - body1.getEntity().getPosition().x; // distance x component
		float dz = body2.getEntity().getPosition().z - body1.getEntity().getPosition().z; // distance z component
		float d2 = dx * dx + dz * dz;   // squared distance
		float d = (float) Math.sqrt(d2);        // distance
		
		// d es la distancia entre ambos cuerpos
		System.out.println("Distancia entre ambos cuerpos: " + d);
		
		// Vector unitario direccion de body1 a body2
		float ux = dx / d;              // unitary vector, x comp
		float uz = dz / d;              // unitary vector
		
		
		float a1 = G * body2.getMass() / d2; // scalar acc, body 1
		float a2 = G * body1.getMass() / d2; // scalar acc, body 2
		
		System.out.println("a1: " + a1);
		System.out.println("a2: " + a2);
		
//		a1 = a1 /10 ;
//		a2 = a2 /10 ;
		
//		body1.ax +=  ux * a1;  // body 1 acc, x component
//		body1.ay +=  uy * a1;  // body 1 acc, y component
		body1.addAcceleration(ux * a1, 0, uz * a1);
//		body2.ax += -ux * a2; // body 2 acc, x component
//		body2.ay += -uy * a2; // body 2 acc, y component
		body2.addAcceleration(-ux * a2, 0, -uz * a2);
	}

}

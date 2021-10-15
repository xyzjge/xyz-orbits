package ar.com.xyz.orbits.two;

import java.util.ArrayList;
import java.util.List;

public class BodySystem {

	private List<Body> bodyList = new ArrayList<>() ;
	
	private static final float G = 1 ;
	
	// Para particionar los calculos (TODO)
	private static final float NREPS = 1 ;

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
			body.update(dt);
	}

	private void calcAcc(Body body1, Body body2) {
		float dx = body2.getPosition().x - body1.getPosition().x; // distance x component
		float dy = body2.getPosition().y - body1.getPosition().y; // distance y component
		float d2 = dx * dx + dy * dy;   // squared distance
		float d = (float) Math.sqrt(d2);        // distance
		float ux = dx / d;              // unitary vector, x comp
		float uy = dy / d;              // unitary vector
		float a1 = G * body2.getMass() / d2; // scalar acc, body 1
		float a2 = G * body1.getMass() / d2; // scalar acc, body 2
//		body1.ax +=  ux * a1;  // body 1 acc, x component
//		body1.ay +=  uy * a1;  // body 1 acc, y component
		body1.addAcceleration(ux * a1, uy * a1, 0);
//		body2.ax += -ux * a2; // body 2 acc, x component
//		body2.ay += -uy * a2; // body 2 acc, y component
		body1.addAcceleration(ux * a2, uy * a2, 0);
	}

}

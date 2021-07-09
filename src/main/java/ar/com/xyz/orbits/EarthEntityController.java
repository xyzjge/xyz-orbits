package ar.com.xyz.orbits;

import ar.com.xyz.gameengine.entity.EntityController;

public class EarthEntityController extends EntityController {

	float vx = 0 ;
//	float vy = 0.85f ;
	float vy = 1.5f ;
	
	@Override
	public void update(float tpf) {
		// TODO Auto-generated method stub
//		getEntity().increasePosition(tpf * 1, 0, 0);
		
		calcularAceleracion(tpf) ;
	}

/*	
	calcAcc(body1, body2) {
        let dx = body2.px - body1.px; // distance x component
        let dy = body2.py - body1.py; // distance y component
        let d2 = dx * dx + dy * dy;   // squared distance
        let d = Math.sqrt(d2);        // distance
        let ux = dx / d;              // unitary vector, x comp
        let uy = dy / d;              // unitary vector
        let a1 = this.G * body2.m / d2; // scalar acc, body 1
        let a2 = this.G * body1.m / d2; // scalar acc, body 2
        body1.ax += ux * a1;  // body 1 acc, x component
        body1.ay += uy * a1;  // body 1 acc, y component
        body2.ax += -ux * a2; // body 2 acc, x component
        body2.ay += -uy * a2; // body 2 acc, y component
    }
*/
/*
	   update(dt) {
	        this.vx += this.ax * dt;  // acceleration affects...
	        this.vy += this.ay * dt;  // ...velocity;
	        this.px += this.vx * dt;  // velocity affects...
	        this.py += this.vy * dt;  // ...position
	    }
*/
	private void calcularAceleracion(float tpf) {
		// El "sol" está en 000
		float dx = getEntity().getPosition().x ;
		float dy = getEntity().getPosition().z ;
		float d2 = dx * dx + dy * dy;   // squared distance
		float d = (float) Math.sqrt(d2);        // distance
		float ux = dx / d;              // unitary vector, x comp
		float uy = dy / d;              // unitary vector, y comp
		
		float a1 = 1 /* this.G */* 0.000001f /*body2.m*/ / d2; // scalar acc, body 1
		float a2 = 1 /* this.G */ * 100f /* body1.m*/ / d2; // scalar acc, body 2
		
		float ax = -ux * a2; // body 2 acc, x component
		float ay = -uy * a2; // body 2 acc, y component

		float dt = tpf ;
		vx += ax * dt;  // acceleration affects...
		vy += ay * dt;  // ...velocity;
		
		getEntity().increasePosition(vx * dt, 0, vy*dt);
//        this.px += this.vx * dt;  // velocity affects...
//        this.py += this.vy * dt;  // ...position
	}
}

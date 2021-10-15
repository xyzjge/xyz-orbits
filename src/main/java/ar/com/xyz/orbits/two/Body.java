package ar.com.xyz.orbits.two;

import org.lwjgl.util.vector.Vector3f;

import ar.com.xyz.gameengine.enumerator.ColorEnum;

public class Body {

//	this.px = this.py = 0; // position
	private Vector3f position ;
	
//	this.vx = this.vy = 0; // velocity
	private Vector3f velocity ;
	
//	this.ax = this.ay = 0; // acceleration
	private Vector3f acceleration ;
	
//	this.m = 1;            // mass
	private float mass ;
	
//	this.r = 0.1;          // radius
	private float radius ;
	
//	this.color = 'white';  // color
	private ColorEnum color ;

//	this.fixed = false;    // if true, don't update position (for non-heavy suns)
	private boolean fixed = false ;

//	this.trail = new AngularTrail();
	
	public Body(Vector3f position, Vector3f velocity, Vector3f acceleration, float mass, ColorEnum color) {
		this.position = position;
		this.velocity = velocity;
		this.acceleration = acceleration;
		this.mass = mass;
		this.color = color;
	}
	
	public Body(Vector3f position, Vector3f velocity, Vector3f acceleration, float mass, ColorEnum color, boolean fixed) {
		this.position = position;
		this.velocity = velocity;
		this.acceleration = acceleration;
		this.mass = mass;
		this.color = color;
		this.fixed = fixed ;
	}

	public Vector3f getPosition() {
		return position;
	}
	
	public void setPosition(Vector3f position) {
		this.position = position;
	}
	
	public void addPosition(float x, float y, float z) {
		this.velocity.x += x;
		this.velocity.y += y;
		this.velocity.z += z;
	}
	
	public Vector3f getVelocity() {
		return velocity;
	}
	
	public void setVelocity(Vector3f velocity) {
		this.velocity = velocity;
	}
	
	public void addVelocity(float x, float y, float z) {
		this.velocity.x += x;
		this.velocity.y += y;
		this.velocity.z += z;
	}
	
	public Vector3f getAcceleration() {
		return acceleration;
	}
	
	public void setAcceleration(Vector3f acceleration) {
		this.acceleration = acceleration;
	}
	
	public void addAcceleration(float x, float y, float z) {
		this.acceleration.x += x;
		this.acceleration.y += y;
		this.acceleration.z += z;
	}
	
	public void clearAcceleration() {
		this.acceleration.x = 0;
		this.acceleration.y = 0;
		this.acceleration.z = 0;
	}
	
	public float getMass() {
		return mass;
	}
	
	public void setMass(float mass) {
		this.mass = mass;
	}
	
	public float getRadius() {
		return radius;
	}
	
	public void setRadius(float radius) {
		this.radius = radius;
	}
	
	public ColorEnum getColor() {
		return color;
	}
	
	public void setColor(ColorEnum color) {
		this.color = color;
	}
	
	public boolean isFixed() {
		return fixed;
	}
	
	public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}

	public void update(float dt) {
		if (this.fixed) {
			return ;
		}
//		this.vx += this.ax * dt;      // acceleration affects...
//		this.vy += this.ay * dt;      // ...velocity;
		addVelocity(acceleration.x * dt, acceleration.y * dt, acceleration.z * dt);
//		if (!this.fixed) {
//			this.px += this.vx * dt;  // velocity affects...
//			this.py += this.vy * dt;  // ...position
//			this.trail.update(this.px, this.py);
//		}
		addPosition(velocity.x * dt, velocity.y * dt, velocity.z * dt);

	}

}

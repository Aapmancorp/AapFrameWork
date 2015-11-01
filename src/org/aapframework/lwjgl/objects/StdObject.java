package org.aapframework.lwjgl.objects;

public abstract class StdObject {
	protected double x;
	protected double y;
	protected double z;
	
	public StdObject(double x, double y, double z){
		setX(x);
		setY(y);
		setZ(z);
	}
	
	public abstract void draw();

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}
}

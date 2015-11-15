package org.aapframework.lwjgl.objects;

public abstract class CollidableObject extends StdObject{

	public CollidableObject(double x, double y, double z) {
		super(x, y, z);
	}

	@Override
	public abstract void draw();
	
	public abstract boolean hasCollided(CollidableObject collidableObject);

}

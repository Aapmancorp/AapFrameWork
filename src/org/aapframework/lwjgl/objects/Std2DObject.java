package org.aapframework.lwjgl.objects;

public abstract class Std2DObject extends StdObject{

	public Std2DObject(double x, double y) {
		super(x, y, 0);
	}

	@Override
	public abstract void draw();

}

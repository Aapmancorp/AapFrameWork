package org.aapframework.lwjgl.objects;

import static org.lwjgl.opengl.GL11.*;

public class Cube extends StdObject{
	private double size;
	
	public Cube (double x, double y, double z, double size){
		super(x,y,z);
		setSize(size);
	}
	
	@Override
	public void draw() {
		double halfSize = size/2;
		
		glPushMatrix();
		
		glTranslated(x, y, z);
		
		glBegin(GL_QUADS);		
		glVertex3d(-halfSize, halfSize, halfSize);
		glVertex3d(-halfSize, -halfSize, halfSize);
		glVertex3d(halfSize, -halfSize, halfSize);
		glVertex3d(halfSize, halfSize, halfSize);		
		glEnd();
		
		glRotated(90, 0, 1, 0);
		glBegin(GL_QUADS);		
		glVertex3d(-halfSize, halfSize, halfSize);
		glVertex3d(-halfSize, -halfSize, halfSize);
		glVertex3d(halfSize, -halfSize, halfSize);
		glVertex3d(halfSize, halfSize, halfSize);		
		glEnd();
		
		glRotated(90, 0, 1, 0);
		glBegin(GL_QUADS);		
		glVertex3d(-halfSize, halfSize, halfSize);
		glVertex3d(-halfSize, -halfSize, halfSize);
		glVertex3d(halfSize, -halfSize, halfSize);
		glVertex3d(halfSize, halfSize, halfSize);		
		glEnd();
		
		glRotated(90, 0, 1, 0);
		glBegin(GL_QUADS);		
		glVertex3d(-halfSize, halfSize, halfSize);
		glVertex3d(-halfSize, -halfSize, halfSize);
		glVertex3d(halfSize, -halfSize, halfSize);
		glVertex3d(halfSize, halfSize, halfSize);		
		glEnd();
		
		glRotated(90, 0, 0, -1);
		glBegin(GL_QUADS);		
		glVertex3d(-halfSize, halfSize, halfSize);
		glVertex3d(-halfSize, -halfSize, halfSize);
		glVertex3d(halfSize, -halfSize, halfSize);
		glVertex3d(halfSize, halfSize, halfSize);		
		glEnd();
		
		glPopMatrix();
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

}

package org.aapframework.lwjgl.objects;

import static org.lwjgl.opengl.GL11.*;

public class Axis extends StdObject{
	private int length;
	
	public Axis(double x, double y, double z, int length) {
		super(x, y, z);
		this.length = length;
	}

	@Override
	public void draw() {
		glPushMatrix();
		
		glTranslated(x, y, z);
		
		glColor4f(1, 0, 0, 1);
		glLineWidth(5f);
		
		glBegin(GL_LINES);
			glVertex3d(0, 0, 0);
			glVertex3d(length,0,0);
		glEnd();
		
		glColor4f(0, 1, 0, 1);
		glBegin(GL_LINES);
			glVertex3d(0, 0, 0);
			glVertex3d(0,length,0);
		glEnd();
		
		glColor4f(0, 0, 1, 1);
		glBegin(GL_LINES);
			glVertex3d(0, 0, 0);
			glVertex3d(0,0,length);
		glEnd();
		
		glPopMatrix();
		
	}

}

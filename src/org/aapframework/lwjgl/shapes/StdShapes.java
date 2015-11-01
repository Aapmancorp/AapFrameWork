package org.aapframework.lwjgl.shapes;

import static org.lwjgl.opengl.GL11.*;

public class StdShapes {
	/**
	 * Draw A filled circle
	 * @param radius
	 * @param nElements
	 */
	public static void drawFilledCircle(double radius, int nElements){
		// Save the projection matrix
		glPushMatrix();
		
		double angle = 0;
		
		// A circle can be made using the triangle fan
		glBegin(GL_TRIANGLE_FAN);
		// First create a vertex in the center. Then one on the x-axis
			glVertex2d(0, 0);
			glVertex2d(radius,0);
		// Add points for each segment	
			for (int i = 0; i < nElements; ++i){				
				angle += 2*Math.PI/nElements;
				glVertex2d(radius*Math.cos(angle), radius*Math.sin(angle));
			}
			
		glEnd();
		
		// Restore the projection matrix
		glPopMatrix();
	}
	
	/**
	 * Draw a circle in the 2D plane
	 * @param radius Radius of the circle
	 * @param nElements Amount of straight line elements
	 * @param thickness The thickness of the line of the circle
	 */
	public static void drawLineCircle(double radius, int nElements, int thickness){
		double angle = 0;
		// Save the current projection matrix
		glPushMatrix();
		// Save the current Line properties
		glPushAttrib(GL_LINE_BIT);
		
		glLineWidth(thickness);
		glBegin(GL_LINE_LOOP);
			for (int i = 0 ; i < nElements; ++i){
				glVertex2d(radius*Math.cos(angle), radius*Math.sin(angle));
				angle += 2*Math.PI/nElements;
			}
		glEnd();
		
		// Restore the line properties
		glPopAttrib();
		// Restore the projection matrix
		glPopMatrix();
	}
}

package org.aapframwork.lwjgl;

import static org.lwjgl.opengl.GL11.*;


public class GLU {
	
    public static void gluPerspective(float fovy, float aspect, float zNear, float zFar) {

    	float f =  (float) (1f/Math.tan(Math.toRadians(fovy)/2f));
    	
    	glMultMatrixf(Util.createFloatBuffer(f/aspect, 0f, 0f, 0f,
				0f, f, 0f, 0f,
				0f, 0f, (zFar	+zNear)/(zNear-zFar), -1f,
				0f, 0f, (2f*zFar*zNear)/(zNear-zFar), 0f));
    	
    }
}

package org.test.aapframework.window;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.glfw.GLFW.glfwGetKey;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_FALSE;

import java.nio.FloatBuffer;

import static org.lwjgl.opengl.GL11.*;

import org.aapframework.logger.Logger;
import org.aapframework.lwjgl.objects.Cube;
import org.aapframework.lwjgl.window.Window;
import org.lwjgl.BufferUtils;
import org.newdawn.slick.util.Log;

public class testWindow {

	public static void main(String[] args){
		Window window = new Window(1280,720,"Test");
		double rotAngle = 0;
		double X = 0;
		Cube cube = new Cube(0, 0, 0, 1);
		Logger log = Logger.getInstance();
		
		window.drawOn3D();			
		// Cullface
		glCullFace(GL_BACK);
		glDisable(GL_CULL_FACE);
		
		//depth
		glEnable(GL_DEPTH_TEST);
		
		//
		glClearDepth(1.0f);			
		glDepthFunc(GL_LEQUAL);
		//
		glEnable(GL_LIGHT0);
		glDisable(GL_LIGHTING);
		
		
		
		while(glfwWindowShouldClose(window.getWindowID())== GL_FALSE){
			// Clear the contents of the window (try disabling this and resizing the window � fun guaranteed)
			glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);
			
			// Polls the user input. This is very important, because it prevents your application from becoming unresponsive
			glfwPollEvents();
			
			rotAngle = (glfwGetKey(window.getWindowID(), GLFW_KEY_RIGHT) == 1) ? rotAngle+5 : rotAngle;
			rotAngle = (glfwGetKey(window.getWindowID(), GLFW_KEY_LEFT) == 1) ? rotAngle-5 : rotAngle;
			
			X = (glfwGetKey(window.getWindowID(), GLFW_KEY_UP) == 1) ? X+.5 : X;
			X = (glfwGetKey(window.getWindowID(), GLFW_KEY_DOWN) == 1) ? X-.5 : X;
			
			log.debug(""+X);
			
			glPushMatrix();
			glTranslated(0, 0, -40+X);
			glRotated(rotAngle, 0, 1, 0);			
			
			glColor3d(1, 1, 1);
			glBegin(GL_QUADS);
			glVertex3d(-10, 10, 0);
			glVertex3d(-10,-10,0);
			glVertex3d(10,-10,0);
			glVertex3d(10,10,0);
			glEnd();
			
			glColor4f(1, 0, 0, 1);
			glLineWidth(5f);
			glBegin(GL_LINES);
				glVertex3d(0, 0, 0);
				glVertex3d(100,100,0);
			glEnd();
			
			glColor4f(0, 1, 0, 1);
			glBegin(GL_LINES);
				glVertex3d(0, 0, 0);
				glVertex3d(0,100,0);
			glEnd();
//			
//			glRotated(rotAngle, 0, 1, 0);
			glColor3d(0, 1, 1);
			cube.draw();
			glPopMatrix();
			
			// Swaps the front and back framebuffers, this is a very technical process which you don't necessarily
			// need to understand. You can simply see this method as updating the window contents.
			glfwSwapBuffers(window.getWindowID());		
		}
		
		window.destroyWindow();
	}
	
}

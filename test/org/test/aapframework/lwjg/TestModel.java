package org.test.aapframework.lwjg;

import static org.lwjgl.glfw.GLFW.GLFW_KEY_DOWN;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_LEFT;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_RIGHT;
import static org.lwjgl.glfw.GLFW.GLFW_KEY_UP;
import static org.lwjgl.glfw.GLFW.glfwGetKey;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.opengl.GL11.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.aapframework.logger.Logger;
import org.aapframework.lwjgl.Text;
import org.aapframework.lwjgl.objects.Axis;
import org.aapframework.lwjgl.objects.Cube;
import org.aapframework.lwjgl.objects.Model;
import org.aapframework.lwjgl.window.Window;

public class TestModel {
	public static void main(String[] args) throws FileNotFoundException, IOException{
		Window window = new Window(1280,720,"Test");
		double rotAngle = 0;
		double X = 0;
		Cube cube = new Cube(0, 0, 0, 10);
		Logger log = Logger.getInstance();
		Axis axis = new Axis(0, 10, 0, 50);
		Text CONSOLAS = new Text("./res/Consolas.ttf");	
		// Load model
		Model cubeZhiLi = Model.loadModel("./res", "cubeZhiLi.obj");
		
		window.drawOn3D();			
		// Cullface
		glCullFace(GL_BACK);
		glEnable(GL_CULL_FACE);
		
		//depth
		glEnable(GL_DEPTH_TEST);
		
		//
		glClearDepth(1.0f);			
		glDepthFunc(GL_LEQUAL);
		//
		glEnable(GL_LIGHT0);
		glEnable(GL_LIGHTING);
		
		glEnable(GL_TEXTURE_2D);
		
		
		
		while(!window.isCloseRequested()){
			window.drawOn3D();
			window.clearScreen();
						
			rotAngle = (glfwGetKey(window.getWindowID(), GLFW_KEY_RIGHT) == 1) ? rotAngle+5 : rotAngle;
			rotAngle = (glfwGetKey(window.getWindowID(), GLFW_KEY_LEFT) == 1) ? rotAngle-5 : rotAngle;
			
			X = (glfwGetKey(window.getWindowID(), GLFW_KEY_UP) == 1) ? X+.5 : X;
			X = (glfwGetKey(window.getWindowID(), GLFW_KEY_DOWN) == 1) ? X-.5 : X;
			
			log.debug(""+X);
			
			glPushMatrix();
			glTranslated(0, 0, -40+X);
	
			glRotated(rotAngle, 0, 1, 0);
			glColor3d(0, 1, 1);
			cubeZhiLi.draw();
			glPushAttrib(GL_ALL_ATTRIB_BITS);
			glDisable(GL_LIGHTING);
			glDisable(GL_TEXTURE_2D);
			cube.draw();
			axis.draw();
			glPopMatrix();

			
			
			window.drawOn2D();
			glPushMatrix();
			glColor3d(.1, .1,.1);
	
			glBegin(GL_QUADS);
			glVertex2d(0, 0);	
			glVertex2d(0, 100);	
			glVertex2d(200, 100);	
			glVertex2d(200, 0);	
			glEnd();		
			
			CONSOLAS.draw(0, 0, 35, "Hello World!\n Hello World!");	
			
			glPopMatrix();
			glPopAttrib();
			
			window.updateScreen();		
		}
		
		window.destroyWindow();
	}
	
}
package org.test.aapframework.window;

import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL11.*;

import org.aapframework.lwjgl.window.Window;

public class testWindow {

	public static void main(String[] args){
		Window window = new Window(1280,720,"Test");

		while(glfwWindowShouldClose(window.getWindowID())== GL_FALSE){
			// Clear the contents of the window (try disabling this and resizing the window � fun guaranteed)
			glClear(GL_COLOR_BUFFER_BIT);
			
			// Polls the user input. This is very important, because it prevents your application from becoming unresponsive
			glfwPollEvents();
			
			// Swaps the front and back framebuffers, this is a very technical process which you don't necessarily
			// need to understand. You can simply see this method as updating the window contents.
			glfwSwapBuffers(window.getWindowID());		
		}
		
		window.destroyWindow();
	}
	
}

package org.aapframework.lwjgl.window;

import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwDestroyWindow;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapInterval;
import static org.lwjgl.glfw.GLFW.glfwTerminate;
import static org.lwjgl.opengl.GL11.GL_FALSE;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;
import static org.lwjgl.opengl.GL11.glViewport;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import org.aapframework.logger.Logger;
import org.aapframework.lwjgl.mouse.Mouse;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.system.MemoryUtil;

public class Window {
	private long windowID;
	private int windowHeight;
	private int windowWidth;
	private Mouse mouse;
	Logger log = Logger.getInstance();
	
	
	public Window(int windowWidth, int windowHeight, String windowTitle){
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;		
		
		// Initailize window
		initWindow(windowWidth, windowHeight, windowTitle);
		
		// Create mouse
		mouse = new Mouse(windowID);
	}

	public Window(String windowTitle){
		// Initialize window
		initWindow(800,600, windowTitle);
		
		// Create mouse
		mouse = new Mouse(windowID);
	}
	
	private void initWindow(int windowWidth, int windowHeight, String windowTitle){
		// Initialize GLFW:
				int glfwInitializationResult = glfwInit(); // initialize GLFW and store the result (pass or fail)
				
				// Check if initializing succeeded
				if (glfwInitializationResult == GL_FALSE){
					log.error("Initializing glfw window failed!");
					throw new IllegalStateException("GLFW initialization failed");
				}
				
				log.debug("Window succesfully initialized!");
				
				// Configure the GLFW window
				windowID = glfwCreateWindow(
					windowWidth, windowHeight,   // Width and height of the drawing canvas in pixels
					windowTitle,     // Title of the window
					MemoryUtil.NULL, // Monitor ID to use for fullscreen mode, or NULL to use windowed mode (LWJGL JavaDoc)
					MemoryUtil.NULL); // Window to share resources with, or NULL to not share resources (LWJGL JavaDoc)
				
				// Check if window creation has succeeded
				if (windowID == MemoryUtil.NULL){
					log.error("Window creation has failed!");
					throw new IllegalStateException("GLFW window creation failed");
				}
				
				// Log a message
				log.debug("Window has successfully been created!");
				
				glfwMakeContextCurrent(windowID); // Links the OpenGL context of the window to the current thread (GLFW_NO_CURRENT_CONTEXT error)
				glfwSwapInterval(1); // Enable VSync, which effective caps the frame-rate of the application to 60 frames-per-second		
				glfwShowWindow(windowID);

				// If you don't add this line, you'll get the following exception:
				//  java.lang.IllegalStateException: There is no OpenGL context current in the current thread.
				GLContext.createFromCurrent(); // Links LWJGL to the OpenGL context
								
				// Define window viewport		
				glViewport(0, 0, windowWidth, windowHeight);
				
				// Set clear color to black
				glClearColor(0,0,1,0);
				
				// setDrawing mode to 2D
				drawOn2D();
	}
	
	public void drawOn2D(){
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, windowWidth, windowHeight, 0,-1,1);
		glMatrixMode(GL_MODELVIEW);		
	}
	
	public void drawOn3D(){
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		gluPerspective(60, (float)windowWidth/windowHeight, 0.001f, 100f);
	}
	
	public void destroyWindow(){
		// It's important to release the resources when the program has finished to prevent dreadful memory leaks
		glfwDestroyWindow(windowID);
		// Destroys all remaining windows and cursors (LWJGL JavaDoc)
		glfwTerminate();
	}
	
	public void grabMouse(){
		mouse.setGrabbed();
	}
	
	public void releaseMouse(){
		mouse.setMouseFree();
	}
	
	public void grabMouseWhenOverWindow(){
		mouse.setGrabbedOnWindow();
	}
	
	public double getXScroll(){
		return mouse.getXScroll();
	}
	
	public double getYScroll(){
		return mouse.getYScroll();
	}
	
	public double getMouseX(){
		return mouse.getX();
	}
	
	public double getMouseY(){
		return mouse.getY();
	}
	
	public double getMousedY(){
		return mouse.getdY();
	}
	
	public double getMousedX(){
		return mouse.getdX();
	}

	public long getWindowID() {
		return windowID;
	}

	public void setWindowID(long windowID) {
		this.windowID = windowID;
	}

	public int getWindowHeight() {
		return windowHeight;
	}

	public void setWindowHeight(int windowHeight) {
		this.windowHeight = windowHeight;
	}

	public int getWindowWidth() {
		return windowWidth;
	}

	public void setWindowWidth(int windowWidth) {
		this.windowWidth = windowWidth;
	}

	public Mouse getMouse() {
		return mouse;
	}

	public void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}
	
}
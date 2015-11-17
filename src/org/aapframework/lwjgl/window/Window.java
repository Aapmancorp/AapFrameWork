package org.aapframework.lwjgl.window;

import static org.aapframework.lwjgl.GLU.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import org.aapframework.logger.Logger;
import org.aapframework.lwjgl.events.Keyboard;
import org.aapframework.lwjgl.events.KeyboardChar;
import org.aapframework.lwjgl.events.Mouse;
import org.lwjgl.glfw.GLFWWindowSizeCallback;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.system.MemoryUtil;

public class Window extends GLFWWindowSizeCallback{
	private long windowID;
	private int windowHeight;
	private int windowWidth;
	private Mouse mouse;
	private boolean drawOn2D;
	private Keyboard keyboard;
	private KeyboardChar keyboardChar;
	
	Logger log = Logger.getInstance();
	
	
	public Window(int windowWidth, int windowHeight, String windowTitle, boolean resizable){
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;		
		
		// Initailize window
		initWindow(windowWidth, windowHeight, windowTitle, resizable);
	}

	public Window(String windowTitle){
		this.windowWidth = 800;
		this.windowHeight = 600;		
		// Initialize window
		initWindow(windowWidth,windowHeight, windowTitle, true);
	}
	
	private void initWindow(int windowWidth, int windowHeight, String windowTitle, boolean resizable){
				// Initialize GLFW:
				int glfwInitializationResult = glfwInit(); // initialize GLFW and store the result (pass or fail)
				
				// Check if initializing succeeded
				if (glfwInitializationResult == GL_FALSE){
					log.error("Initializing glfw window failed!");
					throw new IllegalStateException("GLFW initialization failed");
				}
				
				log.debug("Window succesfully initialized!");	
				
				glfwDefaultWindowHints();
				// Set window resizable flag
		        glfwWindowHint(GLFW_RESIZABLE, (resizable? GL_TRUE : GL_FALSE)); 
				
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
				
				// Assign callback
				glfwSetWindowSizeCallback(windowID, this);
				
				glfwMakeContextCurrent(windowID); // Links the OpenGL context of the window to the current thread (GLFW_NO_CURRENT_CONTEXT error)
				glfwSwapInterval(1); // Enable VSync, which effective caps the frame-rate of the application to 60 frames-per-second		
				glfwShowWindow(windowID);

				// If you don't add this line, you'll get the following exception:
				//  java.lang.IllegalStateException: There is no OpenGL context current in the current thread.
				GLContext.createFromCurrent(); // Links LWJGL to the OpenGL context
								
				// Define window viewport		
				glViewport(0, 0, windowWidth, windowHeight);
				
				// Set clear color to black
				glClearColor(0,0,0,0);
				
				// setDrawing mode to 2D
				drawOn2D();
				
				// Create mouse
				mouse = new Mouse(windowID);
				
				//create Keyboard
				keyboard = new Keyboard(windowID);
				
				// create Keyboard char listener
				keyboardChar = new KeyboardChar(windowID);
	}
	
	public void drawOn2D(){
		drawOn2D = true;
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, windowWidth, windowHeight, 0,-1,1);
		glMatrixMode(GL_MODELVIEW);
	}
	
	public void drawOn3D(){
		drawOn2D = false;
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		gluPerspective(60, (float)windowWidth/(float)windowHeight, 0.001f, 100f);
		glMatrixMode(GL_MODELVIEW);	
	}
	
	public void destroyWindow(){
		// It's important to release the resources when the program has finished to prevent dreadful memory leaks
		glfwDestroyWindow(windowID);
		// Destroys all remaining windows and cursors (LWJGL JavaDoc)
		glfwTerminate();
	}
	
	public void clearScreen(){
		glClear(GL_COLOR_BUFFER_BIT|GL_DEPTH_BUFFER_BIT);
	}
	
	public void updateScreen(){
		// Polls the user input. This is very important, because it prevents your application from becoming unresponsive
		glfwPollEvents();
		// Swaps buffer
		glfwSwapBuffers(windowID);
	}
	
	/**
	 * Handles the window resized event. When the window is resized the viewport and projection matrix need to be
	 * adjusted as well.
	 */
	@Override
	public void invoke(long window, int width, int height) {
		if (window==windowID){
			// Set the class variables
			windowWidth  = width;
			windowHeight = height;
			
			// Define window viewport		
			glViewport(0, 0, windowWidth, windowHeight);			
			log.debug("Window has bee resized!");
			
			// Reset the projection matrix
			if (drawOn2D){
				drawOn2D();
				return;
			}
			drawOn3D();			
		}
	}
	
	public boolean isCloseRequested(){
		return glfwWindowShouldClose(windowID) == GL_TRUE;
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

	public Keyboard getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(Keyboard keyboard) {
		this.keyboard = keyboard;
	}

	public KeyboardChar getKeyboardChar() {
		return keyboardChar;
	}

	public void setKeyboardChar(KeyboardChar keyboardChar) {
		this.keyboardChar = keyboardChar;
	}
	
}

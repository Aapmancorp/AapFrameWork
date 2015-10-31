package org.aapframework.lwjgl.mouse;

import org.lwjgl.glfw.GLFWMouseButtonCallback;
import static org.lwjgl.glfw.GLFW.*;

import org.aapframework.logger.Logger;

/**
 * This class captures the mouse button events.
 * 
 * @author zl
 *
 */
public class mouseButton extends GLFWMouseButtonCallback{
	// Captures if a mouse button is down or not
	boolean[] mouseButtonStates = new boolean[8];
	
	// This is the window which the eventListener is listening to
	private long windowID;
	
	// Logger
	Logger log = Logger.getInstance();
	
	/**
	 * Initializes the call back
	 * @param windowID The window to listen to
	 */
	public mouseButton(long windowID){
		this.setWindowID(windowID);
		glfwSetMouseButtonCallback(windowID, this);
	}
	
	/**
	 * Requests the status of the button. True if it is down/pressed.
	 * @param button
	 * @return
	 */
	public boolean isButtonDown(int button){
		return mouseButtonStates[button];		
	}
	
	public long getWindowID() {
		return windowID;
	}

	public void setWindowID(long windowID) {
		this.windowID = windowID;
	}
	
	@Override
	public void invoke(long window, int button, int action, int mods) {
		if (window == windowID){
			mouseButtonStates[button] = action==1;				
		}
	}

}

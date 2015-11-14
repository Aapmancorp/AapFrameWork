package org.aapframework.lwjgl.mouse;

import org.lwjgl.glfw.GLFWMouseButtonCallback;
import static org.lwjgl.glfw.GLFW.*;

import java.util.ArrayList;

import org.aapframework.events.Observable;
import org.aapframework.events.Observer;
import org.aapframework.logger.Logger;

/**
 * This class captures the mouse button events.
 * 
 * @author zl
 *
 */
public class mouseButton extends GLFWMouseButtonCallback implements Observable{
	// Captures if a mouse button is down or not
	boolean[] mouseButtonStates = new boolean[8];
	
	// This is the window which the eventListener is listening to
	private long windowID;
	
	// Logger
	Logger log = Logger.getInstance();
	
	// Observer list
	private ArrayList<Observer> observerList;
	
	/**
	 * Initializes the call back
	 * @param windowID The window to listen to
	 */
	public mouseButton(long windowID){
		this.setWindowID(windowID);
		glfwSetMouseButtonCallback(windowID, this);
		observerList = new ArrayList<>();
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
			notifyAllObservers();
		}
	}

	@Override
	public void addObserver(Observer observer) {
		observerList.add(observer);			
	}

	@Override
	public void removeObserver(Observer observer) {
		observerList.remove(observer);			
	}

	@Override
	public void notifyAllObservers() {
		for (Observer obs:observerList){
			obs.update(this);
		}
	}

}

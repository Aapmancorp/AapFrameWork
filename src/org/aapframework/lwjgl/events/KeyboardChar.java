package org.aapframework.lwjgl.events;

import static org.lwjgl.glfw.GLFW.glfwSetCharCallback;

import java.util.ArrayList;

import org.aapframework.events.Observable;
import org.aapframework.events.Observer;
import org.aapframework.logger.Logger;
import org.lwjgl.glfw.GLFWCharCallback;

public class KeyboardChar extends GLFWCharCallback implements Observable{
	
	// This is the window which the eventListener is listening to
	private long windowID;
	
	// Logger
	Logger log = Logger.getInstance();
	
	// Observer list
	private ArrayList<Observer> observerList = new ArrayList<>();
	
	public KeyboardChar(long windowID){
		this.setWindowID(windowID);
		glfwSetCharCallback(windowID, this);
	}
	
	public long getWindowID() {
		return windowID;
	}

	public void setWindowID(long windowID) {
		this.windowID = windowID;
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

	@Override
	public void invoke(long window, int codepoint) {
		log.debug("You typed: "+codepoint);		
	}

}

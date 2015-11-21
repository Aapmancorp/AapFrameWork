package org.aapframework.lwjgl.events;

import static org.lwjgl.glfw.GLFW.glfwSetKeyCallback;

import java.util.ArrayList;

import org.aapframework.events.Observable;
import org.aapframework.events.Observer;
import org.aapframework.logger.Logger;
import org.lwjgl.glfw.GLFWKeyCallback;

public class Keyboard extends GLFWKeyCallback implements Observable{
	
	// This is the window which the eventListener is listening to
	private long windowID;
	private int eventKey;
	private int eventScanCode;
	private int eventAction;
	private int eventMods;
	
	// Logger
	Logger log = Logger.getInstance();
	
	// Observer list
	private ArrayList<Observer> observerList = new ArrayList<>();
	
	public Keyboard(long windowID){
		this.setWindowID(windowID);
		glfwSetKeyCallback(windowID, this);
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
	public void invoke(long window, int key, int scancode, int action, int mods) {
		log.debug(key+" "+scancode+" "+action+" "+mods);
		setEventKey(key);
		setEventScanCode(scancode);
		setEventAction(action);
		setEventMods(mods);
		notifyAllObservers();
	}

	public int getEventKey() {
		return eventKey;
	}

	public void setEventKey(int eventKey) {
		this.eventKey = eventKey;
	}

	public int getEventScanCode() {
		return eventScanCode;
	}

	public void setEventScanCode(int eventScanCode) {
		this.eventScanCode = eventScanCode;
	}

	public int getEventAction() {
		return eventAction;
	}

	public void setEventAction(int eventAction) {
		this.eventAction = eventAction;
	}

	public int getEventMods() {
		return eventMods;
	}

	public void setEventMods(int eventMods) {
		this.eventMods = eventMods;
	}

}

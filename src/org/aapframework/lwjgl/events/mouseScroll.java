package org.aapframework.lwjgl.events;
import org.lwjgl.glfw.GLFWScrollCallback;
import static org.lwjgl.glfw.GLFW.*;

import java.util.ArrayList;

import org.aapframework.events.Observable;
import org.aapframework.events.Observer;
import org.aapframework.logger.Logger;

public class mouseScroll extends GLFWScrollCallback implements Observable{
	
	private long windowID;
	private double xScroll, yScroll;
	Logger log = Logger.getInstance();
	private ArrayList<Observer> observerList;
	
	public mouseScroll(long windowID){
		this.setWindowID(windowID);
		glfwSetScrollCallback(windowID, this);
		observerList = new ArrayList<>();
	}
		
	public long getWindowID() {
		return windowID;
	}

	public double getxScroll() {
		double outXScroll = this.xScroll;
		this.xScroll = 0;
		return outXScroll;
	}

	public double getyScroll() {
		double outYScroll = this.yScroll;
		this.yScroll = 0;
		return outYScroll;
	}

	public void setyScroll(double yScroll) {
		this.yScroll = yScroll;
	}

	public void setxScroll(double xScroll) {
		this.xScroll = xScroll;
	}

	public void setWindowID(long windowID) {
		this.windowID = windowID;
	}

	@Override
	public void invoke(long window, double xoffset, double yoffset) {
		if (window == windowID){
			this.setxScroll(xoffset);
			this.setyScroll(yoffset);
			log.info("x-offset: "+xoffset+" y-offset: "+yoffset);
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

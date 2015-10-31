package org.aapframework.lwjgl.mouse;
import org.lwjgl.glfw.GLFWScrollCallback;
import static org.lwjgl.glfw.GLFW.*;

import org.aapframework.logger.Logger;

public class mouseScroll extends GLFWScrollCallback{
	
	private long windowID;
	private double xScroll, yScroll;
	Logger log = Logger.getInstance();
	
	public mouseScroll(long windowID){
		this.setWindowID(windowID);
		glfwSetScrollCallback(windowID, this);
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
			log.debug("x-offset: "+xoffset+" y-offset: "+yoffset);
			}		
	}

}

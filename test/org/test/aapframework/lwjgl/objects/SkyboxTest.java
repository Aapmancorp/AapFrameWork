package org.test.aapframework.lwjgl.objects;

import org.aapframework.lwjgl.objects.Axis;
import org.aapframework.lwjgl.objects.Skybox;
import org.aapframework.lwjgl.window.Window;

import java.io.IOException;
import org.aapframework.events.Observer;

import org.aapframework.lwjgl.Util;
import org.aapframework.lwjgl.events.Keyboard;
import org.lwjgl.glfw.GLFW;
import static org.lwjgl.opengl.GL11.*;

public class SkyboxTest implements Observer{
	double rotAngle = 0;
	double vertAngle = 0;
	
	public boolean start(){
		Window window = new Window(1280, 720, "SkyboxTest", false);
		window.drawOn3D();
		Skybox sahara;
		Axis axis = new Axis(-9, 0, -9, 1);
		try {
			sahara = new Skybox(Util.loadtexture("./res/skybox/sahara/north.png", false)
													, Util.loadtexture("./res/skybox/sahara/east.png", false)
													, Util.loadtexture("./res/skybox/sahara/south.png", false)
													, Util.loadtexture("./res/skybox/sahara/west.png", false)
													, Util.loadtexture("./res/skybox/sahara/up.png", false)
													, Util.loadtexture("./res/skybox/sahara/down.png", false)
													, true);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		window.getKeyboard().addObserver(this);
		
		while(!window.isCloseRequested()){
			window.clearScreen();
			glPushMatrix();
			glRotated(vertAngle, -1, 0, 0);
			glRotated(rotAngle, 0, 1, 0);
			sahara.draw();
			
			axis.draw();
			
			glPopMatrix();
			window.updateScreen();
		}
		
		
		return true;
	}
	
	
	@Override
	public void update(org.aapframework.events.Observable observable) {
		if (observable.getClass().equals(Keyboard.class)){
			Keyboard keyboard  = (Keyboard) observable;
			
			switch (keyboard.getEventKey()){
			case GLFW.GLFW_KEY_LEFT:
				rotAngle -= 1;
				break;
			case GLFW.GLFW_KEY_RIGHT:
				rotAngle += 1;
				break;
			case GLFW.GLFW_KEY_UP:
				vertAngle += 1;
				break;
			case GLFW.GLFW_KEY_DOWN:
				vertAngle -= 1;
				break;
			}
		}
		
	}
	public static void main(String[] args){
		new SkyboxTest().start();
	}
}

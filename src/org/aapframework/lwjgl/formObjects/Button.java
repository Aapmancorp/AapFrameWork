package org.aapframework.lwjgl.formObjects;

import org.aapframework.events.Mouse;
import org.aapframework.events.Observable;
import org.aapframework.events.Observer;
import org.aapframework.lwjgl.objects.Std2DObject;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureImpl;

import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;

public abstract class Button extends Std2DObject implements Observer, Observable{

	private double mouseX = -1;
	private double mouseY = -1;
	private double width = 0;
	private double height = 0;
	private boolean isLeftMouseDown = false;
	
	private String buttonText;
	private Texture mouseOver;
	private Texture normal;
	private Texture boundTexture;
	private Text font;
	private Color fontColor;
	
	private ArrayList<Observer> observerList = new ArrayList<>();
	
	public Button(double x, double y, double width, double height, Texture mouseOver, Texture normal, String text, Text yourFont, Color fontColor) {
		super(x, y);
		this.height = height;
		this.width = width;
		this.mouseOver = mouseOver;
		this.normal = normal;
		this.buttonText = text;
		this.font = yourFont;
		this.fontColor = fontColor;
	}
	
	public boolean isButton(){
		return mouseX>=x && mouseX<=x+width && mouseY>=y && mouseY<=y+height;
	}

	@Override
	public void draw() {
		glPushMatrix();
		glPushAttrib(GL_ALL_ATTRIB_BITS);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		
		TextureImpl.bindNone();
		
		glTranslated(x, y, 0);
		
		glColor4d(1, 1, 1, 1);

		
		if(isButton()){
			boundTexture = mouseOver;
		}else{
			boundTexture = normal;
		}
		boundTexture.bind();
		
		glBegin(GL_QUADS);
			glTexCoord2d(0, 0);glVertex2d(0, 0);
			glTexCoord2d(0, boundTexture.getHeight());glVertex2d(0, height);
			glTexCoord2d(boundTexture.getWidth(), boundTexture.getHeight());glVertex2d(width, height);
			glTexCoord2d(boundTexture.getWidth(), 0);glVertex2d(width, 0);
		glEnd();
		
		font.draw(x, y, 35, buttonText,fontColor, Location.TOP_LEFT);
		
		glPopAttrib();
		glPopMatrix();
	}

	@Override
	public void update(Observable observable) {
		
		if (observable.getClass().equals(Mouse.class)){
			// REtrieve the status of the mouse
			Mouse mouse = (Mouse) observable;
			mouseX = mouse.getX();
			mouseY = mouse.getY();
			isLeftMouseDown = mouse.getMouseButtonState(Mouse.LEFT_MOUSE_BUTTON);
			
			// Tell all observers that this button has been clicked on
			if (isLeftMouseDown && isButton()){
				buttonAction();
				notifyAllObservers();
			}								
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
	
	public abstract void buttonAction();

}

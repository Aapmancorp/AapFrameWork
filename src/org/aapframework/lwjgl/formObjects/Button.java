package org.aapframework.lwjgl.formObjects;

import org.aapframework.events.Observable;
import org.aapframework.events.Observer;
import org.aapframework.lwjgl.mouse.Mouse;
import org.aapframework.lwjgl.objects.Std2DObject;
import org.newdawn.slick.util.Log;

import static org.lwjgl.opengl.GL11.*;

public class Button extends Std2DObject implements Observer{

	private double mouseX = -1;
	private double mouseY = -1;
	private double width = 0;
	private double height = 0;
	
	public Button(double x, double y, double width, double height) {
		super(x, y);
		this.height = height;
		this.width = width;
	}
	
	public boolean isButton(){
		return mouseX>=x && mouseX<=x+width && mouseY>=y && mouseY<=y+height;
	}

	@Override
	public void draw() {
		glPushMatrix();
		glPushAttrib(GL_ALL_ATTRIB_BITS);
		glTranslated(x, y, 0);
		
		glColor4d(1, 1, 1, 1);
		
		if(isButton()){
			glColor4d(0, 0, 1, 1);
		}
		
		glBegin(GL_QUADS);
			glVertex2d(0, 0);
			glVertex2d(0, height);
			glVertex2d(width, height);
			glVertex2d(width, 0);
		glEnd();
		
		glPopAttrib();
		glPopMatrix();
	}

	@Override
	public void update(Observable observable) {
		Mouse mouse = (Mouse) observable;
		mouseX = mouse.getX();
		mouseY = mouse.getY();
		Log.debug("mouseX = "+mouseX+" mouseY = "+mouseY);
	}

}

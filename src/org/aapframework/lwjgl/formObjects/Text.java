package org.aapframework.lwjgl.formObjects;

import java.awt.Font;
import java.io.InputStream;

import static org.lwjgl.opengl.GL11.*;

import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.TextureImpl;
import org.newdawn.slick.util.ResourceLoader;

/**
 * Class to put text on a openGL screen.
 * 
 * @author ZL
 *
 */

public class Text{
	private Font awtFont;
	private TrueTypeFont myfont;
	private float baseFontSize = 54;
	private double lastX;
	private double lastY;
	private double lastFontSize;
	private Color lastColor;
	private Location lastLocation;
	
	/**
	 * loads the ttf file
	 * @param fontpath
	 */
	public Text(String fontpath){
		initFont(fontpath);
		initCache();
	}

	/**
	 * Renders the text on the screen.
	 * @param x left coordinate
	 * @param y top coordinate
	 * @param FontSize size of the font
	 * @param text Output text as a String
	 * @param color the color of the text (Slick Util)
	 * @param location The location on the string to pinpoint.
	 */
	public void draw(double x , double y , double FontSize, String text, Color color, Location location){
		// Remember the current settings
		lastX = x;
		lastY = y;
		lastFontSize = FontSize;
		lastColor = color;
		lastLocation = location;
		
		double dXForLocation, dYForLocation;
		
		// Scale the font texture
		double derivedFont = FontSize/baseFontSize;
		
		// Check for the location setting
		// Adjust X
		switch (location){
		case TOP_CENTER:
		case MID_CENTER:
		case BOT_CENTER:
			dXForLocation = - getWidth(FontSize, text)/2;
			break;		
		case TOP_RIGHT:
		case MID_RIGHT:
		case BOT_RIGHT:
			dXForLocation = - getWidth(FontSize, text);
			break;	
		default:
			dXForLocation = 0;
			break;
		}
		
		// Adjust Y
		switch (location){
		case MID_LEFT:
		case MID_CENTER:
		case MID_RIGHT:
			dYForLocation = - getHeight(FontSize)/2;
			break;		
		case BOT_LEFT:
		case BOT_CENTER:
		case BOT_RIGHT:
			dYForLocation = - getHeight(FontSize);
			break;	
		default:
			dYForLocation = 0;
			break;
		}
		
		// Save the current settings
		glPushAttrib(GL_ENABLE_BIT);
		// Enable transparency
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		
		// Save the rotation Matrix
		glPushMatrix();		
		
		// Move the text to the desired location
		glTranslated(x+dXForLocation, y+dYForLocation, 0);
		
		// Scale the font to the desired size 
		glScaled(derivedFont, derivedFont, derivedFont);
		// Unbind last texture. Other wise the font texture might have problems loading
		TextureImpl.unbind();
		
		//Draw it.
		myfont.drawString(0, 0, text,color);
		
		// Restore settings
		glPopMatrix();
		glPopAttrib();
	}
	/** Several overloading methods for draw*/
	public void draw(double x , double y , double FontSize, String text){
		draw(x, y, FontSize, text, Color.white, Location.TOP_LEFT);
	}
	
	public void draw(String text, Location location){
		lastLocation = location;
		draw(lastX, lastY, lastFontSize, text, lastColor, lastLocation);
	}
	
	/**
	 * Sets the initial values for the easy Texting
	 */
	public void initCache(){
		lastX = 0;
		lastY = 0;
		lastFontSize = 12;
		lastColor = Color.white;
		lastLocation = Location.TOP_LEFT;
	}
	/**
	 * Draw using previous settings.
	 * @param text
	 */
	public void draw(String text){
		draw(lastX, lastY, lastFontSize, text, lastColor, lastLocation);
	}
	/**
	 * Go to the next line. After this command use the draw method with only a String as input.
	 */
	public void newLine(){
		lastY += getHeight(lastFontSize);
	}
	/**
	 * Loads the font
	 * @param fontpath location of your ttf file
	 */
	public void initFont(String fontpath){
		try {			
			InputStream inputStream	= ResourceLoader.getResourceAsStream(fontpath);
			
			awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);		
			awtFont = awtFont.deriveFont(baseFontSize); // set font size
			myfont = new TrueTypeFont(awtFont, true);			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * The width of the Text
	 * @param FontSize
	 * @param text your string
	 * @return the width world coordinate scale
	 */
	public double getWidth(double FontSize, String text){
		return (myfont.getWidth(text)*FontSize/baseFontSize);
	}
	/**
	 * The height of your font for a given fontSize
	 * @param FontSize
	 * @return the height in world coordinate scale
	 */
	public double getHeight(double FontSize){
		return (myfont.getHeight()*FontSize/baseFontSize);
	}
}
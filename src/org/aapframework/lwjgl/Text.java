package org.aapframework.lwjgl;

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
	private float lastX;
	private float lastY;
	private float lastFontSize;
	private Color lastColor;
	
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
	 */
	public void draw(float x , float y , float FontSize, String text){
		draw(x, y, FontSize, text, Color.white);
	}
	/**
	 * Renders the text on the screen.
	 * @param x left coordinate
	 * @param y top coordinate
	 * @param FontSize size of the font
	 * @param text Output text as a String
	 * @param color the color of the text (Slick Util)
	 */
	public void draw(float x , float y , float FontSize, String text, Color color){
		// Remember the current settings
		lastX = x;
		lastY = y;
		lastFontSize = FontSize;
		lastColor = color;
		
		// Scale the font texture
		float derivedFont = FontSize/baseFontSize;
		glPushAttrib(GL_ENABLE_BIT);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glPushMatrix();
		glTranslatef(x, y, 0);
		glScalef(derivedFont, derivedFont, derivedFont);
		TextureImpl.unbind();
		myfont.drawString(0, 0, text,color);
		glPopMatrix();
		glPopAttrib();
	}
	
	public void initCache(){
		lastX = 0;
		lastY = 0;
		lastFontSize = 12;
		lastColor = Color.white;
	}
	/**
	 * Draw using previous settings.
	 * @param text
	 */
	public void draw(String text){
		draw(lastX, lastY, lastFontSize, text, lastColor);
	}
	/**
	 * Go to the next line. After this command use the draw method with only a String as input.
	 */
	public void newLine(){
		lastY += getHeight(lastFontSize);
	}
	/**
	 * The width of the Text
	 * @param FontSize
	 * @param text your string
	 * @return the width world coordinate scale
	 */
	public double getWidth(float FontSize, String text){
		return (myfont.getWidth(text)*FontSize/baseFontSize);
	}
	/**
	 * The height of your font for a given fontSize
	 * @param FontSize
	 * @return the height in world coordinate scale
	 */
	public double getHeight(float FontSize){
		return (myfont.getHeight()*FontSize/baseFontSize);
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
}
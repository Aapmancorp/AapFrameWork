package org.aapframework.lwjgl;

import java.io.IOException;
import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Util {
	/**
	 * Quick way to create a FloatBuffer
	 * @param values You can enter as many floats as you like (separated by commas)
	 * @return FloatBuffer containing your floats
	 */
	public static FloatBuffer createFloatBuffer(float... values) {
		return (FloatBuffer) BufferUtils.createFloatBuffer(values.length). put(values).flip(); 
	}
	
	/**
	 * Load texture
	 * @param input
	 * @return
	 * @throws IOException
	 */
	public static Texture loadtexture(String input, boolean flip) throws IOException{
					
		if(input.toLowerCase().endsWith(".jpg")){return TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream(input),flip);}
		if(input.toLowerCase().endsWith(".png")){return TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(input),flip);}
		if(input.toLowerCase().endsWith(".bmp")){return TextureLoader.getTexture("BMP", ResourceLoader.getResourceAsStream(input),flip);}
		throw new IOException();

	}
}

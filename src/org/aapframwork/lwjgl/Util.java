package org.aapframwork.lwjgl;

import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;

public class Util {
	/**
	 * Quick way to create a FloatBuffer
	 * @param values You can enter as many floats as you like (separated by commas)
	 * @return FloatBuffer containing your floats
	 */
	public static FloatBuffer createFloatBuffer(float... values) {
		return (FloatBuffer) BufferUtils.createFloatBuffer(values.length). put(values).flip(); 
	}
}

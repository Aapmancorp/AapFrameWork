package org.aapframework.lwjgl.Color;

import org.lwjgl.opengl.GL11;

/**
 * Hue. An Utility class to change the color gradually from one color to the other.
 * 
 * This effect might be nice for some games.
 * 
 * @author aapman
 *
 */

public class Hue {
	private int red = 0;
	private int  green = 0;
	private int blue = 0;
	private int maxValue = 102;
	private HueColor aimColor;
	private HueColor[] hueColorOrderList;
	
	/** THe basic colors */
	public enum HueColor{
		RED,BLUE,GREEN;
	}
	
	/**
	 * Constructor
	 * @param maxValue The maximum value for a color to have (between 0 and 255)
	 * @param hueColorOrderList Sort the 3 colors in the order you want it to change.
	 */
	public Hue(int maxValue, HueColor... hueColorOrderList){
		// Set the default value of the maximum color brightness to 200
		this.maxValue = 200;
		
		// If a valid value for the maximum value is given use that one instead.
		if (maxValue >= 0 && maxValue <= 255){
			this.maxValue = maxValue;
		}
		
		// Check if the list is filled. If not fill it with the default list.
		if (hueColorOrderList.length == 0){
			this.hueColorOrderList = new HueColor[]{HueColor.RED, HueColor.BLUE, HueColor.GREEN};
		}else{
			this.hueColorOrderList = hueColorOrderList;
		}
		
		// Set the color first in the list to the maximum value
		switch (hueColorOrderList[0]){
		case RED:
			setRed(maxValue);
			break;
		case BLUE:
			setBlue(maxValue);
			break;
		case GREEN:
			setGreen(maxValue);
			break;
		}
		
		// Set the color to go next to
		setAimColor(determineNextAimColor(hueColorOrderList[0]));
		
	}
	
	/**
	 * Determines what the next Color should be based on the List
	 * @param currentHue The Hue that is currently on.
	 * @return
	 */
	private HueColor determineNextAimColor(HueColor currentHue){
		// Retrieve the index of the current Hue in the List
		int currentIndex = indexInList(currentHue);
		
		// Check if the current Hue is the last in the list
		boolean isLastInList = currentIndex == hueColorOrderList.length -1;
		
		// If the current Hue is the last in the list 
		if (isLastInList){
			// Return the first Hue
			return hueColorOrderList[0];
		}
		
		// Return the next Hue in the List
		return hueColorOrderList[currentIndex + 1];		

	}
	
	/**
	 * 
	 * @param hueColor
	 * @return
	 */
	private int indexInList(HueColor hueColor){
		// Loop through the list to find the color requested
		for (int i = 0 ; i < this.hueColorOrderList.length; ++i){
			// If the color has been found, return that index.
			if (hueColorOrderList[i].equals(hueColor)){
				return i;
			}
		}
		
		// If the Hue Color has not been found, return index -1.
		return -1;
	}
	
	/**
	 * Change the current hue by the amount given in value
	 * @param value The amount to change the rgb value
	 */
	public void changeHue(int value){
		// Check to which color it should go.
		switch (aimColor){
		// If RED
		case RED:
			// Increase red till it hits the max value
			red = Math.min(red + value, maxValue);
			
			// If red has reached the maximum value, decrease the others
			if (red == maxValue){
				blue = Math.max(blue - value, 0);
				green = Math.max(green - value, 0);			
			}
			
			// If the others are decreased to 0, find the new aimColor
			if (red == maxValue && blue ==0 && green ==0){
				setAimColor(determineNextAimColor(HueColor.RED));
			}
			break;
		// If BLUE
		case BLUE:
			// Increase blue till it hits the max value
			blue = Math.min(blue + value, maxValue);
			
			// If blue has reached the maximum value, decrease the others
			if (blue == maxValue){
				red = Math.max(red - value, 0);
				green = Math.max(green - value, 0);			
			}
			
			// If the others are decreased to 0, find the new aimColor
			if (blue == maxValue && red ==0 && green ==0){
				setAimColor(determineNextAimColor(HueColor.BLUE));
			}
			break;
			
		// If GREEN
		case GREEN:
			// Increase green till it hits the max value
			green = Math.min(green + value, maxValue);
			
			// If blue green reached the maximum value, decrease the others
			if (green == maxValue){
				red = Math.max(red - value, 0);
				blue = Math.max(blue - value, 0);			
			}
			
			// If the others are decreased to 0, find the new aimColor
			if (green == maxValue && red ==0 && blue ==0){
				setAimColor(determineNextAimColor(HueColor.GREEN));
			}
			break;			
		}
	}
	
	/**
	 * Use the current color
	 */
	public void bind(){
		GL11.glColor3d(red/255.0, green/255.0, blue/255.0);
	}
	
	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}

	public HueColor getAimColor() {
		return aimColor;
	}

	public void setAimColor(HueColor aimColor) {
		this.aimColor = aimColor;
	}
}

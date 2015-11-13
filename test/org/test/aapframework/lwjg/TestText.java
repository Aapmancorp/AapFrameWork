package org.test.aapframework.lwjg;

import org.aapframework.lwjgl.Text;
import org.aapframework.lwjgl.window.Window;

public class TestText {
	public static void main(String[] args){
		Window window = new Window(1280, 720, "Text test");
		//Make text
		Text BEBAS = new Text("./res/Consolas.ttf");		
		
		while(!window.isCloseRequested()){
			// clear screen
			window.clearScreen();
			
			// Put text on the screen
			BEBAS.draw(0, 0, 35, "Hello World!\n Hello World!");			
			
			// Updates the screen
			window.updateScreen();
			
		}
		
		window.destroyWindow();
		
	}
}

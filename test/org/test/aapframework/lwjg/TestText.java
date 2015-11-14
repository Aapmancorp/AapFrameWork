package org.test.aapframework.lwjg;

import org.aapframework.lwjgl.formObjects.Text;
import org.aapframework.lwjgl.formObjects.Text.Location;
import org.aapframework.lwjgl.window.Window;
import org.newdawn.slick.Color;

public class TestText {
	public static void main(String[] args){
		Window window = new Window(1280, 720, "Text test");
		//Make text
		Text CONSOLAS = new Text("./res/Consolas.ttf");		
		
		while(!window.isCloseRequested()){
			// clear screen
			window.clearScreen();
			
			// Put text on the screen
			CONSOLAS.draw(200, 200, 120, "Hello World!\n Hello World!",Color.orange,Location.MID_CENTER);
			CONSOLAS.newLine();
			CONSOLAS.newLine();
			CONSOLAS.draw("Ja? Wie is daar?");
			CONSOLAS.newLine();
			CONSOLAS.newLine();
			CONSOLAS.draw("Het is GOD!!!");
			
			// Updates the screen
			window.updateScreen();
			
		}
		
		window.destroyWindow();
		
	}
}

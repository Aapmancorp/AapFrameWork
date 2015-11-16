import org.aapframework.lwjgl.Color.Hue;
import org.aapframework.lwjgl.Color.Hue.HueColor;
import org.aapframework.lwjgl.shapes.StdShapes;
import org.aapframework.lwjgl.window.Window;

import static org.lwjgl.opengl.GL11.*;

public class TestHue {
	public static void main(String[] args){
		Window window = new Window(800, 800, "HueTest");
		window.drawOn2D();
		Hue hue = new Hue(150, HueColor.BLUE, HueColor.RED);
		
		while(!window.isCloseRequested()){
			window.clearScreen();
			
			glPushMatrix();
			glTranslated(400, 400, 0);
			hue.bind();
			StdShapes.drawFilledCircle(200, 100);
			
			glPopMatrix();
			hue.changeHue(1);
			window.updateScreen();
		}
		
		window.destroyWindow();
	}
}

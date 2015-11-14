import org.aapframework.Utils.getTime;
import org.aapframework.logger.Logger;
import org.aapframework.logger.Logger.Severity;
import org.aapframework.lwjgl.formObjects.Text;
import org.aapframework.lwjgl.shapes.StdShapes;
import org.aapframework.lwjgl.window.Window;
import static org.lwjgl.opengl.GL11.*;

public class Clock {
	Logger log = Logger.getInstance();
	
	public boolean start(){
		// Create a window of size 1000px by 1000px with name 'Clock'
		Window window = new Window(1000,1000,"Clock");
		// Tell openGL to show a 2D perspective
		window.drawOn2D();
		// Do not show info messages
		log.setReportingLevel(Severity.DEBUG);
		// Initialise string for timestamp
		String currentTimeStamp;
		// Initialise hours, minutes and seconds
		int hour = 0;
		int minute = 0;
		int second = 0;
		// Total seconds in half a day
		int totalSecondsHalfDay = 60*60*12;
		// initialise current total seconds
		int currentTotalSeconds = 0;
		// Initialise font
		Text CONSOLAS = new Text("./res/Consolas.ttf");
		
		// Main drawing loop
		while(!window.isCloseRequested()){
			window.clearScreen();
			// Update currentTimestamp
			currentTimeStamp = getTime.getCurrentTimeStamp("hh:mm:ss");
			log.debug(currentTimeStamp);
			
			// Get the hours minutes and seconds
			hour = Integer.parseInt(currentTimeStamp.split(":")[0]);
			minute = Integer.parseInt(currentTimeStamp.split(":")[1]);
			second = Integer.parseInt(currentTimeStamp.split(":")[2]);
			
			// Current total seconds
			currentTotalSeconds = hour*60*60+minute*60+second;

			// Start openGL part
			// Draw the clock in the origin and move it as a whole to the center of the screen
			// Save transformation state
			glPushMatrix();
			glTranslated(window.getWindowWidth()/2, window.getWindowHeight()/2, 0);
			// Draw the outside
			StdShapes.drawLineCircle(window.getWindowHeight()/2, 100, 5);
			
			// Draw the digital clock
			CONSOLAS.draw((float)-CONSOLAS.getWidth(50, currentTimeStamp)/2f, window.getWindowHeight()/4f, 50f, currentTimeStamp);
			
			// Draw the numbers
			CONSOLAS.draw((float)-CONSOLAS.getWidth(60, "12")/2f, -window.getWindowHeight()/2, 60, "12");
			CONSOLAS.draw((float)window.getWindowWidth()/2f-(float)CONSOLAS.getWidth(60, "3"), (float)-CONSOLAS.getHeight(60)/2, 60, "3");
			CONSOLAS.draw((float)-CONSOLAS.getWidth(60, "6")/2f, (float)(window.getWindowHeight()/2f-CONSOLAS.getHeight(60)), 60, "6");
			CONSOLAS.draw((float)-window.getWindowWidth()/2f, (float)-CONSOLAS.getHeight(60)/2, 60, "9");
			
			// Draw the hour pointer
			glPushMatrix();
			glRotated(currentTotalSeconds/(totalSecondsHalfDay*1.0)*360, 0, 0, 1);
			glLineWidth(4);
			glBegin(GL_LINES);
				glVertex2d(0, 0);
				glVertex2d(0, - window.getWindowWidth()/4);
			glEnd();			
			glPopMatrix();
			
			// Draw the minutes pointer
			glPushMatrix();
			glRotated(minute/60.0*360, 0, 0, 1);
			glLineWidth(4);
			glBegin(GL_LINES);
				glVertex2d(0, 0);
				glVertex2d(0, -window.getWindowWidth()/3);
			glEnd();			
			glPopMatrix();
			
			// Draw the seconds pointer
			glPushMatrix();
			glRotated(second/60.0*360, 0, 0, 1);
			glLineWidth(4);
			glBegin(GL_LINES);
				glVertex2d(0, 0);
				glVertex2d(0, -window.getWindowWidth()/2*0.95);
			glEnd();			
			glPopMatrix();
			
			glPopMatrix();
			// Update the screen
			window.updateScreen();
		}		
		
		// When finished, destroy the window.
		window.destroyWindow();
		
		return true;
	}
	
	
	/**
	 * Start of the main program
	 * @param args
	 */
	public static void main(String[] args){
		new Clock().start();
	}
}

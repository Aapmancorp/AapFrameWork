package org.aapframework.lwjgl.objects;

import org.newdawn.slick.opengl.Texture;
import static org.lwjgl.opengl.GL11.*;

public class Skybox extends StdObject{
	private Texture front;
	private Texture left;
	private Texture back;
	private Texture right;
	private Texture top;
	private Texture bottom;
	private boolean flip;
	
	private int skybox = 0;

	public Skybox(Texture front, Texture left, Texture back, Texture right, Texture top, Texture bottom, boolean flip) {
		super(0,0,0);
		setFront(front);
		setLeft(left);
		setBack(back);
		setRight(right);
		setTop(top);
		setBottom(bottom);
		setFlip(flip);
	}

	@Override
	public void draw() {
		if (skybox == 0){
			generateDisplayList();
		}
		
		glCallList(skybox);		
	}
	
	private int generateDisplayList(){
		skybox = glGenLists(1);
		glNewList(skybox, GL_COMPILE);
		
		//Enable/Disable features
        glPushAttrib(GL_ALL_ATTRIB_BITS);
        glEnable(GL_TEXTURE_2D);
            
        glDisable(GL_DEPTH_TEST);
        glDisable(GL_LIGHTING);
        glDisable(GL_BLEND);
            
        double smallnumber = 0.002;
        double ONE = 1-smallnumber;
        double ZERO = smallnumber;
        
        if (flip){
        	ZERO = 1-smallnumber;
        	ONE = smallnumber;
        }
        //Just in case we set all vertices to white.
        glColor4f(1,1,1,1);
         
        //Render the front quad
        front.bind();
        glBegin(GL_QUADS);
        glTexCoord2d(ZERO, ZERO); glVertex3d(  0.5, -0.5, -0.5 );
        glTexCoord2d(ZERO, ONE); glVertex3d(  0.5,  0.5, -0.5 );
        glTexCoord2d(ONE, ONE); glVertex3d( -0.5,  0.5, -0.5 );
        glTexCoord2d(ONE, ZERO); glVertex3d( -0.5, -0.5, -0.5 );			        
        glEnd();
         
        //Render the left quad
        left.bind();
        glBegin(GL_QUADS);
        glTexCoord2d(ZERO, ONE); glVertex3d(  0.5,  0.5,  0.5 );
        glTexCoord2d(ONE, ONE); glVertex3d(  0.5,  0.5, -0.5 );
        glTexCoord2d(ONE, ZERO); glVertex3d(  0.5, -0.5, -0.5 );	
        glTexCoord2d(ZERO, ZERO); glVertex3d(  0.5, -0.5,  0.5 );			        
        glEnd();
         
        //Render the back quad
        back.bind();
        glBegin(GL_QUADS);
        glTexCoord2d(ZERO, ZERO); glVertex3d( -0.5, -0.5,  0.5 );
        glTexCoord2d(ZERO, ONE); glVertex3d( -0.5,  0.5,  0.5 );
        glTexCoord2d(ONE, ONE); glVertex3d(  0.5,  0.5,  0.5 );
        glTexCoord2d(ONE, ZERO); glVertex3d(  0.5, -0.5,  0.5 );
        glEnd();
         
        //Render the right quad
        right.bind();
        glBegin(GL_QUADS);
        glTexCoord2d(ZERO, ZERO); glVertex3d( -0.5, -0.5, -0.5 );
        glTexCoord2d(ZERO, ONE); glVertex3d( -0.5,  0.5, -0.5 );
        glTexCoord2d(ONE, ONE); glVertex3d( -0.5,  0.5,  0.5 );
        glTexCoord2d(ONE, ZERO); glVertex3d( -0.5, -0.5,  0.5 );
        glEnd();
         
        //Render the top quad
        top.bind();
        glBegin(GL_QUADS);
        glTexCoord2d(ONE, ZERO); glVertex3d( -0.5,  0.5, -0.5 );
        glTexCoord2d(ZERO, ZERO); glVertex3d(  0.5,  0.5, -0.5 );
        glTexCoord2d(ZERO, ONE); glVertex3d(  0.5,  0.5,  0.5 );
        glTexCoord2d(ONE, ONE); glVertex3d( -0.5,  0.5,  0.5 );
        glEnd();
         
        //Render the bottom quad
        bottom.bind();
        glBegin(GL_QUADS);
        glTexCoord2d(ZERO, ZERO); glVertex3d(  0.5, -0.5,  0.5 );
        glTexCoord2d(ZERO, ONE); glVertex3d(  0.5, -0.5, -0.5 );
        glTexCoord2d(ONE, ONE); glVertex3d( -0.5, -0.5, -0.5 );  		       
        glTexCoord2d(ONE, ZERO); glVertex3d( -0.5, -0.5,  0.5 );
        glEnd();
        
        //Restore enable bits and matrix
        glPopAttrib();
		
		glEndList();
		return skybox;
	}

	public Texture getFront() {
		return front;
	}

	public void setFront(Texture front) {
		this.front = front;
	}

	public Texture getLeft() {
		return left;
	}

	public void setLeft(Texture left) {
		this.left = left;
	}

	public Texture getBack() {
		return back;
	}

	public void setBack(Texture back) {
		this.back = back;
	}

	public Texture getRight() {
		return right;
	}

	public void setRight(Texture right) {
		this.right = right;
	}

	public Texture getTop() {
		return top;
	}

	public void setTop(Texture top) {
		this.top = top;
	}

	public Texture getBottom() {
		return bottom;
	}

	public void setBottom(Texture bottom) {
		this.bottom = bottom;
	}

	public boolean isFlip() {
		return flip;
	}

	public void setFlip(boolean flip) {
		this.flip = flip;
	}

}

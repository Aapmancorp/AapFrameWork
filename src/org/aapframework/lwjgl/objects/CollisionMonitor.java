package org.aapframework.lwjgl.objects;

import java.util.ArrayList;

public class CollisionMonitor {
	private ArrayList<CollidableObject> collidableObjectList = new ArrayList<>();
	
	public boolean hasCollisionWithOtherObject(CollidableObject collidableObject){
		if (!collidableObjectList.contains(collidableObject)){
			return false;
		}
		
		for (CollidableObject cOb: collidableObjectList){
			// Continue if it is itself
			if (cOb == collidableObject){
				continue;
			}
			
			if (collidableObject.hasCollided(cOb)){
				return true;
			}
		}
		
		return false;
	}

	public ArrayList<CollidableObject> getCollidableObjectList() {
		return collidableObjectList;
	}

	public void setCollidableObjectList(ArrayList<CollidableObject> collidableObjectList) {
		this.collidableObjectList = collidableObjectList;
	}	
}

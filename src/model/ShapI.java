package model;

import java.awt.Graphics;

public class ShapI extends Component {
	
	private int[][] components = {
			{ 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },// state one init 
			{ 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 },// state two turn once
			{ 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 }, };
	
	public ShapI(){
		super.components = components;
	}
	
	@Override
	public void draw(Graphics g, int x, int y) {
		g.fillRect(x, y, 10, 10);
	}
	
}

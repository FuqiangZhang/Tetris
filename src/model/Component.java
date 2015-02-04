package model;

import java.awt.Graphics;

public class Component {

	protected int x = 130;
	protected int y = 0;
	protected int[][] components = new int[4][16];
	protected int state = 0;

	public void draw(Graphics g, int x, int y) {
		g.fillRect(x, y, 10, 10);
	}

	public void drawShap(Graphics g) {
		for (int i = 0; i < components[0].length; i++) {
			if (components[state][i] == 1) {
				Component comp = new Component();
				comp.draw(g, x + i % 4 * 10, y + i / 4 * 10);
			}
			
		}
	}
	
	public boolean getValue(int i){
		if(components[state][i] != 0)
			return true;
		return false;
	}

	public void turn() {
		state++;
		if (state == 4)
			state = 0;
	}

	public void down() {
		y += 10;
	}

	public void move(int xx, int yy) {
		
		this.x = x + xx;
		this.y = y + yy;
	}

	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
}

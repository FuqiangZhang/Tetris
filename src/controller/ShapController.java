package controller;

import gui.Canvas;

import java.util.ArrayList;

import java.util.Timer;
import java.util.TimerTask;

import controller.KeyController.KeyControllCallBack;
import model.*;

public class ShapController implements KeyControllCallBack {
	private ArrayList<Component> al_component = new ArrayList<Component>();
	private Component comp_Now;
	private ShapAll shapAll;

	private void createNewShap() {
		al_component.remove(comp_Now);
		int i =  (int)(Math.random()*1000)%3;
		switch(i){
		case 0:
			comp_Now = new ShapL();
			break;
		case 1:
			comp_Now = new ShapO();
			break;
		case 2:
			comp_Now = new ShapI();
			break;
		}
		al_component.add(comp_Now);
	}

	

	public ShapController() {
		Canvas.getInstance().setComponents(al_component);
		createNewShap();
		createShapAll();
		Timer timer = new Timer();
		timer.schedule(new TimerTaskGame(), 1000, 1000);
	}

	public void createShapAll() {
		shapAll = new ShapAll();
		al_component.add(shapAll);
	}

	// Åö×²¼ì²â
	public int isCollision() {
		int result = 0;
		for (int i = 0; i < 16; i++) {
			if (comp_Now.getValue(i)&& shapAll.getValue(i, comp_Now.getX(), comp_Now.getY())==1){
				result = 1;
			}
			if (comp_Now.getValue(i)&& shapAll.getValue(i, comp_Now.getX(), comp_Now.getY())==2)
				result = 2;
			if (comp_Now.getValue(i)&& shapAll.getValue(i, comp_Now.getX(), comp_Now.getY())==3)
				result = 3;
		}
		return result;
	}

	public void turn() {
		if (isCollision() == 0){
			comp_Now.turn();
		}
	}

	public void down() {
		if (isCollision() != 1) {
			comp_Now.down();
		}else{
			shapAll.addOne(comp_Now);
			createNewShap();
		}
	}

	public void left() {
		if (isCollision() != 3 && isCollision()!=1) {
			comp_Now.move(-10, 0);
		}
	}

	public void right() {
		if (isCollision() != 2 && isCollision()!=1) {
			comp_Now.move(10, 0);
		}
	}

	private class TimerTaskGame extends TimerTask {

		@Override
		public void run() {
			down();
			Canvas.getInstance().repaint();
		}

	}

	@Override
	public void keySpace() {
		turn();
		Canvas.getInstance().repaint();
	}

	@Override
	public void keyLeft() {
		left();
		Canvas.getInstance().repaint();
	}

	@Override
	public void keyRight() {
		right();
		Canvas.getInstance().repaint();
	}

	@Override
	public void keyDown() {
		down();
		Canvas.getInstance().repaint();
	}
}

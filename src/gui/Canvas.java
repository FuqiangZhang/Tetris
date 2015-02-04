package gui;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Component;
import controller.KeyController;

public class Canvas extends JPanel {
	private static Canvas instance;
	private ArrayList<Component> al_Components;
	private Canvas() {
		this.addKeyListener(new KeyController());
	}

	public static Canvas getInstance() {
		if (instance == null) {
			instance = new Canvas();
		}
		return instance;
	}

	public void setComponents(ArrayList<Component> al_Components){
		this.al_Components = al_Components;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Component comp: al_Components){
			comp.drawShap(g);
		}
	}
	
}

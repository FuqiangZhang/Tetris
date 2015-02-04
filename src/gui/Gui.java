package gui;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.KeyController;
import controller.ShapController;

public class Gui extends JFrame {
	private static Gui instance;

	private Gui() {

	}

	public static Gui getInstance() {
		if (instance == null) {
			instance = new Gui();
		}
		return instance;
	}

	private JMenuBar jmbar;
	private JMenu jm_Start;
	private JMenu jm_Help;
	private JMenuItem jmi_Restart;
	private JMenuItem jmi_Quit;
	private JMenuItem jmi_Help;

	public void initUI() {
		jmbar = new JMenuBar();
		jm_Start = new JMenu("Start");
		jm_Help = new JMenu("Help");
		jmi_Restart = new JMenuItem("Restart");
		jmi_Quit = new JMenuItem("Quit");
		jmi_Help = new JMenuItem("Help");

		jm_Start.add(jmi_Restart);
		jm_Start.add(jmi_Quit);
		jm_Help.add(jmi_Help);

		jmbar.add(jm_Start);
		jmbar.add(jm_Help);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 400);
		this.add(jmbar, BorderLayout.NORTH);
		this.setVisible(true);
		this.add(Canvas.getInstance());

		KeyController keyListener = new KeyController();
		ShapController sc = new ShapController();
		keyListener.setContext(sc);
		this.addKeyListener(keyListener);
	}

	public static void main(String[] args) {
		Gui.getInstance().initUI();
		Canvas.getInstance().repaint();
	}

}

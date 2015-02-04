package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyController implements KeyListener {

	private KeyControllCallBack cb;

	public void setContext(KeyControllCallBack cb) {
		this.cb = cb;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println(e.getKeyChar());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_SPACE:
			cb.keySpace();
			break;
		case KeyEvent.VK_LEFT:
			cb.keyLeft();
			break;
		case KeyEvent.VK_RIGHT:
			cb.keyRight();
			break;
		case KeyEvent.VK_DOWN:
			cb.keyDown();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	public interface KeyControllCallBack {
		public void keySpace();

		public void keyLeft();

		public void keyRight();
		
		public void keyDown();

	}

}

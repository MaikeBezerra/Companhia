package br.ufc.qxd.persistencia.view.field;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StringField implements KeyListener{

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char vchar = e.getKeyChar();
		if (Character.isDigit(vchar) ||
				vchar == KeyEvent.VK_DELETE) {
			e.consume();
		}
		
	}

}

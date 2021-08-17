import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import enigma.core.Enigma;

public class Program {
	private Tree tree;
	private enigma.console.Console cn;
	private KeyListener klis;
	private int keypr;
	private int rkey;
	private int rkeymod;
	Program(){
		this.cn = Enigma.getConsole("Tree App", 120, 30, 15);
		startProgram();
	}
	public void startProgram() {
		klis=new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {
				if(keypr==0) {
					keypr=1;
					rkey=e.getKeyCode();
					rkeymod=e.getModifiersEx();}}public void keyReleased(KeyEvent e) {
					}
					};
		cn.getTextWindow().addKeyListener(klis);		
	}
    
}


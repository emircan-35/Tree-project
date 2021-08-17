import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

import enigma.core.Enigma;

public class Program {
	private Tree tree;
	private enigma.console.Console cn;
	private int rkeymod;
	private KeyListener klis;
	private int keypr;
	private int rkey;
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
	            }
	         }
	         public void keyReleased(KeyEvent e) {}
	      };
	      writeBasicScreen();
	      cn.getTextWindow().addKeyListener(klis);
	      while(true) {
	    	    if(keypr==1) {    
		        processInput((char)rkey);
		        }
		        keypr=0; 
	            try {
					Thread.sleep(100);
				} catch (Exception e) {
					// TODO: handle exception
				}
		    }    
	}
	public void writeBasicScreen() {
		cn.getTextWindow().output("A NEW TREE - F1\n\n");
		cn.getTextWindow().output("ADD A NEW ELEMENT TO TREE - F2\n\n");
		cn.getTextWindow().output("MAKE A NEW SEARCH- F3\n\n");
		cn.getTextWindow().output("DELETE AN ELEMENT IN TREE - F4\n\n");


	}
	public void processInput(char rckey) {
		//Switch case is preferred to be faster comparing the if else block.
		switch (rckey) {
		case (char)KeyEvent.VK_F1:
			newTree();
			break;
		case (char)KeyEvent.VK_F2:
			add();
			break;
		case (char)KeyEvent.VK_F3:
			search();
			break;
		case (char)KeyEvent.VK_F4:
			delete();
			break;
		default:break;
		}
	}
	
	public void newTree() {
		cn.getTextWindow().setCursorPosition(0, 12);
		cn.getTextWindow().output("PLEASE ENTER THE LENGTH YOU WANT THE TREE TO BE\n");
		cn.getTextWindow().output("--> ");
		Scanner inp =new Scanner(System.in);
		String input=inp.nextLine();
		int length;
		try {
			length=Integer.parseInt(input);
		} catch (Exception ClassCastException) {
			System.out.println("PLEASE WRITE A VALID NUMBER");
			deleteInputArea();
			return;
		}
		this.tree=new Tree(length);
		deleteInputArea();
		tree.printTree(cn);
	}
	
	public void add() {
		cn.getTextWindow().setCursorPosition(0, 12);
		cn.getTextWindow().output("PLEASE ENTER THE NUMBER YOU WANT TO ADD\n");
		cn.getTextWindow().output("--> ");
		Scanner inp =new Scanner(System.in);
		String input=inp.nextLine();
		int numberToAdd;
		try {
			numberToAdd=Integer.parseInt(input);
		} catch (Exception ClassCastException) {
			System.out.println("PLEASE WRITE A VALID NUMBER");
			deleteInputArea();
			return;
		}
		tree.addBinary(numberToAdd);
		tree.printTree(cn);
	}
	
	public void search() {
		
	}
	
	public void delete() {
		
	}
	
	public void deleteInputArea() {
		for (int i = 0; i < 10; i++) {
			cn.getTextWindow().setCursorPosition(0, 12+i);
			cn.getTextWindow().output("                                             ");
		}
	}
	
	
}


import java.awt.event.KeyListener;

import enigma.console.TextAttributes;
import enigma.core.Enigma;

import java.awt.Color;
import java.awt.event.KeyEvent;

public class Tree {
	private enigma.console.Console cn;
	private Node root;
	private int length;
	Tree(Object data){
		this.root=new Node(data);
		this.length=0;
		this.cn = Enigma.getConsole("Tree App", 120, 30, 15);
	}
	
	public void addBinary(Object dataToAdd) {
		int numberToAdd;
		boolean left=false;
		try {
			numberToAdd=(int)dataToAdd;
		} catch (Exception ClassCastException) {
			numberToAdd=findIntEquilavent(dataToAdd);
		}
		Node node=this.root;
		while (true) {
			if ((int)node.getData()>numberToAdd) {
				if (node.getLeftNode()!=null) node=node.getLeftNode();
				else {
					left=true; break;
				}
			}else {
				if (node.getRightNode()!=null) node=node.getRightNode();
				else break;
			}
		}
		if (left) {
			node.setLeftNode(new Node(dataToAdd));
		}else {
			node.setRightNode(new Node(dataToAdd));
		}
		length++;
	}
	private int findIntEquilavent(Object dataToConvert) {
		int equilavent=0;
		char[] charToAdd=((String)dataToConvert).toCharArray();
		for (int i = 0; i < charToAdd.length; i++) {
			equilavent+=(int)charToAdd[i];
		}
		return equilavent;
	}
	
	public void printTree() {
		print(root,50,0);
	}
	public boolean search(int numberToSearch) {
		Node root=this.root;
		while (root!=null) {
			if (numberToSearch==(int)root.getData()) {
				return true;
			}else if(numberToSearch<(int)root.getData()) {
				root=root.getLeftNode();
			}else {
				root=root.getRightNode();
			}
		}
		return false;
	}
	private void print(Node node, int x, int y) {
		if (node.getLeftNode()!=null) {
			int lineX=x;
			int lineY=y;
			for (int i = 0; i < 3; i++) {
				lineX--;lineY++;
				this.cn.getTextWindow().setCursorPosition(lineX, lineY);
				this.cn.getTextWindow().output('/');
			}
			print(node.getLeftNode(),x-4,y+4);
		}
		if (node.getRightNode()!=null) {
			int lineX=x;
			int lineY=y;
			for (int i = 0; i < 3; i++) {
				lineX++;lineY++;
				this.cn.getTextWindow().setCursorPosition(lineX, lineY);
				this.cn.getTextWindow().output("\\");
			}
			print(node.getRightNode(),x+4,y+4);
		}
		this.cn.getTextWindow().setCursorPosition(x, y);
		this.cn.getTextWindow().output(Integer.toString((int)node.getData()));
	}
}

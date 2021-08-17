import java.awt.event.KeyListener;
import java.util.Random;

import enigma.console.TextAttributes;
import enigma.core.Enigma;

import java.awt.Color;
import java.awt.event.KeyEvent;

public class Tree {
	private Node root;
	private int length;
	Tree(Object data){
		this.root=new Node(data);
		this.length=0;
	}
	Tree(int length){
		Random rnd=new Random();
		this.root=new Node(10);
		for (int i = 0; i < length; i++) {
			int number=rnd.nextInt(100)+1;
			if (rnd.nextInt(2)==1) number*=-1;
			addBinary(number);
		}
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
			if ((int)node.getData()<numberToAdd) {
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
	
	public void delete(int number) {
		if ((int)root.getData()==number) {
			Node newRoot;
			if (root.getLeftNode()!=null&&root.getRightNode()!=null) {
				newRoot=root.getRightNode();
				root.getRightNode().setLeftNode(root.getLeftNode());
			}else if(root.getLeftNode()!=null) {
				newRoot=root.getLeftNode();
			}else if(root.getRightNode()!=null) {
				newRoot=root.getRightNode();
			}else newRoot=new Node(10);
			this.root=null;
			this.root=newRoot;
			return;
		}else {
			Node node=this.root;
			while (true) {
				if ((int)node.getData()<number) {
					if (node.getLeftNode()!=null) node=node.getLeftNode();
					else break;
				}else if((int)node.getData()>number){
					if (node.getRightNode()!=null) node=node.getRightNode();
					else break;
				}else {
					
				}
			}
		}
	}
	private int findIntEquilavent(Object dataToConvert) {
		int equilavent=0;
		char[] charToAdd=((String)dataToConvert).toCharArray();
		for (int i = 0; i < charToAdd.length; i++) {
			equilavent+=(int)charToAdd[i];
		}
		return equilavent;
	}
	
	public void printTree(enigma.console.Console cn) {
		print(cn,root,75,0);
	}
	public void search(enigma.console.Console cn,int numberToSearch) {
		Node node=this.root;
		int x=75;
		int y=0;
		while (true) {
			cn.getTextWindow().setCursorPosition(x, y);
			TextAttributes color=new TextAttributes(new Color(255,160,122));
			cn.getTextWindow().output(String.valueOf(node.getData()), color);
			if ((int)node.getData()<numberToSearch) {
				if (node.getLeftNode()!=null) {
					node=node.getLeftNode();
					x-=4;y+=4;
				}
				else break;
			}else if((int)node.getData()>numberToSearch){
				if (node.getRightNode()!=null) {
					node=node.getRightNode();
					x+=4;y+=4;
				}
				else break;
			}else {
				cn.getTextWindow().setCursorPosition(40, 60);
				cn.getTextWindow().output("FOUND!");
				return;
			}
            try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
		}
		cn.getTextWindow().setCursorPosition(40, 60);
		cn.getTextWindow().output("NOT FOUND!");
	}
	private void print(enigma.console.Console cn,Node node, int x, int y) {
		if (node.getLeftNode()!=null) {
			int lineX=x;
			int lineY=y;
			for (int i = 0; i < 3; i++) {
				lineX--;lineY++;
				cn.getTextWindow().setCursorPosition(lineX, lineY);
				cn.getTextWindow().output('/');
			}
			print(cn,node.getLeftNode(),x-4,y+4);
		}
		if (node.getRightNode()!=null) {
			int lineX=x;
			int lineY=y;
			for (int i = 0; i < 3; i++) {
				lineX++;lineY++;
				cn.getTextWindow().setCursorPosition(lineX, lineY);
				cn.getTextWindow().output("\\");
			}
			print(cn,node.getRightNode(),x+4,y+4);
		}
		cn.getTextWindow().setCursorPosition(x, y);
		cn.getTextWindow().output(Integer.toString((int)node.getData()));
	}
}

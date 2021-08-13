
public class Node {
	private Object data;
	private Node leftNode;
	private Node rightNode;
	
	public Node(Object data) {
		this.data=data;
		this.leftNode=null;
		this.rightNode=null;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Node getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	public Node getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
	
	
	
	
	
}

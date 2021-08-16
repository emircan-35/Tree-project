import java.util.Random;

public class Test {

	public static void main(String[] args) {
		Random rnd=new Random();
		Tree binaryTree=new Tree(50);
		for (int i = 0; i < 15; i++) {
			int random=rnd.nextInt(90)+10;
			binaryTree.addBinary(random);
		}
		binaryTree.printTree();
	}

}
 
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		Random rnd=new Random();
		Tree binaryTree=new Tree(10);
		for (int i = 0; i < 10; i++) {
			int random=rnd.nextInt(20)+1;
			if (rnd.nextInt(2)==1) random*=-1;
			binaryTree.addBinary(random);
		}
		binaryTree.printTree();
	}

}
 
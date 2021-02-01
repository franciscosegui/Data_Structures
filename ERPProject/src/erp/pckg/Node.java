package erp.pckg;

public class Node {

	public int key;
	public Product product;
	
	public Node leftChild;
	public Node rightChild;
	
	public Node (int key, Product product)
	{
		this.key = key;
		this.product = product;
	}
	
	public String toString() {
		return product + "id: "+ key;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	
	
}

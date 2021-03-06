package erp.pckg;

public class BinaryTree {
	Node raiz;
	
	//Agregar nodos al BinaryTree
	public void addNode(int key, Product product) {
		
		Node newNode = new Node(key, product);
		
		//Nodo padre
		if(raiz == null) {
			raiz = newNode; //si es elemento root tiramos un nuevo elemento ah�
		}else {
			
			Node focusNode = raiz; 
			
			Node parent;
			
			while(true) //loop infinito
			{
				parent = focusNode;//nodo padre es igual a nodo root
				
				//verificar si nuevo nodo va a la derecha o izquierda del padre
				
				if(key < focusNode.key) {
					
					//leftChild key/id debe ser menor que la de su padre
					focusNode = focusNode.leftChild; //cambiar foco al Child de la izquierda
					
					//Si leftChild no tiene hijos, los ubicamos a la derecha
					if (focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
					
				}else {
					//nodo ubicado a la derecha
					focusNode = focusNode.rightChild;
					
					//si no tiene hijos, por eso null value
					if(focusNode == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
			
		}
		
	}
	
	
	public void inOrderTraverseTree (Node focusNode) {
		
		if(focusNode != null)
		{
			inOrderTraverseTree (focusNode.leftChild);
			System.out.println(focusNode);
			inOrderTraverseTree(focusNode.rightChild);
		}
	}

	public Node getNode(int k)
	{
		Node current = raiz;
		while(current.key != k) {
			if(k < current.key) {
				current = current.leftChild;
			}else {
				current = current.rightChild;
			}
		}
		return current;
		
	}
}



package erp.pckg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CarregandoDados {
	ArrayList<Product> products;
	ArrayList<Product> dadosNodo = new ArrayList();

	public void run() {
		String archivoCSV = "C:/Users/Martín/Desktop/Products.csv";
		BufferedReader br = null;
		String line= "";
		
		try {
			ArrayList<Product> registros = new ArrayList<>();
			
			br = new BufferedReader(new FileReader(archivoCSV));
			
			
			int i=0;
			
			while((line = br.readLine()) !=null) {
				
				registros.add(new Product(i, line));
				
				i++;
				
			this.setProducts(registros);
			}}catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
		
			
		
		
	}
	
	public ArrayList<Product> getProducts(){
		return dadosNodo;
	}
	
	public void setProducts(ArrayList<Product> products) {
		this.products = dadosNodo;
	}
	
	public BinaryTree dadosTree() {
		BinaryTree arbolBinario = new BinaryTree();
		for (Product p: dadosNodo) {
			arbolBinario.addNode(p.getId(), p);
		}
		return null;
		
	}
}

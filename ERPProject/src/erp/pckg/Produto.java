package erp.pckg;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Produto {
	private ArrayList<Product> products;
	private BinaryTree binarytree;
	
	public Produto(ArrayList<Product> products, BinaryTree binarytree) {
		this.products = products;
		this.binarytree = binarytree;
	}
	
	public Product Id(int id) {
		for(Product p: products) {
			if(p.getId() == id) {
				return p;
			}
		}
		return null;
	}
	
	
	public ArrayList<Product> nomes (String nome){
		ArrayList<Product> nomesencontrados = new ArrayList();
		
		for(Product p: products) {
			if(p.getNome().contains(nome)) {
				nomesencontrados.add(p);
			}
		}
		return nomesencontrados;
	}
	
	public ArrayList<Product> get(){
		for(Product p: products) {
			System.out.println("ID: "+p.getId()+"Nome: "+p.getNome());
		}
		return null;
	}
	
	public void StockDeProdutos(int id) {
		Product p = this.Id(id);
		
		if(p == null) {
			System.out.println("Produto não encontrado");
		}
		
		if (p.getQueue().isEmpty()) {
			System.out.println("Sem Stock");
		}else {
			for (ProductStock ps: p.getQueue()) {
				System.out.println("Quantidade: "+ps.getQuantidade()+"Data: "+ps.getData());
			}
			System.out.println("Total: "+p.getTotal());
		}
	}
	
	public void remover(int id, int quant) {
		Product p = this.Id(id);
		
		if(p == null) {
			System.out.println("Produto não existente");
		}
		
		if(p.getQueue().isEmpty()) {
			System.out.println("Sem Stock");
		}
		while (quant > 0){
            ProductStock productStock = p.getQueue().element();

            if(quant > productStock.getQuantidade() && quant <= p.getTotal()){

                p.setTotal( p.getTotal() - productStock.getQuantidade());

                quant -= productStock.getQuantidade();

                System.out.println("REMOVENDO!! " + p.getQueue().element().show());

                p.getQueue().remove();

                continue;
            }

            if(quant == productStock.getQuantidade()){
                System.out.println("REMOVENDO!! " + p.getQueue().element().show());

                p.setTotal( p.getTotal() - productStock.getQuantidade());

                p.getQueue().remove();
                quant = 0;

                continue;
            }

            if(quant < productStock.getQuantidade()){
                p.setTotal( p.getTotal() - quant);

                if((productStock.getQuantidade() - quant) < 1){
                    p.getQueue().remove();
                }else{
                    productStock.setQuantidade( productStock.getQuantidade() - quant );
                }

                quant = 0;

                continue;
            }

            if(quant > p.getTotal()){

                try {
                    System.out.println("Não é possível remover o solicitado , deseja remover: "+p.getTotal());


                    Scanner type = new Scanner(System.in);
                    System.out.println("1 - Sim\n 2 - Não");
                    int a = type.nextInt();

                    if(a == 1){

                        quant = p.getTotal();

                    }
                    if(a == 2){
                        break;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("InputMismatchException");
                    continue;
                } catch (NoSuchElementException e) {

                    continue;
                }



            }

        }

        System.out.println("Feito");
	}
	
	public Product buscaABinario(int id)
	{
		Node node = binarytree.getNode(id);
		return node.getProduct();
    }
}
	
	


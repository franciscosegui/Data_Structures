package erp.pckg;
import erp.pckg.Produto;
import erp.pckg.CarregandoDados;
import erp.pckg.Product;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

	private static Produto produtomanage;



	    public static void main(String[] args) {

	        CarregandoDados cd = new CarregandoDados();

	        cd.run(); 

	        produtomanage = new Produto(cd.getProducts());

	        
		        System.out.println("1 – Buscar por código");
		        System.out.println("2 – Buscar por nome.");
		        System.out.println("3 – Retirar por Código.");
		        System.out.println("4 – Mostrar Stock dos produtos.");

		        Scanner sc = new Scanner(System.in);

		        int a = sc.nextInt();
		        

		        if(a == 1){

		            System.out.println("Buscar por código\nDigite o codigo do produto");

		            int id = sc.nextInt();
		            Product resultado = produtomanage.Id(id);

		            if(resultado == null){
		                System.out.println("Nenhum produto encontrado");
		                
		            }

		            System.out.println(resultado.getNome());

		            resultado.Stock();

		            

		        }
		        if(a == 2){

		            System.out.println("Buscar por nome\nDigite o nome do produto");
		            String nome = sc.nextLine();
		            ArrayList<Product> founds = produtomanage.nomes(nome);

		            if(founds.isEmpty()){
		                System.out.println("Nenhum produto encontrado");
		                
		            }
		            System.out.println("Buscando por : "+nome);
		            for (Product p : founds ) {
		                System.out.println("\n\t"+p.getNome());
		            }
		            System.out.println(founds.size() + " produtos encontrados");

		        }

		        if (a == 3){

		            System.out.println("Remover por código\nDigite o codigo do produto para remover");
		            int id = sc.nextInt();
		            System.out.println("\n" + "Ingrese la cantidad");
		            int quant = sc.nextInt();
		            produtomanage.remover(id, quant);
		            

		        }

		        if (a == 4){

		            System.out.println("Digite o codigo do produto");
		            int id = sc.nextInt();
		            produtomanage.StockDeProdutos(id);

		           

		        }

		        
	    

	    
	   

	}
}
	
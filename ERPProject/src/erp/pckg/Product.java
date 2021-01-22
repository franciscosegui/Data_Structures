package erp.pckg;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Product {
	
	private int id;
	private String nome;
	private int total = 0;
	
	private Queue<ProductStock> queue = new LinkedList<>();
	
	private final Random rand = new Random();
	
	public Product(int id, String nome) {
		this.id = id;
		this.nome = nome;
		this.Stock();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public void Stock() {
		String dataInicial = "1/1/1970";
				
		DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yy").withResolverStyle(ResolverStyle.STRICT);
		
		LocalDate date = LocalDate.parse(dataInicial,parser);
		
		int Entradas = 1 + rand.nextInt(20);
		
		while(Entradas > 0) {
			date = date.plusDays(1);
			int randQuant =  1 + rand.nextInt(100);
			
			this.total = this.total+randQuant;
			
			queue.add(new ProductStock(randQuant, date));
			
			Entradas--;
		}
		
	}
	
	public Queue<ProductStock> getQueue(){
		return queue;
	}

}

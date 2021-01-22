package erp.pckg;

import java.time.LocalDate;

public class ProductStock {
	
	private int quantidade;
	private LocalDate data;

	public ProductStock(int quantidade, LocalDate data) {
		this.quantidade = quantidade;
		this.data=data;
	}

	

	public int getQuantidade() {
		return quantidade;
	}



	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}



	public LocalDate getData() {
		return data;
	}



	public void setData(LocalDate data) {
		this.data = data;
	}



	public String show() {
		return"Quantidade "+this.getQuantidade()+"Data "+this.getData();
	}
	
	
}

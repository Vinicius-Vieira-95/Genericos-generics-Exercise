package entities;

public class Product implements Comparable<Product>{

	private String nameProduct;
	private Double value;
	
	public Product( String name, Double value) {
		this.nameProduct = name;
		this.value = value;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return nameProduct +","+value;
	}

	@Override
	public int compareTo(Product other) {
		return value.compareTo(other.getValue()); //comparadno o preço do produto da classe ao do argumento
	}
	
}

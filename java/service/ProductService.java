package service;

import java.util.List;
import java.util.Set;

import model.Product;

public interface ProductService {

	public Product addProduct(Product product);
	public List<Product>getAllProduct();
	public Product viewByProduct(int pid);
	public List <Product> viewByBrand(String brand);
	public Set<Product> viewByCategory(String category);
	public int updateProduct(int pid,Product newProduct);
	public int removeProduct(int pid);
		
	
}

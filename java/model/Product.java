package model;

import java.util.Date;

public class Product {
	private int productId;
	private String productName;
	private String productCategory;
	private double productPrice;
	private String productBrand;
	private Date productMfd;
	/**
	 * @param productId
	 * @param productName
	 * @param productCategory
	 * @param productPrice
	 * @param productBrand
	 * @param productMfd
	 */
	public Product(int productId, String productName, String productCategory, double productPrice, String productBrand,
			Date productMfd) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
		this.productBrand = productBrand;
		this.productMfd = productMfd;
	}
	/**
	 * 
	 */
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public Date getProductMfd() {
		return productMfd;
	}
	public void setProductMfd(Date productMfd) {
		this.productMfd = productMfd;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", productPrice=" + productPrice + ", productBrand=" + productBrand
				+ ", productMfd=" + productMfd + "]";
	}

}

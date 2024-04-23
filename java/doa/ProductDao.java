package doa;

import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import model.Product;
import service.ProductService;
import utility.DBUtil;

public class ProductDao implements ProductService{

	@Override
	public Product addProduct(Product product) {


		try {
			
			Connection con=DBUtil.getConnectionWithDb();
			String insertQury="insert into Product_Table(product_name,product_category,product_price,product_brand,product_mfd) values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(insertQury);
			ps.setString(1, product.getProductName());
			ps.setString(2,product.getProductCategory());
			ps.setDouble(3, product.getProductPrice());
			ps.setString(4, product.getProductBrand());
			java.util.Date d1= product.getProductMfd();
			long milliseconds=d1.getTime();
			Date mfd=new Date(milliseconds);
			ps.setDate(5, mfd);
			int insertStatus=ps.executeUpdate();
			if(insertStatus> 0){
				return product;
			}
			
		}catch(Exception e) {
			
		}
		return null;
	}

	@Override
	public List<Product> getAllProduct() {
		List <Product> listOfProduct=new ArrayList();
		try {
			Connection con=DBUtil.getConnectionWithDb();
			String selectQuery="select * from Product_Table";
			PreparedStatement ps=con.prepareStatement(selectQuery);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int pid=rs.getInt(1);
				String pname=rs.getString(2);
				String pcat=rs.getString(3);
				double price=rs.getDouble(4);
				String brand =rs.getString(5);
				java.util.Date d1=rs.getDate(6);
				long milsec=d1.getTime();
				Date mfd=new Date(milsec);
				Product pObj=new Product(pid,pname,pcat,price,brand,mfd);
				listOfProduct.add(pObj);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return listOfProduct;
	}

	@Override
	public Product viewByProduct(int pid) {
		Product product=null;
		try {
			Connection con=DBUtil.getConnectionWithDb();
			String selectQueryById="Select * from product_table where product_id=?";
			PreparedStatement ps=con.prepareStatement(selectQueryById);
			ps.setInt(1, pid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				product =new Product();
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String category=rs.getString(3);
				double price =rs.getDouble(4);
				String brand=rs.getString(5);
				java.util.Date d1=rs.getDate(6);
				long milisec=d1.getTime();
				java.util.Date mfd=new java.util.Date(milisec);
				product.setProductId(id);
				product.setProductName(name);
				product.setProductCategory(category);
				product.setProductPrice(price);
				product.setProductBrand(brand);
				product.setProductMfd(mfd);
				return product;
			}
		}catch(Exception e) {
			
		}
		return null;
	}

	@Override
	public List<Product> viewByBrand(String brand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Product> viewByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateProduct(int pid, Product newProduct) {
		
			int result=0;
		try {
			Connection con=DBUtil.getConnectionWithDb();
			String updateQueryById="update Product_Table set product_name=?,product_category=?,product_price=?,product_brand=?,product_mfd=? where product_id=?";
			PreparedStatement ps=con.prepareStatement(updateQueryById);
			String name=newProduct.getProductName();
			String category=newProduct.getProductCategory();
			double price=newProduct.getProductPrice();
			String brand=newProduct.getProductBrand();
			ps.setString(1, name);
			ps.setString(2, category);
			ps.setDouble(3, price);
			ps.setString(4, brand);
			/*
			 * java.util.Date d=newProduct.getProduct();
			 * long millSec=d.getTime();
			 * java.sql.Date d2=new java.sql.Date(millSec);
			 */
			ps.setDate(5,new java.sql.Date(newProduct.getProductMfd().getTime()));
			ps.setInt(6, pid);
			
			result=ps.executeUpdate();
			System.out.println(result);
			if (result>0) 
		        System.out.println("successfully updated"); 

		    else
		        System.out.println("unsucessful updated "); 
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return result;
	}

	@Override
	public int removeProduct(int pid) {
		int result=0;
		try {
			Connection con=DBUtil.getConnectionWithDb();
			String deleteQueryById="delete from Product_Table where product_id=?";
			PreparedStatement ps=con.prepareStatement(deleteQueryById);
			ps.setInt(1, pid);
			result=ps.executeUpdate();
			System.out.println(result);
			if (result>0) 
		        System.out.println("successfully deleted"); 

		    else
		        System.out.println("unsuccessful delete "); 

		    
		}catch(Exception e) {
			System.out.println(e);
		}
		return result;
	}

	
}

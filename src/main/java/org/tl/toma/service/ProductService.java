package org.tl.toma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tl.toma.controller.ProductController;
import org.tl.toma.mapper.ProductMapper;
import org.tl.toma.model.Product;
import org.tl.toma.model.ProductUpmod;
import org.tl.toma.ordermodel.Ordermodel;
import org.tl.toma.mapper.OrderMapper;


@Service
public class ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	

	
	
	
	public List<Product>  getAllProduct(){
		return productMapper.getAllProduct();
	}
	
	
	public List<Product>  getProductByName(String name){
		return productMapper.getByProductName(name);
	}
	
	public boolean insertpro(Product product) {
		productMapper.insert(product);
		return true;
	}
	
	public boolean deleteProductById(int id) {
		productMapper.delete(id);
		return true;
	}
	
	public boolean updateProductById(ProductUpmod productupmod) {
		productMapper.update(productupmod);
		return true;
	}
}

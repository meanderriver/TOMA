package org.tl.toma.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete; 
import org.tl.toma.model.Product;
import org.tl.toma.model.ProductUpmod;
import org.tl.toma.ordermodel.Ordermodel;


public interface ProductMapper {
	
	@Select("select * from book_product where name=#{name}")
	public List<Product> getByProductName(String name);
	
	@Insert("insert into book_product(id,name) values(#{id},#{name})")
	  public void insert(Product productmodel);
	
	@Delete("delete from book_product where id=#{id}")
		public void delete(int id);
	
	@Update("update book_product set name=#{name} where id=#{id}")  
	public int update(ProductUpmod productUpmod);
	
	
	@Select("select * from book_product4")
	public List<Product> getAllProduct();


}

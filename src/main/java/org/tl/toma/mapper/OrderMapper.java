package org.tl.toma.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.tl.toma.model.Product;
import org.tl.toma.model.ProductUpmod;
import org.tl.toma.ordermodel.OrderUpmod;
import org.tl.toma.ordermodel.Ordermodel;

public interface OrderMapper {
	
	@Select("select * from book_order where id=#{id}")
	public List<Ordermodel> getByOrderId(int id);
	
	@Insert("insert into book_order(id,productId,quantity,price,address,buyer) values(#{id},#{productId},#{quantity},#{price},#{address},#{buyer})")
	  public void insert(Ordermodel ordermodel);
	
	@Delete("delete from book_order where id=#{id}")
	public void delete(int id);
	
	@Update("update book_order set productId=#{productId},quantity=#{quantity},price=#{price},address=#{address},buyer=#{buyer} where id=#{id}")  
	public int update(OrderUpmod orderupmod);
	
	@Select("select * from book_order")
	public List<Ordermodel> getAllOrder();
}

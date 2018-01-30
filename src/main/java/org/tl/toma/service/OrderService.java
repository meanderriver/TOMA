package org.tl.toma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tl.toma.mapper.OrderMapper;
import org.tl.toma.model.ProductUpmod;
import org.tl.toma.ordermodel.OrderUpmod;
import org.tl.toma.ordermodel.Ordermodel;

@Service
public class OrderService {
	
	@Autowired
	private OrderMapper ordermapper;
	
	public List<Ordermodel> getOrderById(int id){
		return ordermapper.getByOrderId(id);
	}
	
	public boolean sendorder(Ordermodel ordtest) {
		ordermapper.insert(ordtest);
		return true;
	}
	
	public boolean deleteOrderById(int id) {
		ordermapper.delete(id);
		return true;
	}
	
	public boolean updateOrderById(OrderUpmod orderupmod) {
		ordermapper.update(orderupmod);
		return true;
	}
	
	public List<Ordermodel> getAllOrder(){
		return ordermapper.getAllOrder();
	}
}

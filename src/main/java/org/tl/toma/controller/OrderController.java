package org.tl.toma.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tl.toma.model.Product;
import org.tl.toma.model.ProductUpmod;
import org.tl.toma.ordermodel.OrderUpmod;
import org.tl.toma.ordermodel.Ordermodel;
import org.tl.toma.service.OrderService;

@Controller
public class OrderController {
	@Resource
	private OrderService orderService;
	
	@RequestMapping(value = "/order/create", method = RequestMethod.GET)
	public String Orderindex(Model model,HttpServletRequest request) {
		return "order";
	}
	
	
	@RequestMapping(value = "/order/createindex", method = RequestMethod.GET)
	public String createOrder(Model model, HttpServletRequest request) {
		return "orderci";
	}
	
	@RequestMapping(value = "/order/save", method = RequestMethod.POST)
	public String saveProduct(Model model,HttpServletRequest request) {
		int id = Integer.valueOf(request.getParameter("id"));
		int productId = Integer.valueOf(request.getParameter("productId"));
		int quantity = Integer.valueOf(request.getParameter("quantity"));
		int price = Integer.valueOf(request.getParameter("price"));
		String address = request.getParameter("address");
		String buyer = request.getParameter("buyer");
		Ordermodel ordermodel = new Ordermodel();
		ordermodel.setId(id);
		ordermodel.setProductId(productId);
		ordermodel.setQuantity(quantity);
		ordermodel.setPrice(price);
		ordermodel.setAddress(address);
		ordermodel.setBuyer(buyer);
		orderService.sendorder(ordermodel);
		List<Ordermodel> orderList = null;
		orderList=orderService.getAllOrder();
		model.addAttribute("orderList",orderList);
		return "orderList";
	}
	
	
	@RequestMapping(value = "/order/delete", method = RequestMethod.GET)
	public String deleteOrderById(Model model,HttpServletRequest request) {
		return "orderDeleteIndex";
	}
	
	
	@RequestMapping(value = "/order/deleteres", method = RequestMethod.POST)
	public String deleteOrder(Model model,HttpServletRequest request) {
		int id = Integer.valueOf(request.getParameter("id"));
		orderService.deleteOrderById(id);
		return "orderdelete";
	}
	
	@RequestMapping(value = "/order/select", method = RequestMethod.GET)
	public String seletOrderById(Model model,HttpServletRequest request) {
		return "orderselectindex";
	}
	
	
	
	@RequestMapping(value = "/order/selectres", method = RequestMethod.POST)
	public String selectOrder(Model model,HttpServletRequest request) {
		int id = Integer.valueOf(request.getParameter("id"));
		Ordermodel ordermodel = new Ordermodel();
		ordermodel.setId(id);
		List<Ordermodel> orderList=null;
		orderList=orderService.getOrderById(id);
		model.addAttribute("orderList",orderList);
		return "orderList";
	}
	
	
	@RequestMapping(value = "/order/update", method = RequestMethod.GET)
	public String updateOrderindex(Model model,HttpServletRequest request) {
		return "orderUpDateindex";
	}
	
	
	@RequestMapping(value = "/order/updateres", method = RequestMethod.POST)
	public String updateOrder(Model model,HttpServletRequest request) {
		int id = Integer.valueOf(request.getParameter("id"));
		int productId = Integer.valueOf(request.getParameter("productId"));
		int quantity = Integer.valueOf(request.getParameter("quantity"));
		int price = Integer.valueOf(request.getParameter("price"));
		String address = request.getParameter("address");
		String buyer = request.getParameter("buyer");
		OrderUpmod ordermodel = new OrderUpmod();
		ordermodel.setId(id);
		ordermodel.setProductId(productId);
		ordermodel.setQuantity(quantity);
		ordermodel.setPrice(price);
		ordermodel.setAddress(address);
		ordermodel.setBuyer(buyer);
		orderService.updateOrderById(ordermodel);
		return "orderUpdate";
	}

}

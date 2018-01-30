package org.tl.toma.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tl.toma.model.Product;
import org.tl.toma.model.ProductUpmod;
import org.tl.toma.service.OrderService;
import org.tl.toma.service.ProductService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Controller
public class ProductController {

	@Resource
	private ProductService productService;

	@RequestMapping(value = "/api/product/{name}", method = RequestMethod.GET)
	public String getProductList(Model model, @PathVariable("name") String name) {
		List<Product> prodList = new ArrayList();
		Product prod1 = new Product();
		prod1.setId(1);
		prod1.setName("prod1");
		Product prod2 = new Product();
		prod2.setId(2);
		prod2.setName("prod2");
		prodList.add(prod1);
		prodList.add(prod2);
		model.addAttribute("productList", prodList);
		return "productList";
	}

	@RequestMapping(value = "/product/create", method = RequestMethod.GET)
	public String Productindex(Model model, HttpServletRequest request) {
		String a = "test";
		String b = "test";
		String c = new String("test");
		Product p = new Product();
		p.setId(1);
		p.setName("testname");
		return "product";
	}
	
	@RequestMapping(value = "/product/createindex", method = RequestMethod.GET)
	public String createProduct(Model model, HttpServletRequest request) {
		return "prodcreateindex";
	}
	
	@RequestMapping(value = "/product/save", method = RequestMethod.POST)
	public String saveProduct(Model model, HttpServletRequest request) {
		int id = Integer.valueOf(request.getParameter("id"));
		String name = request.getParameter("name");
		Product product = new Product();
		product.setId(id);
		product.setName(name);
		productService.insertpro(product);
		List<Product> prodList = null;
		prodList = productService.getAllProduct();
		model.addAttribute("productList", prodList);
		return "productList";
	}

	@RequestMapping(value = "/product/delete", method = RequestMethod.GET)
	public String deleteProductById(Model model, HttpServletRequest request) {
		return "proddeleteindex";
	}

	@RequestMapping(value = "/product/deleteres", method = RequestMethod.POST)
	public String deleteProduct(Model model, HttpServletRequest request) {
		int id = Integer.valueOf(request.getParameter("id"));
		productService.deleteProductById(id);
		return "productdelete";
	}

	@RequestMapping(value = "/product/update", method = RequestMethod.GET)
	public String updateProductindex(Model model, HttpServletRequest request) {
		return "produpdateindex";
	}

	@RequestMapping(value = "/product/updateres", method = RequestMethod.POST)
	public String updateProduct(Model model, HttpServletRequest request) {
		int id = Integer.valueOf(request.getParameter("id"));
		String name = request.getParameter("name");
		ProductUpmod product = new ProductUpmod();
		product.setId(id);
		product.setName(name);
		productService.updateProductById(product);
		List<Product> prodList = null;
		prodList = productService.getAllProduct();
		model.addAttribute("productList", prodList);
		return "productList";
	}

	@RequestMapping(value = "/product/select", method = RequestMethod.GET)
	public String seletProductById(Model model, HttpServletRequest request) {
		return "prodselectindex";
	}

	@RequestMapping(value = "/product/selectres", method = RequestMethod.POST)
	public String selectProduct(Model model, HttpServletRequest request) {
		JedisPoolConfig config = new JedisPoolConfig();

		  config.setMaxActive(100);

		  config.setMaxIdle(20);

		  config.setMaxWait(1000l);
		  JedisPool pool;
		  Jedis jedis;
		  pool = new JedisPool(config, "localhost", 6379);
		  jedis = pool.getResource();
		String name = request.getParameter("name");
		List<Product> prodList = new ArrayList();
		Product product = new Product();
		String vals=null;
		int flag=0;
		vals=jedis.get(name);
		if(vals=="0") {
			flag++;
		prodList = productService.getProductByName(name);
		if(prodList == null) {
			prodList = new ArrayList();
		}
		for(int i=0;i<prodList.size();i++)
		{
			product=prodList.get(i);
			jedis.set(name, String.valueOf(product.getId()));
			
		}
		}
		else {
			 product.setId(Integer.parseInt(vals));
			 product.setName(name);	 
		}
		if(flag==0) {
		prodList.add(product);
		}
		pool.returnResource(jedis);
		model.addAttribute("productList", prodList);
		return "productList";
		
		}
	
	}


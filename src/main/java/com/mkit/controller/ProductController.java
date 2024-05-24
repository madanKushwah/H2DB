package com.mkit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mkit.entity.Product;
import com.mkit.repo.ProductRepository;;

  @Controller
  public class ProductController {
	  
	@Autowired
	private ProductRepository repo;
	
	@GetMapping("/products")
	public String  productList(Model model) {
	model.addAttribute("products", repo.findAll());
		
		return "list";
	}
	 
	@GetMapping("/")
	public String loadForm(Model model)
	{
		model.addAttribute("p", new Product());
		return "index";
	}
	
	@PostMapping("/product")
	public String saveProduct(@ModelAttribute("p") Product p,Model model )
	{
		
		p=repo.save(p);
		
		if(p.getPId()!=null) {
			model.addAttribute("msg", "Product saved");
			
		}
		return "index";
		
	}

}

package com.specs.specsfrontend.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.specs.specsbackend.dao.CategoryRepository;
import com.specs.specsbackend.dao.ProductRepository;
import com.specs.specsbackend.model.Category;
import com.specs.specsbackend.model.Product;

@Controller
public class HomeController {
	@Autowired
	 Category category;
	

	@Autowired
	 Product product;
	
 @Autowired
 CategoryRepository categoryRespository;
 @Autowired
 ProductRepository productRepository;
 
	
	 @RequestMapping("/Home")
	 public String homepage()
	 {
		 
		
		 
		 return "index";
	 }
	 
	 @RequestMapping("/")
	 public String homepage1()
	 {
		 
		
		 
		 
		 
		 return "index";
	 }
	
	 
	 @RequestMapping("/LogIn")
	 public String loginpage()
	 {
		 return "LogIn";
	 }
	
	 @RequestMapping("/SignUp")
	 public String Signup()
	 {
		 return "SignUp";
	 }
	 @RequestMapping("/AdminPage")
	 
	public String adminpage()
	{	 
	 return "AdminPage";	 
	 }
	 
	 
	 @RequestMapping("/category")
  public String categoryPage(Model model)
  {
		  List<Category>allCategories=categoryRespository.getAllCategory();
     model.addAttribute("cat",category);
     model.addAttribute("categoryList",allCategories);
     return "category";
     
  }
	 @RequestMapping("/Product")
 public String productpage(Model model)
 {
	List<Product>allProduct=productRepository.getAllProduct();
	List<Category>allCategory=categoryRespository.getAllCategory();
	model.addAttribute("pro",product);
	model.addAttribute("productList",allProduct);
	model.addAttribute("categoryList",allCategory);
	return "Product";	 
	 
	 
 }
	  
	






}



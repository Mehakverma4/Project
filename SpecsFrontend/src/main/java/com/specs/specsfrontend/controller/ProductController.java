package com.specs.specsfrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.specs.specsbackend.dao.CategoryRepository;
import com.specs.specsbackend.dao.ProductRepository;
import com.specs.specsbackend.model.Category;
import com.specs.specsbackend.model.Product;

@Controller
public class ProductController {
	
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	Product product;

	@Autowired
	ProductRepository productRepository;
	
	@RequestMapping(value="/addProduct" ,method=RequestMethod.POST)
	public String ProductAdd(@ModelAttribute("pro")Product product)
	{
		if(product.getProductId()==0)
		{
			productRepository.addProduct(product);
			
		}
		else {
			productRepository.addProduct(product);
		}
		return "redirect:/product";
		
	}
	@RequestMapping("/deleteProduct/{id}")
	public String productdelete(@PathVariable("id")int productId)
	{
		productRepository.deleteProduct(productId);
		return "redirect:/product";
		
	}
	@RequestMapping("/editProduct/{id}")
public String updateProduct(@PathVariable("id")int productId,Model model) {
	Product productData=productRepository.getProductById(productId);
	model.addAttribute("pro",productData);
	List<Product>allProduct=productRepository.getAllProduct();
	List<Category>allCategory=categoryRepository.getAllCategory();
	model.addAttribute("ProductList",allProduct);
	model.addAttribute("categoryList",allCategory);
	return "Product";
}

}

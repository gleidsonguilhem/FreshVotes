package com.toastack.solution.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.toastack.solution.model.Product;
import com.toastack.solution.model.User;
import com.toastack.solution.repositories.ProductRepository;

import javassist.NotFoundException;

@Controller
public class ProductController {
	private Logger log = LoggerFactory.getLogger(ProductController.class);  
	
	@Autowired
	private ProductRepository productRepo;
	
	@GetMapping("/products/{productId}")
	public String getProducts(@PathVariable Long productId, ModelMap model, HttpServletResponse response) throws NotFoundException, IOException {
		Optional<Product> productOpt = productRepo.findByIdWithUser(productId);
		
		if(productOpt.isPresent()) {
			Product product = productOpt.get();
			model.put("product", product);
		}else {
			response.sendError(HttpStatus.NOT_FOUND.value(), "Product id: " + productId + " not found!");
			return "product";
		}
		return "product";
	}
	
	@PostMapping("/products/{productId}")
	public String saveProduct(@PathVariable Long productId, Product product) {
		product = productRepo.save(product);
		return "redirect:/products/"+product.getId();
	}
	
	@PostMapping("/products")
	public String creteProduct(@AuthenticationPrincipal User user) {
		Product product = new Product();
		
		product.setPublished(false);
		product.setUser(user);
		
		product = productRepo.save(product);
		
		return "redirect:/products/"+product.getId();
	}
	
	@GetMapping("/p/{productName}")
	public String productUserView(@PathVariable String productName, ModelMap model) {
		if(productName != null) {
			try {				
				String decodedProductName = URLDecoder.decode(productName, StandardCharsets.UTF_8.name());
				Optional<Product> productOpt = productRepo.findByName(decodedProductName);
				
				if(productOpt.isPresent()) {
					model.put("product", productOpt.get());
				}
			}catch(UnsupportedEncodingException e) {
				log.error("There was an error decoding a product URL", e);
			}
		}
		return "productUserView";
	}
}

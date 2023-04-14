package com.example.demo.Controller;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Product1;
import com.example.demo.Exception.ProductNotFoundException;
import com.example.demo.Service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/create")
	public ResponseEntity<Product1> createProduct(@Valid @RequestBody Product1 product){
		return new ResponseEntity<Product1> (productService.createProduct(product), HttpStatus.CREATED);
	}
	@GetMapping("/list")
	public ResponseEntity<List<Product1>> getAllProducts(){
		return new ResponseEntity<List<Product1>>(productService.getAllProducts(), HttpStatus.OK);
	}
	
	@GetMapping("/product/{id}")
	public Product1 getById(@PathVariable Long id) throws ProductNotFoundException{
		return productService.getById(id);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Product1> updateProduct(@PathVariable Long id, @Valid @RequestBody Product1 product)  {
		return new ResponseEntity<Product1> (productService.updateProduct(id,product), HttpStatus.OK);
	}
	
	@PatchMapping("/patchUpdate/{id}")
	public ResponseEntity<Product1> patchUpdateProduct(@PathVariable Long id, @Valid @RequestBody Product1 product){
		return new ResponseEntity<Product1> (productService.patchUpdateProduct(id,product), HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> deleteProduct(@PathVariable Long id){
		      return new ResponseEntity<String> (productService.deleteProduct(id), HttpStatus.CREATED);
	
	}

}

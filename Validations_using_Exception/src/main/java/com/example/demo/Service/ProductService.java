package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Product1;
import com.example.demo.Exception.ProductNotFoundException;

import jakarta.validation.Valid;

@Service
public interface ProductService {

	Product1 createProduct(@Valid Product1 product);

	List<Product1> getAllProducts();

	Product1 getById(Long id) throws ProductNotFoundException;

	Product1 updateProduct(Long id, @Valid Product1 product)  ;

	Product1 patchUpdateProduct(Long id, @Valid Product1 product);

	String deleteProduct(Long id);
	

}

package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Product1;
import com.example.demo.Exception.ProductNotFoundException;
import com.example.demo.Repository.ProductRepository;

import jakarta.validation.Valid;

@Service
public class ProductServiceImpl implements ProductService {
	
	
	@Autowired
	ProductRepository productRepository;
	
	boolean flag;

	@Override
	public Product1 createProduct(@Valid Product1 product) {
		// TODO Auto-generated method stub
		return productRepository.save(product) ;
	}

	@Override
	public List<Product1> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product1 getById(Long id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		Product1 product = null;
		if(id !=null && id!=0) {
			flag = productRepository.existsById(id);
		}
		if(flag) {
			product = productRepository.findById(id).get();
		}else 
			throw new ProductNotFoundException("product not found");
		return product;
	}

	@Override
	public Product1 updateProduct(Long id, @Valid Product1 product)     {
		// TODO Auto-generated method stub
		Product1 productDB = null;
		if(id !=null && id!= 0) {
			flag = productRepository.existsById(id);
			}
				
		if(flag){
			productDB = productRepository.findById(id).get();
			productDB.setName(product.getName());
			productDB.setPrice(product.getPrice());
			productDB.setDepartment(product.getDepartment());
		}
		return productRepository.save(productDB);
	}

	@Override
	public Product1 patchUpdateProduct(Long id, @Valid Product1 product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteProduct(Long id) {
		// TODO Auto-generated method stub
		if(id !=null && id!= 0) {
			flag = productRepository.existsById(id);
		}
		if(flag) 
			productRepository.deleteById(id);
		
		return "product deleted";
	}

}

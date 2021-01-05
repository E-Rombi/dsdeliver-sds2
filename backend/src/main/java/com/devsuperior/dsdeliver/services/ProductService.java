package com.devsuperior.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.entities.Product;
import com.devsuperior.dsdeliver.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll() {
		List<Product> list = repository.findAll();
		return list.stream().map(p -> new ProductDTO(p)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAllByOrderByName() {
		List<Product> list = repository.findAllByOrderByName();
		return list.stream().map(p -> new ProductDTO(p)).collect(Collectors.toList());	
	}
	
}

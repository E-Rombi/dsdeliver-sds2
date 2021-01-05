package com.devsuperior.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {
		List<Order> list = repository.findAll();
		return list.stream().map(p -> new OrderDTO(p)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findOrdersWithProducts() {
		List<Order> list = repository.findOrdersWithProducts();
		return list.stream().map(p -> new OrderDTO(p)).collect(Collectors.toList());
	}
}

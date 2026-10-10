package com.examenT2.LP2_T2_Romani_Juan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.LP2_T2_Romani_Juan.model.Producto;
import com.examenT2.LP2_T2_Romani_Juan.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService {
	
	private final ProductoRepository productoRepository;
	
	public List<Producto> getAll() {
		return productoRepository.findAll();
	}
	
}

package com.examenT2.LP2_T2_Romani_Juan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.LP2_T2_Romani_Juan.dto.ResultadoResponse;
import com.examenT2.LP2_T2_Romani_Juan.model.Inventario;
import com.examenT2.LP2_T2_Romani_Juan.repository.InventarioRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventarioService {
	private final InventarioRepository inventarioRepository;
	
	// Método Listar
	public List<Inventario> getAll() {
		return inventarioRepository.findAllByOrderByNumeroDesc();
	}

	// Método crear
	@Transactional
	public ResultadoResponse create(Inventario inventario) {
		try {
			var registrado = inventarioRepository.save(inventario);

			var mensaje = String.format("Inventario Nro. %s registrado.", registrado.getNumero());

			return new ResultadoResponse(true, mensaje);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la trasacción");
		}
	}

	// Método obtener
	public Inventario getOne(Integer id) {

		return inventarioRepository.findById(id).orElse(null);
	}

	// Método actualizar
	@Transactional
	public ResultadoResponse update(Inventario inventario) {
		try {
			var registrado = inventarioRepository.save(inventario);

			var mensaje = String.format("Inventario Nro. %s actualizado.", registrado.getNumero());

			return new ResultadoResponse(true, mensaje);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la trasacción");
		}
	}

}

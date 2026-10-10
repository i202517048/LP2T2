package com.examenT2.LP2_T2_Romani_Juan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examenT2.LP2_T2_Romani_Juan.model.Inventario;
import com.examenT2.LP2_T2_Romani_Juan.service.InventarioService;
import com.examenT2.LP2_T2_Romani_Juan.service.ProductoService;
import com.examenT2.LP2_T2_Romani_Juan.util.Alert;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("inventario")
@RequiredArgsConstructor // para el constructor InventarioService
public class InventarioController {

	private final InventarioService inventarioService;
	private final ProductoService productoService;

	// Controller que consume Service getAll
	@GetMapping("listadoRomaniJuan")
	public String listado(Model model) {
		model.addAttribute("lstInventarios", inventarioService.getAll());
		return "inventario/listadoRomaniJuan";
	}

	// Controller que consume Service create
	@GetMapping("nuevoRomaniJuan")
	public String nuevo(Model model) {
		model.addAttribute("lstProductos", productoService.getAll());
		// Inicializar el objeto del formulario.
		model.addAttribute("inventario", new Inventario());
		return "inventario/nuevoRomaniJuan";
	}

	@PostMapping("registrar")
	public String registrar(@ModelAttribute Inventario inventario, RedirectAttributes flash) {
		var response = inventarioService.create(inventario);

		var alert = Alert.sweetToast(response.mensaje(), "success", 5000);
		flash.addFlashAttribute("alert", alert);
		return "redirect:/inventario/listadoRomaniJuan";
	}

	// Controller que consume Service 
	@GetMapping("edicionRomaniJuan/{id}")
	public String edicion(@PathVariable Integer id, Model model) {

		model.addAttribute("lstProductos", productoService.getAll()); // para cargar el box productos

		model.addAttribute("inventario", inventarioService.getOne(id));

		return "inventario/edicionRomaniJuan";
	}
	
	// Controller que consume el service update
	@PostMapping("guardar")
	public String guardar(@ModelAttribute Inventario inventario, RedirectAttributes flash) {
		var response = inventarioService.update(inventario);

		var alert = Alert.sweetToast(response.mensaje(), "success", 5000);
		flash.addFlashAttribute("alert", alert);
		return "redirect:/inventario/listadoRomaniJuan";
	}

}

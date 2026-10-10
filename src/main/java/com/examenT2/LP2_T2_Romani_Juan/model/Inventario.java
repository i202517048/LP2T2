package com.examenT2.LP2_T2_Romani_Juan.model;

import java.math.BigDecimal;
import java.sql.Date;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_inventario")
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Inventario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero")
	private Integer numero;
	
	@Column(name = "fecha_vencimiento")
	private Date fechaVencimiento;
	
	@Column(name = "costo_ingreso")
	private BigDecimal costoIngreso;
	
	@Column(name = "cantidad")
	private Integer cantidad;
	
	@Column(name = "lote")
	private String lote;
	
	@Column(name = "cod_estado")
	private String codEstado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto")
	private Producto producto;
	
	public Integer getStockRestante() {
		return producto.getStockMaximo() - producto.getStockActual();
	}
}


package com.topcarservice.coreapi.domain;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class PecaInsumoSolicitado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long codigo;	
	
	private String nome;	
	
	private String modelo;
	
	private Integer quantidade;
	
	private BigDecimal valorUnitario;
	
	@ManyToOne
	@JoinColumn(name = "peca_insumo_codigo")	
	private PecaInsumo pecaInsumo;
	
	public PecaInsumoSolicitado(PecaInsumo pecaInsumo, Integer quantidade) {
		super();
		this.pecaInsumo = pecaInsumo;
		this.nome = pecaInsumo.getNome();
		this.modelo = pecaInsumo.getModelo();
		this.valorUnitario = pecaInsumo.getValorUnitario();
		this.quantidade = quantidade;
	}
	
	public BigDecimal getValorTotal() {
		return valorUnitario.multiply(BigDecimal.valueOf(quantidade));
	}

}

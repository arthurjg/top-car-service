package com.topcarservice.coreapi.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class OrdemServico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter
	private Long codigo;
	
	@Setter
	private StatusOrdemServico status;	
	
	@ManyToOne
	@JoinColumn(name = "cliente_codigo")	
	private Cliente cliente;
	
	@OneToMany
	private List<ServicoSolicitado> servicos;
	
	@OneToMany
	private List<PecaInsumoSolicitado> pecasInsumos;
	
	private LocalDateTime dataAbertura;
	
	public OrdemServico() {
		super();
		dataAbertura = LocalDateTime.now();
		status = StatusOrdemServico.RECEBIDA;		
		servicos = new ArrayList<>();		
		pecasInsumos = new ArrayList<>();
	}	

	public OrdemServico(Cliente cliente) {
		this();
		this.cliente = cliente;			
	}	

}

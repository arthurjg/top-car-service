package com.topcarservice.coreapi.domain;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class ServicoSolicitado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long codigo;	
	
	private String nome;
	
	private BigDecimal valorMaoDeObra;		
	
	@ManyToOne
	private Servico servico;

	public ServicoSolicitado(Servico servico) {
		super();
		this.servico = servico;
		this.nome = servico.getNome();
		this.valorMaoDeObra = servico.getValorMaoDeObra();
	}
	
	

}

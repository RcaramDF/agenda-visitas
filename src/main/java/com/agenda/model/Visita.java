package com.agenda.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Visita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "consultor_id")
    private Consultor consultor;

    private LocalDate dataVisita;
    private LocalDate dataRetorno;
    private Double valorProposta;
    private String numeroOrcamento;
    private String observacoes;

    @Enumerated(EnumType.STRING)
    private StatusVisita status;

    public enum StatusVisita {
        AGENDADA, CONCLUIDA, CANCELADA, REAGENDADA
    }
}

package com.intercorp.challenge.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoUnico;
    @Column(nullable = false)
    @NotBlank(message = "Todo cliente debe tener nombres!")
    private String nombres;
    @Column(nullable = false)
    @NotBlank(message = "Todo cliente debe tener apellidos!")
    private String apellidos;
    @Column(nullable = false)
    @NotBlank(message = "Todo cliente debe tener tipo de documento!")
    private String tipoDocumento;
    @Column(nullable = false)
    @NotBlank(message = "Todo cliente debe tener numero de documento!")
    private String numeroDocumento;

}

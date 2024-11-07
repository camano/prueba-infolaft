package com.prueba.infolaft.infrastructure.adapter.postgres.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "estado")
public class EstadoEntinty {

    @Id
    @Column(name = "estadoId")
    private Long estadoId;

    @Column(name = "nombreEstado")
    private String nombreEstado;
}

package com.studie.usuario.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "telefone")
@Builder
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numero",  length = 10)
    private String numero;
    @Column(name ="DDD", length = 3)
    private String ddd;
}

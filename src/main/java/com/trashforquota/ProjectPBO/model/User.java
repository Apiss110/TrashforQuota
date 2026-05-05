package com.trashforquota.ProjectPBO.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "users")
@Data // Ini magic dari Lombok: otomatis bikin Getter, Setter, toString, dll.
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nama;
    
    @Column(name = "nomor_hp")
    private String nomorHp;

    private int totalPoin;
}
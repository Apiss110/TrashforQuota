package com.trashforquota.ProjectPBO.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "reward")
@Inheritance(strategy = InheritanceType.JOINED) // Sinkron dengan skema SQL Joined
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reward")
    private Long idReward;

    @Column(name = "nama_reward")
    private String namaReward;

    @Column(name = "poin_dibutuhkan")
    private int poinDibutuhkan;

    private String provider;
}
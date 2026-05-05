package com.trashforquota.ProjectPBO.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "kuota_internet")
@PrimaryKeyJoinColumn(name = "id_reward")
@Data
@EqualsAndHashCode(callSuper = true)
public class KuotaInternet extends Reward {
    @Column(name = "jumlah_gb")
    private double jumlahGb;

    @Column(name = "masa_aktif_hari")
    private int masaAktifHari;
}
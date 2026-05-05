package com.trashforquota.ProjectPBO.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaksi")
@Data
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaksi")
    private Long idTransaksi;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_reward")
    private Reward reward;

    @Enumerated(EnumType.STRING)
    @Column(name = "jenis_transaksi")
    private JenisTransaksi jenisTransaksi;

    @Column(name = "jumlah_poin")
    private int jumlahPoin;

    private String detail;

    private LocalDateTime tanggal = LocalDateTime.now();

    public enum JenisTransaksi {
        SETOR_SAMPAH, TUKAR_PULSA, TUKAR_KUOTA
    }
}
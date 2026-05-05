package com.trashforquota.ProjectPBO.service;

import com.trashforquota.ProjectPBO.model.*;
import com.trashforquota.ProjectPBO.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RewardService {
    private final UserRepository userRepository;
    private final RewardRepository rewardRepository;
    private final TransaksiRepository transaksiRepository;

    public RewardService(UserRepository userRepository, RewardRepository rewardRepository, TransaksiRepository transaksiRepository) {
        this.userRepository = userRepository;
        this.rewardRepository = rewardRepository;
        this.transaksiRepository = transaksiRepository;
    }

    @Transactional
    public String tukarPoin(Long userId, Long rewardId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User tidak ditemukan"));
        Reward reward = rewardRepository.findById(rewardId)
                .orElseThrow(() -> new RuntimeException("Reward tidak tersedia"));

        // Validasi poin
        if (user.getPoin() < reward.getPoinDibutuhkan()) {
            return "Gagal: Poin tidak cukup. Saldo Anda: " + user.getPoin();
        }

        // Potong poin user
        user.setPoin(user.getPoin() - reward.getPoinDibutuhkan());
        userRepository.save(user);

        // Tentukan jenis transaksi untuk pencatatan
        Transaksi.JenisTransaksi jenis = (reward instanceof KuotaInternet) 
                ? Transaksi.JenisTransaksi.TUKAR_KUOTA 
                : Transaksi.JenisTransaksi.TUKAR_PULSA;

        // Catat riwayat penukaran
        Transaksi t = new Transaksi();
        t.setUser(user);
        t.setReward(reward);
        t.setJenisTransaksi(jenis);
        t.setJumlahPoin(-reward.getPoinDibutuhkan()); // Simpan sebagai angka negatif agar mudah dihitung
        t.setDetail("Penukaran " + reward.getNamaReward() + " (" + reward.getProvider() + ")");
        
        transaksiRepository.save(t);

        return "Berhasil menukar poin dengan " + reward.getNamaReward();
    }
}
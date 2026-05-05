package com.trashforquota.ProjectPBO.repository;

import com.trashforquota.ProjectPBO.model.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardRepository extends JpaRepository<Reward, Long> {
    // Bisa ditambah method untuk filter berdasarkan provider jika perlu
}

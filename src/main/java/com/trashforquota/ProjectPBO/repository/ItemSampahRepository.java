package com.trashforquota.ProjectPBO.repository;

import com.trashforquota.ProjectPBO.model.ItemSampah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemSampahRepository extends JpaRepository<ItemSampah, Long> {
}
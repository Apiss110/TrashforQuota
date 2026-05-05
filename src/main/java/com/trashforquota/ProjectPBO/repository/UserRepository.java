package com.trashforquota.ProjectPBO.repository;

import com.trashforquota.ProjectPBO.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Dipakai Spring Security untuk proses login
    Optional<User> findByUsername(String username);
}
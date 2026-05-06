package com.trashforquota.ProjectPBO.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "nomor_hp")
    private String nomorHp;

    private int poin;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        ADMIN, USER
    }

    // ✅ TAMBAHAN (biar cocok dengan HTML)
    public String getNoHp() {
        return nomorHp;
    }

    public void setNoHp(String noHp) {
        this.nomorHp = noHp;
    }
}
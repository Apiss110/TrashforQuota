package com.trashforquota.ProjectPBO.service;

import com.trashforquota.ProjectPBO.model.User;
import com.trashforquota.ProjectPBO.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(User user) {
        // Enkripsi password sebelum simpan ke DB
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        // Default values untuk user baru
        user.setRole(User.Role.USER); 
        user.setPoin(0); 
        
        userRepository.save(user);
    }
}
package org.proyectofinal.OnFieldTBS.services;

import org.proyectofinal.OnFieldTBS.domains.dtos.RequestNewUser;
import org.proyectofinal.OnFieldTBS.domains.dtos.ResponseUser;
import org.proyectofinal.OnFieldTBS.domains.models.User;
import org.proyectofinal.OnFieldTBS.domains.models.projections.UserBasic;
import org.proyectofinal.OnFieldTBS.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean ifExist(String username){
        return userRepository.findByUsername(username) != null;
    }

    public UUID getUserId(String username){
        return userRepository.findByUsername(username).getUserId();
    }

    public List<UserBasic> getAllUsers(){
        return userRepository.findBy();
    }

    public ResponseUser addNewUser(RequestNewUser newUser){
        User user = new User();
        user.setUsername(newUser.username);
        user.setPassword(passwordEncoder.encode(newUser.password));
        user.setEnabled(true);
        userRepository.save(user);
        return ResponseUser.user(user);
    }
}

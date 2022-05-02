package org.proyectofinal.OnFieldTBS.services;

import org.proyectofinal.OnFieldTBS.domains.dtos.RequestNewUser;
import org.proyectofinal.OnFieldTBS.domains.dtos.ResponseUser;
import org.proyectofinal.OnFieldTBS.domains.models.User;
import org.proyectofinal.OnFieldTBS.repositories.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRespository userRespository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    public boolean ifExist(String username){
        return userRespository.findByUsername(username) != null;
    }

    public UUID getUserId(String username){
        return userRespository.findByUsername(username).getUserId();
    }

    public List<User> getAllUsers(){
        return userRespository.findAll();
    }

    public ResponseUser addNewUser(RequestNewUser newUser){
        User user = new User();
        user.setUsername(newUser.username);
        user.setPassword(passwordEncoder.encode(newUser.password));
        user.setEnabled(true);
        userRespository.save(user);
        return ResponseUser.user(user);
    }
}

package org.proyectofinal.OnFieldTBS.repositories;

import org.proyectofinal.OnFieldTBS.domains.models.User;
import org.proyectofinal.OnFieldTBS.domains.models.projections.UserBasic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    User findByUsername(String username);
    List<UserBasic> findBy();
}

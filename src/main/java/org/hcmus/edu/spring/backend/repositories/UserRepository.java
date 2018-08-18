package org.hcmus.edu.spring.backend.repositories;

import org.hcmus.edu.spring.backend.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}

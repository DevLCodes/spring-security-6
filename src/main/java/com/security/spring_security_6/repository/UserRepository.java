package com.security.spring_security_6.repository;

import com.security.spring_security_6.entity.User;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}

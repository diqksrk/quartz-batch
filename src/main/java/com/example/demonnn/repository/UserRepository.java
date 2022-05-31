package com.example.demonnn.repository;

import com.example.demonnn.entity.User;
import com.example.demonnn.enums.UserStatus;
import com.example.demonnn.entity.User;
import com.example.demonnn.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUpdatedDateBeforeAndStatusEquals(LocalDateTime localDateTime, UserStatus status);
}

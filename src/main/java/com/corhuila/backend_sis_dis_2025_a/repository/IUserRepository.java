package com.corhuila.backend_sis_dis_2025_a.repository;

import com.corhuila.backend_sis_dis_2025_a.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}

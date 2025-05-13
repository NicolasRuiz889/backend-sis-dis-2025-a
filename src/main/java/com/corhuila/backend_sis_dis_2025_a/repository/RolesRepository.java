package com.corhuila.backend_sis_dis_2025_a.repository;

import com.corhuila.backend_sis_dis_2025_a.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
}

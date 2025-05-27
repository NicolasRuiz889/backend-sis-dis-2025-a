package com.corhuila.backend_sis_dis_2025_a.repository;

import com.corhuila.backend_sis_dis_2025_a.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonaRepository extends JpaRepository<Person, Long> {
}

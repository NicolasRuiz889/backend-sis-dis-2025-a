package com.corhuila.backend_sis_dis_2025_a.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.corhuila.backend_sis_dis_2025_a.entity.Campus;


public interface ICampusRepository extends JpaRepository<Campus, Long> {
    
}

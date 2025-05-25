package com.corhuila.backend_sis_dis_2025_a.entity;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "activitycatalog")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityCatalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "activity_name", nullable = false)
    private String name;
    
}

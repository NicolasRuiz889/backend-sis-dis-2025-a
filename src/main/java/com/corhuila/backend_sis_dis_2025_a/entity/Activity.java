package com.corhuila.backend_sis_dis_2025_a.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "activity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "agendas")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "activity_name", nullable = false)
    private String name;

    @Column(name = "weekly_hours")
    private Integer weeklyHours;

    @Column(name = "semester_hours")
    private Integer semesterHours;

    private String description;
    private String product;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subcategory_id", nullable = false)
    private SubcategoryActivity subcategory;

    @OneToMany(
            mappedBy = "activity",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Agenda> agendas;
}


package com.corhuila.backend_sis_dis_2025_a.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "subcategory_activity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "activities")
public class SubcategoryActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subcategory_name", nullable = false)
    private String name;

    private String description;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(
            mappedBy = "subcategory",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Activity> activities;
}


package com.corhuila.backend_sis_dis_2025_a.entity;



import com.corhuila.backend_sis_dis_2025_a.dto.GroupDto.GroupDtoBuilder;

import jakarta.persistence.*;

import lombok.*;


@Entity
@Table(name = "groups")
@Data
@Builderpublic GroupDtoBuilder quota(Object object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'quota'");
    }
@AllArgsConstructor
@NoArgsConstructor

public class Group {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;


@Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}

package com.corhuila.backend_sis_dis_2025_a.entity;


import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "persons")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name",  nullable = false)
    @NotNull
    private String firstName;

    @Column(name = "last_name",  nullable = false)
    @NotNull
    private String lastName;

    @Column(name = "email",  nullable = false)
    @NotNull
    private String email;

    @Column(name = "phone_number",  nullable = false)
    @NotNull
    private String phoneNumber;

    
    
}

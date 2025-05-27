package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.request.UserRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.UserResponse;
import com.corhuila.backend_sis_dis_2025_a.entity.Person;
import com.corhuila.backend_sis_dis_2025_a.entity.User;
import com.corhuila.backend_sis_dis_2025_a.repository.IPersonaRepository;
import com.corhuila.backend_sis_dis_2025_a.repository.IUserRepository;
import com.corhuila.backend_sis_dis_2025_a.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository repo;
    private final IPersonaRepository personRepo;

    private User toEntity(UserRequest r) {
        Person person = personRepo.findById(r.getPersonId())
                .orElseThrow(() -> new RuntimeException("Person not found"));
        return User.builder()
                .username(r.getUsername())
                .password(r.getPassword())
                .enabled(r.getEnabled())
                .PersonId(person)
                .build();
    }

    private UserResponse toResponse(User u) {
        return UserResponse.builder()
                .id(u.getId())
                .username(u.getUsername())
                .enabled(u.getEnabled())
                .personId(u.getPersonId().getId())
                .fullName(u.getPersonId().getFirstName() + " " + u.getPersonId().getLastName())
                .build();
    }

    public UserResponse create(UserRequest r) {
        return toResponse(repo.save(toEntity(r)));
    }

    public UserResponse update(Long id, UserRequest r) {
        User u = repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        u.setUsername(r.getUsername());
        u.setPassword(r.getPassword());
        u.setEnabled(r.getEnabled());
        u.setPersonId(personRepo.findById(r.getPersonId())
                .orElseThrow(() -> new RuntimeException("Person not found")));
        return toResponse(repo.save(u));
    }

    public void delete(Long id) { repo.deleteById(id); }

    public UserResponse findById(Long id) {
        return repo.findById(id).map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<UserResponse> findAll() {
        return repo.findAll().stream().map(this::toResponse).collect(Collectors.toList());
    }
}


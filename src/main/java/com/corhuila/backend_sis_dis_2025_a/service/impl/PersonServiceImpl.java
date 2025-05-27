package com.corhuila.backend_sis_dis_2025_a.service.impl;

import com.corhuila.backend_sis_dis_2025_a.dto.request.PersonRequest;
import com.corhuila.backend_sis_dis_2025_a.dto.response.PersonResponse;
import com.corhuila.backend_sis_dis_2025_a.entity.Person;
import com.corhuila.backend_sis_dis_2025_a.repository.IPersonaRepository;
import com.corhuila.backend_sis_dis_2025_a.service.IPersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements IPersonService {

    private final IPersonaRepository repo;

    private Person toEntity(PersonRequest r) {
        return Person.builder()
                .firstName(r.getFirstName())
                .lastName(r.getLastName())
                .email(r.getEmail())
                .phoneNumber(r.getPhoneNumber())
                .build();
    }

    private PersonResponse toResponse(Person p) {
        return PersonResponse.builder()
                .id(p.getId())
                .firstName(p.getFirstName())
                .lastName(p.getLastName())
                .email(p.getEmail())
                .phoneNumber(p.getPhoneNumber())
                .build();
    }

    public PersonResponse create(PersonRequest r) { return toResponse(repo.save(toEntity(r))); }

    public PersonResponse update(Long id, PersonRequest r) {
        Person p = repo.findById(id).orElseThrow(() -> new RuntimeException("Person not found"));
        p.setFirstName(r.getFirstName());
        p.setLastName(r.getLastName());
        p.setEmail(r.getEmail());
        p.setPhoneNumber(r.getPhoneNumber());
        return toResponse(repo.save(p));
    }

    public void delete(Long id) { repo.deleteById(id); }

    public PersonResponse findById(Long id) {
        return repo.findById(id).map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Person not found"));
    }

    public List<PersonResponse> findAll() {
        return repo.findAll().stream().map(this::toResponse).collect(Collectors.toList());
    }
}


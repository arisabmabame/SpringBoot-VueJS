package com.arisabma.registration.service;

import com.arisabma.registration.model.Registration;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RegistrationService {

    List<Registration> findAll();
    Optional<Registration> getById(UUID id);


    void save(Registration registration);
    void update(Registration registration);
    void delete(UUID id);
    List<Registration> findByFullName(String fullName);

}

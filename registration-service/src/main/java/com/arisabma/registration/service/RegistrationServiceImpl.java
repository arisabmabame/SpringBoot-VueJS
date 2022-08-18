package com.arisabma.registration.service;

import com.arisabma.registration.model.Registration;
import com.arisabma.registration.repository.RegistrationRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    final Logger log = LoggerFactory.getLogger(RegistrationService.class);

    @Autowired
    private RegistrationRepo registrationRepo;

    @Override
    public List<Registration> findAll() {
        return registrationRepo.findAll();
    }

    @Override
    public Optional<Registration> getById(UUID id) {
        return registrationRepo.findById(id);
    }

    @Override
    public void save(Registration registration) {
        log.info("Save data {}", registration);
        try {
            registrationRepo.save(registration);
        } catch (Exception e) {
            log.error("Error save", e);
        }
    }
    @Override
    public void update(Registration registration) {
        log.info("Update data {}", registration);

        try {
            registrationRepo.save(registration);
        } catch (Exception e) {
            log.error("Error update", e);
        }
    }
    @Override
    public List<Registration> findByFullName(String fullName) {

    return registrationRepo.findByFullNameContainingIgnoreCase(fullName);
    }

    @Override
    public void delete(UUID id) {
        log.info("Delete data {}", id);
        try {
            registrationRepo.deleteById(id);
        } catch (Exception e) {
            log.error("Error delete", e);
        }
    }
}

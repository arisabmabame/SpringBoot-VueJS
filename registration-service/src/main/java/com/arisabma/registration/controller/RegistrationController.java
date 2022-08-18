package com.arisabma.registration.controller;

import com.arisabma.registration.model.Registration;
import com.arisabma.registration.service.RegistrationService;
import com.arisabma.registration.service.RegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;
    private String fullName;

    @GetMapping("/registrations")
    public List<Registration> getAll() {
        return registrationService.findAll();
    }

    @GetMapping("/registrations/{id}")
    public Registration getById(@PathVariable(name = "id")  String id) {
        return registrationService.getById(UUID.fromString(id)).get();
    }

    @PostMapping("/registrations")
    public void save(@RequestBody Registration registration) {
        registrationService.save(registration);
    }

    @PutMapping("/registrations")
    public void update(@RequestBody Registration registration) {
        registrationService.update(registration);
    }

    @DeleteMapping("/registrations/{id}")
    public void deleteById(@PathVariable(name = "id")  UUID id) {
       registrationService.delete(id);
    }

    @GetMapping("/registrations/find-by-name")
    public List<Registration> findByFullName(@RequestParam(name = "name") String fullName) {
        return registrationService.findByFullName(fullName);
    }



}

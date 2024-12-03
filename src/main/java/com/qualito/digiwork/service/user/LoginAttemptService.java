package com.qualito.digiwork.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoginAttemptService {

    @Autowired
    private LoginAttemptRepository repository;

    public void logAttempt(String username, boolean successful) {
        LoginAttempt attempt = new LoginAttempt();
        attempt.setUsername(username);
        attempt.setTimestamp(LocalDateTime.now());
        attempt.setSuccessful(successful);
        repository.save(attempt);
    }

    public List<LoginAttempt> findAllAttempts() {
        return repository.findAll();
    }
}

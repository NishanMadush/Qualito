package com.qualito.digiwork.service.user;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LoginAttempt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private LocalDateTime timestamp;
    private boolean successful;
    private String formattedTimestamp;
    // Getters and Setters
    public Long getId() { 
    	return id; 
    	}
    public void setId(Long id) { 
    	this.id = id; 
    	}

    public String getUsername() { 
    	return username; 
    	}
    public void setUsername(String username) { 
    	this.username = username; 
    	}

    public LocalDateTime getTimestamp() { 
    	return timestamp; 
    	}
    public void setTimestamp(LocalDateTime timestamp) { 
    	this.timestamp = timestamp; 
    	}

    public boolean isSuccessful() { 
    	return successful; 
    	}
    public void setSuccessful(boolean successful) { 
    	this.successful = successful; 
    	}
    public String getFormattedTimestamp() {
        return formattedTimestamp;
    }

    public void setFormattedTimestamp(String formattedTimestamp) {
        this.formattedTimestamp = formattedTimestamp;
    }
}

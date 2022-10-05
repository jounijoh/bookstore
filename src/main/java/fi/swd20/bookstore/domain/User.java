package fi.swd20.bookstore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
	
	// Username with unique constraint
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String passwordHash;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "role", nullable = false)
	private String role;
	
	// KONSTRUKTORIT
	public User() {
	}

	public User(String username, String passwordHash, String email, String role) {
		this.username = username;
		this.passwordHash = passwordHash;
		this.email = email;
		this.role = role;
	}
	
	// SETTERIT
	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	// GETTERIT
	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public String getEmail() {
		return email;
	}

	public String getRole() {
		return role;
	}
	
	
}

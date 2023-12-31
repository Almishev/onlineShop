package online.handsmade.shop.model;

import online.handsmade.shop.validators.ValidEmail;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.Collections;

@Entity
public class MyUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @NotEmpty(message = "Username must not be empty")
    @Size(min = 2, message = "min two symbols")
    @Size(max = 30, message = "Max 30 symbols")
    private String username;
    @NotEmpty(message = "Password must not be empty")
    @NotBlank
    private String password;
    private String passwordMatcher;
    @ValidEmail(message = "Enter valid email")
    @NotBlank
    @NotEmpty(message = "Email must not be empty")
    private String email;
    private String role;


    public String getPasswordMatcher() {
        return passwordMatcher;
    }

    public void setPasswordMatcher(String passwordMatcher) {
        this.passwordMatcher = passwordMatcher;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public MyUser(@NotBlank @NotEmpty(message = "Username nie może być pusty") @Size(min = 2, message = "Zbyt krótka nazwa konta") @Size(max = 30, message = "Zbyt długa nazwa konta") String username, @NotEmpty(message = "Haslo nie moze byc puste") @NotBlank String password, String passwordMatcher, @Email @NotBlank @NotEmpty(message = "Pole email nie moze byc puste") String email, String role) {
        this.username = username;
        this.password = password;
        this.passwordMatcher = passwordMatcher;
        this.email = email;
        this.role = role;
    }

    public MyUser(@NotBlank @NotEmpty(message = "Username cannot be empty") @Size(min = 2, message = "Account name is too short") @Size(max = 30, message = "Account name too long") String username, @NotEmpty(message = "The password cannot be empty") @NotBlank String password, String passwordMatcher, @Email @NotBlank @NotEmpty(message = "The email field cannot be empty") String email) {
        this.username = username;
        this.password = password;
        this.passwordMatcher = passwordMatcher;
        this.email = email;
    }

    public MyUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return Collections.singleton(new SimpleGrantedAuthority(role));
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

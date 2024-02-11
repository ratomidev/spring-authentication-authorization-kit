package com.rami.toumi.sprinauthkit.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false)
    @Length(min = 8)
    @NotBlank
    private String username;
    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    @NotBlank
    private String email;
    @Column(nullable = false)
    private boolean enabled;
    @Transient
    private String roles;
    @Transient
    private String permissions;
    public List<String> getRolesList() {
        if(this.roles.length()>0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }
    public List<String> getPermissionsList() {
        if(this.permissions.length()>0) {
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }
}

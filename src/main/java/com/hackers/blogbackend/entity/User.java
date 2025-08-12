package com.hackers.blogbackend.entity;

import com.hackers.blogbackend.entity.enom.EStatut;
import com.hackers.blogbackend.utils.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "avatar", nullable = true)
    private String avatar;
    @Column(name = "bio", nullable = true)
    private String bio;
    @Enumerated(EnumType.STRING)
    @Column(name = "statut", nullable = false)
    private EStatut statut;
    @Column(name = "reputation", nullable = true)
    private String reputation;
    @Column(name = "preference", nullable = true)
    private String preference;

    
    
    @Column(name = "last_login", nullable = true)
    private String lastLogin;
    @Column(name = "last_activity", nullable = true)
    private String lastActivity;
    private boolean enabled;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_badges",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "badge_id"))
    private Set<Badge> badges = new HashSet<>();
    
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", bio='" + bio + '\'' +
                ", statut=" + statut +
                ", reputation='" + reputation + '\'' +
                ", preference='" + preference + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", lastLogin='" + lastLogin + '\'' +
                ", lastActivity='" + lastActivity + '\'' +
                '}';    
            }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return id != null && id.equals(user.id);
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
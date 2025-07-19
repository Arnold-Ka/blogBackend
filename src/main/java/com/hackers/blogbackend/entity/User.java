package com.hackers.blogbackend.entity;

import com.hackers.blogbackend.entity.enom.EStatut;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    @Column(name = "role", nullable = false)
    private String role;
    @Enumerated(EnumType.STRING)
    @Column(name = "statut", nullable = false)
    private EStatut statut;
    @Column(name = "reputation", nullable = true)
    private String reputation;
    @Column(name = "preference", nullable = true)
    private String preference;
    @Column(name = "created_at", nullable = false)
    private String createdAt;
    @Column(name = "updated_at", nullable = false)
    private String updatedAt;
    

    @Column(name = "last_login", nullable = true)
    private String lastLogin;
    @Column(name = "last_activity", nullable = true)
    private String lastActivity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "badge_id", nullable = true)
    private Badge badge;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", bio='" + bio + '\'' +
                ", role='" + role + '\'' +
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
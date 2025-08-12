package com.hackers.blogbackend.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.Set;

import com.hackers.blogbackend.entity.enom.EStatut;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String avatar;
    private String bio;
    private EStatut statut;
    private String reputation;
    private String preference;
    private String lastLogin;
    private String lastActivity;
    private boolean enabled;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private Set<BadgeDto> badges;
    private Set<String> roles; 
    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", bio='" + bio + '\'' +
                ", statut='" + statut + '\'' +
                ", avatar='" + avatar + '\'' +
                ", reputation='" + reputation + '\'' +
                ", preference='" + preference + '\'' +
                ", lastLogin='" + lastLogin + '\'' +
                ", lastActivity='" + lastActivity + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return id != null && id.equals(userDto.id);
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

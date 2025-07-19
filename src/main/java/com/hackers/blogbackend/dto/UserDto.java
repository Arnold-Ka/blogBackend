package com.hackers.blogbackend.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
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
    private String password;
    private String bio;
    private String role;
    private String status;
    private String avatar;
    private String reputation;
    private String preference;
    private String lastLogin;
    private long badgeId;
    
    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", bio='" + bio + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                ", avatar='" + avatar + '\'' +
                ", reputation='" + reputation + '\'' +
                ", preference='" + preference + '\'' +
                ", lastLogin='" + lastLogin + '\'' +
                ", badgeId='" + badgeId + '\'' +
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

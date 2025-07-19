package com.hackers.blogbackend.dto;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BadgeDto {
    private Long id;
    private String name;
    private String description;
    private String iconUrl;
    private String criteria;
    private String awardedAt;
    private String awardedBy;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BadgeDto badgeDto = (BadgeDto) o;
        return id.equals(badgeDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

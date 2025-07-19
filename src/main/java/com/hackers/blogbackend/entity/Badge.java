package com.hackers.blogbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;

@Entity
@Table(name = "badges")
@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
@Builder
public class Badge {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = true)
    private String description;
    @Column(name = "icon_url", nullable = true)
    private String iconUrl;
    @Column(name = "criteria", nullable = true)
    private String criteria;
    @Column(name = "awarded_at", nullable = true)
    private String awardedAt;
    @Column(name = "awarded_by", nullable = true)
    private String awardedBy;
    @Column(name = "created_at", nullable = true)
    private String createdAt;
    @Column(name = "updated_at", nullable = true)
    private String updatedAt;

    @Override
    public String toString() {
        return "Badge{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", criteria='" + criteria + '\'' +
                ", awardedAt='" + awardedAt + '\'' +
                ", awardedBy='" + awardedBy + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Badge badge = (Badge) o;
        return id != null && id.equals(badge.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}

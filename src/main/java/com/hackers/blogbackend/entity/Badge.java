package com.hackers.blogbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.hackers.blogbackend.utils.BaseEntity;

import jakarta.persistence.Column;

@Entity
@Table(name = "badges")
@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class Badge extends BaseEntity {
    
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = true)
    private String description;
    @Column(name = "icon_url", nullable = true)
    private String iconUrl;
    @Column(name = "criteria", nullable = true)
    private String criteria;
    

    @Override
    public String toString() {
        return "Badge{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", criteria='" + criteria + '\'' +
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

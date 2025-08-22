package com.hackers.blogbackend.entity;

import com.hackers.blogbackend.utils.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notifications")
public class Notification extends BaseEntity {

    @Column(name = "title")
    private String title;
    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "link", nullable = false)
    private String link;
    @Column(name = "read", nullable = false)
    private boolean read;
    

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", link='" + link + '\'' +
                ", read=" + read +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return id != null && id.equals(that.id);
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

package com.hackers.blogbackend.entity;

import com.hackers.blogbackend.utils.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ai_recommendations")
public class AiRecommendation extends BaseEntity {
    @Column(name = "titre")
    private String title;
    @Column(name = "score", nullable = false)
    private String score;
    @Column(name = "recommendation", nullable = false)
    private String recommendation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @Override
    public String toString() {
        return "AiRecommendation{" +
                "id=" + id +
                ", score='" + score + '\'' +
                ", recommendation='" + recommendation + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AiRecommendation that = (AiRecommendation) o;
        return id != null && id.equals(that.id);
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

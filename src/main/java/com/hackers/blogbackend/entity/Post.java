package com.hackers.blogbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "slug", nullable = false, unique = true)
    private String slug;
    @Column(name = "content", nullable = false)
    private String content;
    @Column(name = "ai_summary", nullable = false)
    private String aiSummary;
    @Column(name = "view", nullable = false)
    @Builder.Default
    private boolean view = false;
    @Builder.Default
    @Column(name = "published", nullable = false)
    private boolean published = false;
    @Column(name = "estimate_time_to_read", nullable = false)
    private String estimateTimeToRead;
    @Column(name = "difficulty", nullable = false)
    private String difficulty;
    @Column(name = "created_at", nullable = false)
    private String createdAt;
    @Column(name = "updated_at", nullable = false)
    private String updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", nullable = true)
    private Tag tag;

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", slug='" + slug + '\'' +
                ", content='" + content + '\'' +
                ", aiSummary='" + aiSummary + '\'' +
                ", view=" + view +
                ", published=" + published +
                ", estimateTimeToRead='" + estimateTimeToRead + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id != null && id.equals(post.id);
    
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
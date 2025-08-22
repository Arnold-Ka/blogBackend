package com.hackers.blogbackend.entity;

import java.util.HashSet;
import java.util.Set;

import com.hackers.blogbackend.utils.BaseEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts")
public class Post extends BaseEntity {
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "slug", unique = true)
    private String slug;
    
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;
    
    @Column(name = "ai_summary", columnDefinition = "TEXT")
    private String aiSummary;
    
    @Column(name = "view")
    private boolean view;
    @Column(name = "published")
    private boolean published;
    
    @Column(name = "estimate_time_to_read")
    private String estimateTimeToRead;
    
    @Column(name = "difficulty")
    private String difficulty;
    @Column(name = "media")
    private String media;


    @OneToMany(fetch = FetchType.LAZY)
    private Set<Comment> comments = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id")
    private Category category;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "post_tags",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;

}

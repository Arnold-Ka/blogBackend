package com.hackers.blogbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
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
@Table(name = "quiz_blocks")
public class QuizBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "question", nullable = false)
    private String question;
    
    @Column(name = "options", nullable = false)
    private String options; 
    
    @Column(name = "correct_answer", nullable = false)
    private String correctAnswer;
    @Column(name = "explanation")
    private String explanation;
    
    @Column(name = "created_at", nullable = false)
    private String createdAt;
    
    @Column(name = "updated_at", nullable = false)
    private String updatedAt;

    @Override
    public String toString() {
        return "QuizBlock{" +
                "id=" + id +
                ", question='" + question + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuizBlock quizBlock = (QuizBlock) o;
        return id != null && id.equals(quizBlock.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

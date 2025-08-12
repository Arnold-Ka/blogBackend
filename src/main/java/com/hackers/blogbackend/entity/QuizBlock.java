package com.hackers.blogbackend.entity;

import jakarta.persistence.Entity;

import com.hackers.blogbackend.utils.BaseEntity;

import jakarta.persistence.Column;
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
@Table(name = "quiz_blocks")
public class QuizBlock extends BaseEntity {
    
    @Column(name = "question", nullable = false)
    private String question;
    
    @Column(name = "options", nullable = false)
    private String options; 
    
    @Column(name = "correct_answer", nullable = false)
    private String correctAnswer;
    @Column(name = "explanation")
    private String explanation;
    

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

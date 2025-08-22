package com.hackers.blogbackend.utils;

import java.time.Instant;
import java.util.Objects;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.hackers.blogbackend.entity.enom.EStatut;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;



@MappedSuperclass
@EntityListeners({AuditingEntityListener.class,VersionListening.class})
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(
        name = "id"
    )
    protected String id;

    @CreatedDate
    @Column(updatable = false,
        nullable = false,
        name = "created_date"
    )
    protected Instant createdAt;

    @LastModifiedDate
    @Column(
        name = "last_modified_date"
    )
    protected Instant updatedAt;

    @Column(
        name = "created_by",
        nullable = false,
        length = 50,
        updatable = false
    )
    @CreatedBy
    protected String createdBy;
    @Column(
        name = "last_modified",
        length = 50
    )
    @LastModifiedBy
    protected String lastModifiedBy;
    @Column(
        name = "version"
    )
    @Version
    protected Long version;
    
    @Column(
        name = "satut"
    )
    protected EStatut statut;

    public BaseEntity(){
        this.statut = EStatut.ACTIVE;
        this.version = 1L;
    }

    public boolean isActive(){
        return EStatut.ACTIVE.equals(this.statut);
    }
    public boolean isDeleted(){
        return EStatut.SUPPRIMER.equals(this.statut);
    }

    public String getId(){
        return this.id;
    }

    public Instant getCreatedAt(){
        return this.createdAt;
    }

    public Instant getUpdatedAt(){
        return this.updatedAt;
    }

    public String getCreatedBy(){
        return this.createdBy;
    }

    public String getLastModifiedBy(){
        return this.lastModifiedBy;
    }

    public Long getVersion(){
        return this.version ==null ? Long.valueOf("1") : this.version;
    }

    public EStatut getStatut(){
        return this.statut;
    }

    public void setId(final String id){
        this.id = id;
    }

    public void setCreatedAt(final Instant createdAt){
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(final Instant updatedAt){
        this.updatedAt = updatedAt;
    }

    public void setCreatedBy(final String createdBy){
        this.createdBy = createdBy;
    }

    public void setLastModifiedBy(final String lastModifiedBy){
        this.lastModifiedBy = lastModifiedBy;
    }

    public void setVersion(final Long version){
        this.version = version;
    }
    public void setStatut(final EStatut statut){
        this.statut = statut;
    }

    public boolean equals(final Object o){
        if (this == o) {
            return true;
        }
        else if (!(o instanceof BaseEntity)) {
            return false;
        }
        else{
            BaseEntity that = (BaseEntity) o;
            return this.id != null && that.id.equals(this.id);
        }
    }

    public int hashCode(){
        return Objects.hash(this.id);
    }
}

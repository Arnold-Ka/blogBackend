package com.hackers.blogbackend.utils;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import com.hackers.blogbackend.entity.enom.EStatut;

@NoRepositoryBean
public interface AbstractEntityInterface<T extends BaseEntity, ID> extends JpaRepository<T, ID> {
    List<T> findByStatut(EStatut statut);
    List<T> findByStatutOrderByCreatedAtDesc(EStatut statut);
    default List<T> findAllActive(){return findByStatut(EStatut.ACTIVE);}
    default List<T> finAllActiveDesc(){return findByStatutOrderByCreatedAtDesc(EStatut.ACTIVE);}
    default boolean isActive(ID id){return (boolean) findById(id).map(BaseEntity::isActive).orElse(false);}
    Optional<T> findTop1ByStatutOrderByCreatedAtDesc(EStatut statut);
    Optional<T> findByIdAndStatut(ID id, EStatut statut);
    List<T> findByCreatedAtBetweenAndStatut(Instant start, Instant end, EStatut statut);
    boolean existsByIdAndStatut(ID id, EStatut statut);
    List<T> findByStatutAndLastModifiedBy(EStatut statut, String lastModifiedBy);
    List<T> findByStatutAndCreatedBy(EStatut statut, String createdBy);
    Page<T> findByStatut(EStatut statut, Pageable page);
    long countByStatut(EStatut statut);
    default long countActives(){return this.countByStatut(EStatut.ACTIVE);}

    @Modifying
    @Query(
        "UPDATE #{#entityName} e SET e.statut = ?2 WHERE e.id IN ?1"
    )
    int updateStatutInBulk(List<ID> ids, EStatut newStatut);

}

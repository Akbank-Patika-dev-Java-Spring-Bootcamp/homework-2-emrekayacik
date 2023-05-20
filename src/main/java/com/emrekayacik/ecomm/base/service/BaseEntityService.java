package com.emrekayacik.ecomm.base.service;

import com.emrekayacik.ecomm.base.entity.BaseAuditableEntity;
import com.emrekayacik.ecomm.base.entity.BaseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public abstract class BaseEntityService<E extends BaseEntity, R extends JpaRepository<E, Long>> {

    private final R repository;
    public E save(E entity){

        BaseAuditableEntity baseAuditableEntity = entity.getBaseAuditableEntity();
        if (baseAuditableEntity == null){
            baseAuditableEntity = new BaseAuditableEntity();
        }

        if (entity.getId()  == null){
            baseAuditableEntity.setCreatedDate(LocalDateTime.now());
            //baseAdditionalFields.setCreatedBy(0L); // TODO: JWT
        }

        baseAuditableEntity.setModifiedDate(LocalDateTime.now());
        //baseAdditionalFields.setUpdatedBy(0L);// TODO: JWT

        //baseAuditableEntity.setCreatedUser();

        entity.setBaseAuditableEntity(baseAuditableEntity);
        entity = repository.save(entity);

        return entity;
    }

    public List<E> findAll() {
        return repository.findAll();
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public void delete(E entity){
        repository.delete(entity);
    }

    public Optional<E> findById(Long id){
        return repository.findById(id);
    }

    public E findByIdWithControl(Long id){
        return repository.findById(id).orElseThrow();
    }

    public boolean isExist(Long id){
        return repository.existsById(id);
    }
}

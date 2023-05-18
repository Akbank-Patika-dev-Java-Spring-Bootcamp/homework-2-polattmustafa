package com.polat.ecommerce.service;

import com.polat.ecommerce.model.BaseAdditionalFields;
import com.polat.ecommerce.model.BaseModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Getter
public abstract class BaseEntityService<E extends BaseModel, R extends JpaRepository<E, Long>> {

    private final R anyRepo;

    public E save(E model) {
        BaseAdditionalFields baseAdditionalFields = model.getBaseAdditionalFields();
        if (baseAdditionalFields == null){
            baseAdditionalFields = new BaseAdditionalFields();
        }

        if (model.getId() == null) {
            baseAdditionalFields.setCreateDate(LocalDateTime.now());
            baseAdditionalFields.setCreatedBy("Polat");
        }

        baseAdditionalFields.setUpdateDate(LocalDateTime.now());
        baseAdditionalFields.setUpdatedBy("Polat");

        model.setBaseAdditionalFields(baseAdditionalFields);
        model =anyRepo.save(model);

        return model;
    }

    public List<E> findAll() {
        return anyRepo.findAll();
    }

    public void delete(Long id){
        anyRepo.deleteById(id);
    }

    public void delete(E entity){
        anyRepo.delete(entity);
    }

    public Optional<E> findById(Long id){
        return anyRepo.findById(id);
    }

    public E findByIdWithControl(Long id){
        return anyRepo.findById(id).orElseThrow();
    }

    public boolean isExist(Long id){
        return anyRepo.existsById(id);
    }

}

package com.school_management_system.dto;

import com.school_management_system.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InstructorDetailDTOImpl implements InstructorDetailDTO{
    private final EntityManager entityManager;

    @Autowired
    public InstructorDetailDTOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    public InstructorDetail saveInstructorDetail(InstructorDetail instructorDetail) {
        return entityManager.merge(instructorDetail);

    }
}

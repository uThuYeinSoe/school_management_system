package com.school_management_system.dto;

import com.school_management_system.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InstructorDTOImpl implements InstructorDTO{
    private final EntityManager entityManager;

    @Autowired
    public InstructorDTOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public Instructor saveInstructor(Instructor instructor) {
        return entityManager.merge(instructor);
    }

    public List<Instructor> getInstructorsAll(){
        TypedQuery<Instructor> theQuery = entityManager.createQuery("From Instructor",Instructor.class);
        return theQuery.getResultList();
    }

    public String deleteInstructor(int instructorId){
        String returnString;
        Instructor instructor = entityManager.find(Instructor.class,instructorId);
        if(instructor == null){
            returnString = instructorId + " : id number instructor is not found please try again";
        }else{
            entityManager.remove(instructor);
            returnString = instructorId + " : id number instructor is removed successfully";
        }
        return returnString;
    }
}

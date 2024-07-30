package com.school_management_system.service;

import com.school_management_system.entity.Instructor;
import com.school_management_system.rdo.DefaultResponseData;
import com.school_management_system.rdo.InstructorRequestData;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface InstructorService {
    public DefaultResponseData saveInstructor(InstructorRequestData instructorRequestData);
    public List<Instructor> getInstructorsAll();
    public DefaultResponseData deleteInstructor(int instructorId);
    public DefaultResponseData updateInstructorById(InstructorRequestData instructorRequestData);
}

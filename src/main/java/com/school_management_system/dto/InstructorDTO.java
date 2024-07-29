package com.school_management_system.dto;

import com.school_management_system.entity.Instructor;

import java.util.List;

public interface InstructorDTO {
    public Instructor saveInstructor(Instructor instructor);
    public List<Instructor> getInstructorsAll();
    public String deleteInstructor(int instructorId);
}

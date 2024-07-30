package com.school_management_system.service;

import com.school_management_system.dto.InstructorDTO;
import com.school_management_system.dto.InstructorDTOImpl;
import com.school_management_system.dto.InstructorDetailDTO;
import com.school_management_system.entity.Instructor;
import com.school_management_system.entity.InstructorDetail;
import com.school_management_system.rdo.DefaultResponseData;
import com.school_management_system.rdo.InstructorRequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService{

    private final InstructorDTO instructorDTO;
    private final InstructorDetailDTO instructorDetailDTO;

    @Autowired
    public InstructorServiceImpl(InstructorDTO instructorDTO,InstructorDetailDTO instructorDetailDTO){
        this.instructorDTO = instructorDTO;
        this.instructorDetailDTO = instructorDetailDTO;
    }

    @Transactional(readOnly = true)
    public List<Instructor> getInstructorsAll(){
        return instructorDTO.getInstructorsAll();
    }

    @Override
    @Transactional
    public DefaultResponseData saveInstructor(InstructorRequestData instructorRequestData) {
        Instructor instructor = new Instructor();
        InstructorDetail instructorDetail = new InstructorDetail();

        instructor.setId(0);
        instructor.setFirstName(instructorRequestData.getFirstName());
        instructor.setLastName(instructorRequestData.getLastName());
        instructor.setEmail(instructorRequestData.getEmail());


        instructorDetail.setId(0);
        instructorDetail.setYoutubeChannel(instructorRequestData.getYoutubeChannel());
        instructorDetail.setHobby(instructorRequestData.getHobby());

        instructor.setInstructorDetail(instructorDetail);


        Instructor instructorSaveReturn =instructorDTO.saveInstructor(instructor);
        DefaultResponseData drd = new DefaultResponseData();

        if(instructorSaveReturn != null){
            drd.setMessage("Successfully Instructor Create");
            drd.setStatus(true);
            drd.setStatusCode(200);
        }else{
            drd.setMessage("Failed Create User Please Try Again");
            drd.setStatus(false);
            drd.setStatusCode(400);
        }
        return drd;
    }
    @Transactional
    public DefaultResponseData deleteInstructor(int instructorId){
        String message = instructorDTO.deleteInstructor(instructorId);
        DefaultResponseData drd = new DefaultResponseData();
        drd.setStatusCode(200);
        drd.setStatus(true);
        drd.setMessage(message);

        return drd;
    }

    @Transactional
    public DefaultResponseData updateInstructorById(InstructorRequestData instructorRequestData){
        Instructor instructor = new Instructor();
        InstructorDetail instructorDetail = new InstructorDetail();

        System.out.println("Instructor Id " + instructorRequestData.getInstructorId());
        System.out.println("instructorRequestData " + instructorRequestData);

        instructor.setId(instructorRequestData.getInstructorId());
        instructor.setFirstName(instructorRequestData.getFirstName());
        instructor.setLastName(instructorRequestData.getLastName());
        instructor.setEmail(instructorRequestData.getEmail());

        instructorDetail.setId(instructorRequestData.getInstructorDetailId());
        instructorDetail.setYoutubeChannel(instructorRequestData.getYoutubeChannel());
        instructorDetail.setHobby(instructorRequestData.getHobby());

        instructor.setInstructorDetail(instructorDetail);

        DefaultResponseData drd = new DefaultResponseData();
        Instructor returnInstructor = instructorDTO.saveInstructor(instructor);
        System.out.println("Update Instructor Object :" + instructor);
        if(returnInstructor != null){
            drd.setStatus(true);
            drd.setStatusCode(200);
            drd.setMessage(instructorRequestData.getInstructorId() + " was Update Successfully");
        }else{
            drd.setStatus(false);
            drd.setStatusCode(400);
            drd.setMessage(instructorRequestData.getInstructorId() + " can't Update");
        }

        return drd;

    }
}

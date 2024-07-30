package com.school_management_system.rest;

import com.school_management_system.entity.Instructor;
import com.school_management_system.rdo.DefaultResponseData;
import com.school_management_system.rdo.InstructorRequestData;
import com.school_management_system.service.InstructorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/instructors")
public class InstructorController {

    private InstructorService instructorService;

    public InstructorController(InstructorService instructorService){
        this.instructorService = instructorService;
    }

    @GetMapping("/test")
    public String testInstructor(){
        return "Hello World";
    }

    @GetMapping("/instructors")
    public List<Instructor> getInstructorAll(){
        return instructorService.getInstructorsAll();
    }

    @PostMapping("/instructors")
    public DefaultResponseData saveInstructor(@RequestBody InstructorRequestData instructorRequestData){
        System.out.println(instructorRequestData);
        return instructorService.saveInstructor(instructorRequestData);
    }

    @DeleteMapping("/instructors/{instructorId}")
    public DefaultResponseData deleteInstructorById(@PathVariable int instructorId){
        return instructorService.deleteInstructor(instructorId);
    }

    @PutMapping("/instructors")
    public DefaultResponseData updateInstructorById(@RequestBody InstructorRequestData instructorRequestData){
        return instructorService.updateInstructorById(instructorRequestData);
    }

}

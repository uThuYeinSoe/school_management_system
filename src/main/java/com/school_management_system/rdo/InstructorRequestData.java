package com.school_management_system.rdo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InstructorRequestData {
    @JsonProperty("instructor_id")
    private int instructorId;
    private String firstName;
    private String lastName;
    private String email;
    private String youtubeChannel;
    private String hobby;
    @JsonProperty("instructor_detail_id")
    private int instructorDetailId;

    public InstructorRequestData(){}

    public InstructorRequestData(String firstName, String lastName, String email, String youtubeChannel, String hobby) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public int getInstructorDetailId() {
        return instructorDetailId;
    }

    public void setInstructorDetailId(int instructorDetailId) {
        this.instructorDetailId = instructorDetailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "InstructorRequestObject{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}

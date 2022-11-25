package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Endpoint(id="studentActuator")
public class StudentActuator {
    private final StudentService studentService;

    @Autowired
    public StudentActuator(StudentService studentService) {
        this.studentService = studentService;
    }

    @ReadOperation
    public List<Student> studentDbDetails() {
        return studentService.getStudents();
    }
}

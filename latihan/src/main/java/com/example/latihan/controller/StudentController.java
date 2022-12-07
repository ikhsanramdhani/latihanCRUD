package com.example.latihan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.latihan.model.Student;
import com.example.latihan.service.IStudentService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/student")
public class StudentController {
    
    @Autowired
    IStudentService studentService;

    @PostMapping("/add")
    public Student addData(@RequestBody Student student) {
        return studentService.addData(student);
    }

    @GetMapping("/getData")
    public List<Student> getData() {
        return studentService.getData();
    }

    @PutMapping("/edit/{id}")
    public Student updateData(@PathVariable int id, @RequestBody Student student) {
        return studentService.updateData(id, student);
    }

    @DeleteMapping("/delete/{id}")
    public Student deleteData(@PathVariable int id) {
        return studentService.deleteData(id);
    }

}

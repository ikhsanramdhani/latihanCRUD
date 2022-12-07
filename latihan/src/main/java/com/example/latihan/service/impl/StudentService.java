package com.example.latihan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.latihan.model.Student;
import com.example.latihan.repository.IStudentRepository;
import com.example.latihan.service.IStudentService;

@Service
public class StudentService implements IStudentService {

    @Autowired
    IStudentRepository studentRepository;

    @Override
    public Student addData(Student student) {
        // TODO Auto-generated method stub
        return studentRepository.addData(student);
    }

    @Override
    public List<Student> getData() {
        // TODO Auto-generated method stub
        return studentRepository.getData();
    }

    @Override
    public Student updateData(int id, Student student) {
        // TODO Auto-generated method stub
        return studentRepository.updateData(id, student);
    }

    @Override
    public Student deleteData(int id) {
        // TODO Auto-generated method stub
        return studentRepository.deleteData(id);
    }
    
}

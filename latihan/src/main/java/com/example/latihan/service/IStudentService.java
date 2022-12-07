package com.example.latihan.service;

import java.util.List;

import com.example.latihan.model.Student;

public interface IStudentService {
    public Student addData(Student student);
    public List<Student> getData();
    public Student updateData(int id, Student student);
    public Student deleteData(int id);
}

package com.example.latihan.repository;

import java.util.List;

import com.example.latihan.model.Student;

public interface IStudentRepository {
    public Student addData(Student student);
    public List<Student> getData();
    public Student updateData(int id, Student student);
    public Student deleteData(int id);
}

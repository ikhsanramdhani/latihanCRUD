package com.example.latihan.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.latihan.model.Student;
import com.example.latihan.repository.IStudentRepository;

@Repository
public class StudentRepository implements IStudentRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Student addData(Student student) {
        // TODO Auto-generated method stub
        String query = "INSERT INTO tb_student (deskripsi_diri, email, hard_skill, interest, jenis_kelamin, nama, soft_skill, umur) VALUES (?,?,?,?,?,?,?,?)";

        try {
            jdbcTemplate.update(query, new Object[] {
                student.getDeskripsi_diri(), student.getEmail(), student.getHard_skill(), student.getInterest(),
                student.getJenis_kelamin(), student.getNama(), student.getSoft_skill(), student.getUmur()
            });
            return student;
        } catch (Exception e) {
            // TODO: handle exception
            Student obj = new Student();
            return obj;
        }
        
    }

    @Override
    public List<Student> getData() {
        // TODO Auto-generated method stub

        String query = "SELECT * FROM tb_student";

        try {
            var result = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Student.class));
            return result;
        } catch (Exception e) {
            // TODO: handle exception
            List<Student> obj = new ArrayList<>();
            return obj;
        }

    }

    @Override
    public Student updateData(int id, Student student) {
        // TODO Auto-generated method stub
        
        String query = "UPDATE tb_student SET deskripsi_diri = ?, email = ?, hard_skill = ?, interest = ?, jenis_kelamin = ?, nama = ?, soft_skill = ?, umur = ? WHERE id = ?";

        try {
            jdbcTemplate.update(query, new Object[] {
                student.getDeskripsi_diri(), student.getEmail(), student.getHard_skill(), student.getInterest(),
                student.getJenis_kelamin(), student.getNama(), student.getSoft_skill(), student.getUmur(), id
            });
            return student;
        } catch (Exception e) {
            // TODO: handle exception
            Student obj = new Student();
            return obj;
        }
    }

    @Override
    public Student deleteData(int id) {
        // TODO Auto-generated method stub

        String query = "SELECT * FROM tb_student WHERE id = ?";

        try {
            var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Student.class),id);

            query = "DELETE FROM tb_student WHERE id = ?"; 
            jdbcTemplate.update(query, id);

            return result;

        } catch (Exception e) {
            // TODO: handle exception
            Student obj = new Student();
            return obj;
        }

    } 

}
    

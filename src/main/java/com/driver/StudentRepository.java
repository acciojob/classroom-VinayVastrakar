package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    private HashMap<String ,Student> studentDB = new HashMap<>();
    private HashMap<String ,Teacher> teacherDB = new HashMap<>();
    private HashMap<String  ,List<String>> studentTeacherDB = new HashMap<>();


    public void addStudent(Student student) {
        studentDB.put(student.getName(),student);
    }

    public void addTeacher(Teacher addTeacher) {
        teacherDB.put(addTeacher.getName(),addTeacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        List<String> students = studentTeacherDB.getOrDefault(teacher, new ArrayList<String>());
        students.add(student);
        Teacher teacher1= teacherDB.get(teacher);
        teacher1.setNumberOfStudents(students.size());
        studentTeacherDB.put(teacher, students);


    }

    public Student getStudentByName(String name) {
        for (String std : studentDB.keySet() ) {
            if(name.equals(std)){
                return  studentDB.get(std);
            }
        }
        return null;
    }

    public Teacher getTeacherByName(String name) {
        for (String std : teacherDB.keySet() ) {
            if(name.equals(std)){
                return  teacherDB.get(std);
            }
        }
        return null;
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        for (String teach: studentTeacherDB.keySet() ) {
            if(teacher.equals(teach)){
                return studentTeacherDB.get(teach);
            }
        }
        return null;
    }

    public List<String> getAllStudents() {
        List<String> list = new ArrayList<>();
        for ( String student : studentDB.keySet()) {
            list.add(student);
        }
        return list;
    }

    public void deleteTeacherByName(String teacher) {
        teacherDB.remove(teacher);
    }

    public void deleteAllTeachers() {

        teacherDB.clear();
    }
}

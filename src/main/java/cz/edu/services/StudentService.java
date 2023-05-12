package cz.edu.services;

import cz.edu.entites.Student;
import cz.edu.repository.StudentRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
@ApplicationScoped
public class StudentService {

    @Inject
    private StudentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }
    public List<Student> getStudents() {
        return studentRepository.getStudent();
    }
    public void delete(int id){
        studentRepository.delete(id);
    }
    public double avgGrade(){
        return studentRepository.avgGrade();
    }


}

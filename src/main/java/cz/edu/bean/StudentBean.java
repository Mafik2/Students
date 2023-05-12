package cz.edu.bean;

import cz.edu.entites.Student;
import cz.edu.services.StudentService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.IOException;

@Named
@RequestScoped
public class StudentBean {

    @Inject
    private StudentService studentService;
    private Student newStudent = new Student();

    public void add() throws IOException {
        studentService.addStudent(newStudent);
        newStudent = new Student();
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
    }
    public Student getNewStudent() {
        return newStudent;
    }
}

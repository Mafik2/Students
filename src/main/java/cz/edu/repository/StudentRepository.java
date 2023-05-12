package cz.edu.repository;

import cz.edu.entites.Student;
import cz.edu.services.EntityManagerFactoryProvider;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

@ApplicationScoped
public class StudentRepository {
    @Inject
    private EntityManagerFactoryProvider emf;

    public void addStudent(Student student) {
        EntityManager em = emf.getEmf().createEntityManager();

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(student);
        et.commit();
        em.close();
    }

    public List<Student> getStudent(){
        EntityManager em = emf.getEmf().createEntityManager();
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student AS s", Student.class);
        List<Student> studentList = query.getResultList();

        em.close();
        return studentList;
    }

    public void delete(int id){
        EntityManager em = emf.getEmf().createEntityManager();
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Student AS s WHERE s.studentId = :id", Student.class);
        query.setParameter("id", id);
        Student student = query.getSingleResult();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.remove(student);
        et.commit();
        em.close();
    }
    public double avgGrade(){
        EntityManager em = emf.getEmf().createEntityManager();
        TypedQuery<Double> query = em.createQuery("select AVG(s.grade) from Student AS s", Double.class);
        double avg = 0;
        try {
            avg = query.getSingleResult();
        } catch (Exception e) {}
        em.close();
        return avg;
    }
}

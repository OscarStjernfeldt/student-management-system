package se.iths.service;

import se.iths.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    public void createStudent(Student student) {
        entityManager.persist(student);
    }

    public void updateStudent(Student student, Long id) {
        if (!Objects.equals(student.getId(), id))
            throw new IllegalStateException("Provided student ids do not match");
        entityManager.merge(student);
    }

    public List<Student> getAllStudentsByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s WHERE s.lastName LIKE :lastName", Student.class);
        query.setParameter("lastName", "%" + lastName + "%");
        return query.getResultList();
//        return entityManager.createQuery("SELECT s FROM Student s WHERE s.lastName LIKE :lastName", Student.class)
//                .setParameter("lastName", "%" + lastName + "%")
//                .getResultList();
    }

    //MediaType.APPLICATION_JSON_TYPE

    public void deleteStudent(Long id) {
        Student foundStudent = entityManager.find(Student.class, id);
        entityManager.remove(foundStudent);
    }

    public List<Student> getAllStudents() {
        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }
}

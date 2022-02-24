package se.iths.service;

import se.iths.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    public Student create(Student student) {
        entityManager.persist(student);
        return student;
    }

    public void updateStudent(Student student, Long id) {
        if (!Objects.equals(student.getId(), id))
            throw new IllegalStateException("Provided student ids do not match");
        entityManager.merge(student);
    }

    public List<Student> getByLastName(String lastName) {
        return entityManager.createQuery("SELECT s FROM Student s WHERE s.lastName LIKE :lastName",
                        Student.class)
                .setParameter("lastName", "%" + lastName + "%")
                .getResultList();
    }

    public void delete(Long id) {
        Student foundStudent = entityManager.find(Student.class, id);
        entityManager.remove(foundStudent);
    }

    public List<Student> getAllStudents() {
        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }
}

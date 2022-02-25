package se.iths.service;

import se.iths.entity.Student;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Validator;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    @Inject
    Validator validator;

    public Student create(Student student) {
        validateStudent(student);

        entityManager.persist(student);
        return student;
    }

    public Student update(Student student, Long id) {
        validateStudent(student);

        if (!Objects.equals(student.getId(), id)) {
            throw new IllegalStateException("Provided student ids do not match");
        }
        return entityManager.merge(student);
    }

    private void validateStudent(Student student) {
        var validations = validator.validate(student);

        if (validations.size() > 0)
            throw new BadRequestException("Invalid student");
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

    public List<Student> getAll() {
        return entityManager.createQuery("SELECT s FROM Student s", Student.class)
                .getResultList();
    }

    public Student getById(Long id) {
        return Optional.ofNullable(entityManager.find(Student.class, id))
                .orElseThrow(() -> new NotFoundException("Could not find entity with id: " + id));
    }

    public Student patch(Student student, Long id) {
        Student oldStudent = getById(id);

        if (student.getFirstName() != null)
            oldStudent.setFirstName(student.getFirstName());
        if (student.getLastName() != null)
            oldStudent.setLastName(student.getLastName());
        if (student.getEmail() != null)
            oldStudent.setEmail(student.getEmail());
        if (student.getPhoneNumber() != null)
            oldStudent.setPhoneNumber(student.getPhoneNumber());

        return oldStudent;
    }
}

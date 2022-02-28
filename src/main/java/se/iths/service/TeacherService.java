package se.iths.service;

import se.iths.entity.Teacher;

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
public class TeacherService {

    @PersistenceContext
    EntityManager entityManager;

    @Inject
    Validator validator;

    public Teacher create(Teacher teacher) {
        validateTeacher(teacher);

        entityManager.persist(teacher);
        return teacher;
    }

    public Teacher update(Teacher teacher, Long id) {
        validateTeacher(teacher);

        if (!Objects.equals(teacher.getId(), id)) {
            throw new BadRequestException("Entity id did not match given id");
        }

        return entityManager.merge(teacher);
    }

    private void validateTeacher(Teacher teacher) {
        var validations = validator.validate(teacher);

        if (validations.size() > 0)
            throw new BadRequestException("Invalid teacher");
    }

    public List<Teacher> getByLastName(String lastName) {
        return entityManager.createQuery("SELECT s FROM Teacher s WHERE s.lastName LIKE :lastName",
                        Teacher.class)
                .setParameter("lastName", "%" + lastName + "%")
                .getResultList();
    }

    public void delete(Long id) {
        getById(id);
        Teacher foundTeacher = entityManager.find(Teacher.class, id);
        entityManager.remove(foundTeacher);
    }

    public List<Teacher> getAll() {
        return entityManager.createQuery("SELECT s FROM Teacher s", Teacher.class)
                .getResultList();
    }

    public Teacher getById(Long id) {
        return Optional.ofNullable(entityManager.find(Teacher.class, id))
                .orElseThrow(() -> new NotFoundException("Could not find entity with id: " + id));
    }

    public Teacher patch(Teacher teacher, Long id) {
        Teacher oldTeacher = getById(id);

        if (teacher.getFirstName() != null)
            oldTeacher.setFirstName(teacher.getFirstName());
        if (teacher.getLastName() != null)
            oldTeacher.setLastName(teacher.getLastName());

        return oldTeacher;
    }
}

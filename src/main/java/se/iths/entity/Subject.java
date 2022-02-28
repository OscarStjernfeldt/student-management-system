package se.iths.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Subject {

    @Id
    private Long id;

    @NotBlank
    @Size(min = 2)
    private String name;

    @ManyToMany(targetEntity = Student.class)
    Set<Student> student;

    @ManyToOne(targetEntity = Teacher.class)
    Teacher teacher;

    public Subject() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package hiber.HW_38;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    protected Long id;
    @Column
    protected String title;
    @Column
    protected String description;
    @Column
    protected double salary;
    @Column
    protected int hours;
    @Column
    @Type(type = "timestamp")
    protected Date date_create;

    protected  Set<Employee> employees;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "employees&courses")
    public Set<Employee> getEmployees() {
        return this.employees;
    }
}

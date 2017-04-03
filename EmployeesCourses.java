package hiber.HW_38;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Table(name = "employees_courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeesCourses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    protected Long id;
    @Column(name = "day_start")
    @Type(type = "timestamp")
    protected Date dayStart;
    @Column(name = "day_finish")
    @Type(type = "timestamp")
    protected Date dayFinish;
    @Column(name = "date_create")
    @Type(type = "timestamp")
    protected Date dateCreate;
    @Column(name = "is_organization_paid")
    protected boolean isPaid;

    protected Set<Course> courses;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "employees&courses", catalog = "factory", joinColumns = {
            @JoinColumn(name = "employee_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "course_id",
                    nullable = false, updatable = false) })
    public Set<Course> getCourses() {
        return this.courses;
    }

}

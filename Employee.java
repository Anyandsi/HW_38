package hiber.HW_38;

import hiber.Department;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.zip.CheckedOutputStream;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "employees")
public class Employee {

    protected SalariesPaid salariesPaid;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    protected Long id;
    @Column
    protected String name_first;
    @Column
    protected String name_last;
    @Column
    protected String second_name;



    @Column
    @Type(type = "timestamp")
    protected Date date_create = new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "salary", nullable = false)
    private SalariesPaid salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private  Post post;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "post")
    private List<SalariesPaid> salaries;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "workingDay")
    private List<WorkingDays> days;



}



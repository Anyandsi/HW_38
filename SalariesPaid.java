package hiber.HW_38;

import hiber.*;
import hiber.Employee;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "salaries_paid")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SalariesPaid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    protected Long id;

    @Column
    protected double salary;
    @Column
    @Type(type = "timestamp")
    protected Date date_pay = new Date();
    @Column
    @Type(type = "timestamp")
    protected Date date_create = new Date();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employee_id")
    private List<Employee> employees;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
}

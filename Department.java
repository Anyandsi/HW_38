package hiber.HW_38;

import hiber.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@ToString

public class Department {
    @Id
    @Column(name = "department_id")
    private long id;
    @Column
    private String title;
    @Column(name = "date_create")
    private Date creationDate = new Date();
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "department")
    private List<Employee> employees;

    public Department(long id, String title, Date creationDate) {
        this.id = id;
        this.title = title;
        this.creationDate = creationDate;
    }
}

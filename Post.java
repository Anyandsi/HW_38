package hiber.HW_38;

import hiber.*;
import hiber.Employee;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    protected Long id;
    @Column
    protected String title;
    @Column(name = "date_create")
    @Type(type = "timestamp")
    protected Date dateCreate = new Date();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "post")
    private List<Employee> employees;

}

package hiber.HW_38;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Table(name = "employees_tangibles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeesTangibles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    protected Long id;
    @Column(name = "date_create")
    @Type(type = "timestamp")
    protected Date dateCreate;
    @Column(name = "uniq_number")
    protected int uniqNumber;

    protected Set<Tangible> tangibles;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "employees&tangibles", catalog = "factory", joinColumns = {
            @JoinColumn(name = "employee_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "tangible_id",
                    nullable = false, updatable = false) })
    public Set<Tangible> getTangibles() {
        return this.tangibles;
    }
}

package hiber.HW_38;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "working_days")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WorkingDays {
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

}

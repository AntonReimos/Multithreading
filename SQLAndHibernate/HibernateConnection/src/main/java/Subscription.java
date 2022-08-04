import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "subscriptions")
public class Subscription {
    @EmbeddedId
    private SubscriptionKey id;

    @Column(name = "student_id",
    insertable = false, updatable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;

    @Column(name = "course_id",
    insertable = false, updatable = false)
    private Course course;

    @Column(name = "subscription_date")
    private Date subsctriptionDate;

    public SubscriptionKey getId() {
        return id;
    }

    public void setId(SubscriptionKey id) {
        this.id = id;
    }

    public Student getStudentId() {
        return student;
    }

    public void setStudentId(Student student) {
        this.student = student;
    }

    public Course getCourseId() {
        return course;
    }

    public void setCourseId(Course course) {
        this.course = course;
    }

    public Date getSubsctriptionDate() {
        return subsctriptionDate;
    }

    public void setSubsctriptionDate(Date subsctriptionDate) {
        this.subsctriptionDate = subsctriptionDate;
    }
}

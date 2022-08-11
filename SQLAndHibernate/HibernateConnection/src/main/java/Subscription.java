import javax.persistence.*;
import java.util.Date;
import java.util.List;


//TODO:Изучите каждую таблицу и найдите связи между ними.
//  Например, в таблице Subscriptions есть поле с идентификатором студента (student_id).
//  В классе, связанном с Subscriptions, можно сделать связь @ManyToOne со студентом,
//  а у студента будет @OneToMany. То есть у одного студента может быть много подписок,
//  а у каждой подписки может быть только один студент. Аналогично посмотрите,
//  где и какие связи можно прописать между классами.

@Entity
@Table(name = "subscriptions")
public class Subscription {
    @EmbeddedId
    private SubscriptionKey id;

    @Column(name = "student_id",
            insertable = false, updatable = false)
    private int studentId;

    @Column(name = "course_id",
            insertable = false, updatable = false)
    private int courseId;

    @Column(name = "subscription_date")
    private Date subsctriptionDate;

    @ManyToOne()
    @JoinColumn(name = "student_id",
            insertable = false, updatable = false)
    private Student student;


    // что-то не так тут
    @OneToMany(mappedBy = "subscription")
//    @JoinColumn(name = "id",
//            insertable = false, updatable = false)
    private List<Course> courses;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    public SubscriptionKey getId() {
        return id;
    }


    public void setId(SubscriptionKey id) {
        this.id = id;
    }


    public Date getSubsctriptionDate() {
        return subsctriptionDate;
    }

    public void setSubsctriptionDate(Date subsctriptionDate) {
        this.subsctriptionDate = subsctriptionDate;
    }


    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}

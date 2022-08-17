import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "linkedpurchaselist")
public class LinkedPurchaseList {


    @EmbeddedId
    private LinkedPurchaseListKey id;

    @Column(name = "student_id", nullable = false,
            insertable = false, updatable = false)
    private int studentId;

    @Column(name = "course_id", nullable = false,
            insertable = false, updatable = false)
    private int courseId;

    public LinkedPurchaseList(){}
    public LinkedPurchaseList(int studentId, int courseId){
        this.id = new LinkedPurchaseListKey(studentId, courseId);
        this.studentId = studentId;
        this.courseId = courseId;
    }


    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public LinkedPurchaseListKey getId() {
        return id;
    }

    public void setId(LinkedPurchaseListKey id) {
        this.id = id;
    }
}

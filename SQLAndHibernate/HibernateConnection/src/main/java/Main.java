import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("16.5 hibernate.cfg").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        // получаем подписки
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PurchaseList> query = builder.createQuery(PurchaseList.class);
        Root<PurchaseList> root = query.from(PurchaseList.class);
        query.select(root);
        List<PurchaseList> purchaseLists = session.createQuery(query).getResultList();

        List<LinkedPurchaseList> linkedPurchaseLists = new ArrayList<>();
        for (PurchaseList p : purchaseLists) {
            String studentQuery = "SELECT s.id FROM Student s "
                    + "WHERE s.name='" + p.getStudentName() + "'";

            String courseQuery = "SELECT c.id FROM Course c "
                    + "WHERE c.name='" + p.getCourseName() + "'";

            int studentId = (Integer) session.createQuery(studentQuery).getSingleResult();
            int courseId = (Integer) session.createQuery(courseQuery).getSingleResult();
            linkedPurchaseLists.add(new LinkedPurchaseList(studentId, courseId));
        }

        for (LinkedPurchaseList l : linkedPurchaseLists) {
            session.save(l);
        }

        //Course course = session.get(Course.class, 1);
        //Student student = session.get(Student.class, 5);
//        PurchaseList purchaseList = session.get(PurchaseList.class,
//                new PurchaseListKey("Лилов Тимофей", "Java-разработчик"));

        //PurchaseList purchaseList = session.get(PurchaseList.class, PurchaseListKey);

//        String out = student.getId() + " - " +
//                student.getName() + " - " +
//                student.getAge() + " - " +
//                student.getRegistrationDate();

        //System.out.println(purchaseList.getId());
        //System.out.println("purchaseList: " + purchaseList.getStudentName() + " - " +purchaseList.getCourseName() + " - " + purchaseList.getSubscriptionsDate());
//        System.out.println(course.getName());
//        List<Student> studentList = course.getStudents();
//        System.out.println("Студенты курса " + course.getName());
//        studentList.stream().map(student1 -> student1.getName()).forEach(System.out::println);
//        System.out.println(course.getTeacher().getName());
        //student.getSubscription().stream().map(subscription -> subscription.getCourseId()).forEach(System.out::println);
        //System.out.println(out);
        transaction.commit();
        sessionFactory.close();

    }
}

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("16.5 hibernate.cfg").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Subscription subscription = session.get(Subscription.class, new SubscriptionKey(1, 2));
        Course course = session.get(Course.class, 1);
        Student student = session.get(Student.class, 5);
        PurchaseList purchaseList = session.get(PurchaseList.class, new PurchaseListKey("Лилов Тимофей", "Java-разработчик"));
        String out = student.getId() + " - " +
                student.getName() + " - " +
                student.getAge() + " - " +
                student.getRegistrationDate();

        System.out.println("purchaseList: " + purchaseList.getStudentName() + " - " +purchaseList.getCourseName() + " - " + purchaseList.getSubscriptionsDate());
        System.out.println("SubscriptionDate: " + subscription.getSubsctriptionDate().toString());
        System.out.println(course.getName());
        List<Student> studentList = course.getStudents();
        System.out.println("Студенты курса " + course.getName());
        studentList.stream().map(student1 -> student1.getName()).forEach(System.out::println);
        System.out.println(course.getTeacher().getName());
        System.out.println(out);

        sessionFactory.close();

    }
}

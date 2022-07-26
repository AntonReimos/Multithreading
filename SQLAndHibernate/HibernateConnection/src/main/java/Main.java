import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.TypedQuery;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("16.5 hibernate.cfg").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Course course = session.get(Course.class, 1);
        Students students = session.get(Students.class, 1);
        String student = students.getId() + " - " +
                students.getName() + " - " +
                students.getAge() + " - " +
                students.getRegistrationDate();

        System.out.println(course.getName());
        System.out.println(student);

        sessionFactory.close();

    }
}

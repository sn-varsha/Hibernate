package pro;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Fetch {
    public static void main(String[] args) {
        Student s2 = null;

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(pro.Student.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();
        s2=session.get(Student.class,179);
        session.close();
        sf.close();
        System.out.println(s2);
    }
}

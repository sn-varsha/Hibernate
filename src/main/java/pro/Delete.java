package pro;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Delete {
    public static void main(String[] args) {
        Student s1 = new Student();

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(pro.Student.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        s1=session.get(Student.class,105);
        Transaction transaction = session.beginTransaction();
        session.remove(s1);
        transaction.commit();
        session.close();
        sf.close();

        System.out.println(s1);
    }
}

package pro;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Update {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setsName("manu");
        s1.setRollno(104);
        s1.setsAge(22);

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(pro.Student.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();
        session.merge(s1);
        transaction.commit();
        session.close();
        sf.close();

        System.out.println(s1);
    }
}

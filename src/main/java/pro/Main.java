package pro;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

            Student s1 = new Student();
            s1.setsName("pammi");
            s1.setRollno(106);
            s1.setsAge(12);

//        Configuration cfg = new Configuration();
//        cfg.addAnnotatedClass(pro.Student.class);
//        cfg.configure();

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(pro.Student.class)
                .configure()
                .buildSessionFactory();
        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();

        session.persist(s1);
        transaction.commit();
        session.close();
        sf.close();
        System.out.println(s1);

    }
}
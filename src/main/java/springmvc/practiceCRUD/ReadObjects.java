package springmvc.practiceCRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadObjects
{
    public static void main(String[] args)
    {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(StudentEntity.class)
                .buildSessionFactory();
        Session session=factory.getCurrentSession();
        try
        {
            StudentEntity tempStudent=new StudentEntity("lav", "kola","lavanya@gail.com");
            session.beginTransaction();
            session.save(tempStudent);
            session.getTransaction().commit();


//create new session for reading the data
            session=factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("\nGetting Student with id:"+tempStudent.getId());

            StudentEntity t1=session.get(StudentEntity.class,tempStudent.getId());
            System.out.println(t1);
            session.getTransaction().commit();
            System.out.println("done dana done");
        }
        finally {
            factory.close();
        }
    }
}

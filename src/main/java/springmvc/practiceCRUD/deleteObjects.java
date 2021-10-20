package springmvc.practiceCRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class deleteObjects
{
    public static void main(String[] args)
    {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(StudentEntity.class)
                .buildSessionFactory();

        try
        {
            Session session=factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("deleting the id");
            session.createQuery("delete from StudentEntity  where id=4").executeUpdate();
            session.getTransaction().commit();

            System.out.println("done dana done");
        }
        finally {
            factory.close();
        }
    }
}

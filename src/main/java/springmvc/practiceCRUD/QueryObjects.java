package springmvc.practiceCRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryObjects
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
            session.beginTransaction();

            //query students
            List<StudentEntity> theStudents=session
                    .createQuery("from StudentEntity s where s.lastName='kola'")
                            .getResultList();

            //display the students
            //displayStudents(theStudents);
            for(StudentEntity tempStudents:theStudents)
            {
                System.out.println(tempStudents);
            }

            session.getTransaction().commit();


            System.out.println("done dana done");
        }
        finally {
            factory.close();
        }
    }

    private static void displayStudents(List<StudentEntity> theStudents) {
        for(StudentEntity tempStudents: theStudents)
        {
            System.out.println(tempStudents);
        }
    }
}


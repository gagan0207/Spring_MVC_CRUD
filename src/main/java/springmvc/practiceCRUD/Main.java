package springmvc.practiceCRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main
{
    public static void main(String[] args) {
        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(StudentEntity.class)
                .buildSessionFactory();

        Session session=factory.getCurrentSession();

        try
        {
            //use session object to save java object

            //create studententity object
            System.out.println("creating a studententity object");
            StudentEntity tempStudentEntity2=new StudentEntity("harshi","sai","harshitha59@gmail.com");
            StudentEntity tempStudentEntity3=new StudentEntity("hari","haran","hariharan@gmail.com");
            StudentEntity tempStudentEntity4=new StudentEntity("raghav","royal","raghavendran@gmail.com");


            //start transaction
            session.beginTransaction();

            //save studententity object
            System.out.println("saving the student object");
            session.save(tempStudentEntity2);
            session.save(tempStudentEntity3);
            session.save(tempStudentEntity4);


            //commit transaction
            session.getTransaction().commit();

            System.out.println("done");


        }
        finally
        {
            factory.close();
        }

    }

}
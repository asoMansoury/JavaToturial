import Dao.DepartmentDao;
import Dao.MemberDao;
import Entities.Department;
import Entities.Employee;
import Entities.MemberJpa;
import Hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        insertData();
    }

    public  static void insertData(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        MemberDao memberDao = (MemberDao) context.getBean("MemberDaoID");
        MemberJpa memberJpa = new MemberJpa();
        memberJpa.setName("Mohsen");
        memberJpa.setFamily("Mansouri");
        memberDao.Persist(memberJpa);

//        ApplicationContext context =new ClassPathXmlApplicationContext("beans.xml");
//        DepartmentDao dpDao = context.getBean("DepartmentID",DepartmentDao.class);
//        dpDao.Save(null);
//        Session session = null;
//        Transaction transaction =null;
//        try{
//
//
//            Department department1 = new Department();
//            department1.setName("IT Department");
//            Department department2 = new Department();
//            department2.setName("HR Department");
//
//            Employee employee1 = new Employee();
//            employee1.setName("Robin Edward");
//            employee1.setDesignation("Manager");
//            employee1.setDepartment(department1);
//
//            Employee employee2 = new Employee();
//            employee2.setName("Vivian Jackman");
//            employee2.setDesignation("Senior HR Manager");
//            employee2.setDepartment(department1);
//
//            Employee employee3 = new Employee();
//            employee3.setName("Eliza Edward");
//            employee3.setDesignation("Software Engineer");
//            employee3.setDepartment(department2);
//
//            Employee employee4 = new Employee();
//            employee4.setName("Nancy Newman");
//            employee4.setDesignation("Senior Software Engineer");
//            employee4.setDepartment(department2);
//
//            department1.getEmployees().add(employee1);
//            department1.getEmployees().add(employee2);
//
//            department2.getEmployees().add(employee3);
//            department2.getEmployees().add(employee4);
//
//            session.persist(department1);
//            session.persist(department2);
//
//            transaction.commit();
//        }
//        catch (Exception e){
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }finally {
//            if (session != null) {
//                session.close();
//            }
        //}
    }
}

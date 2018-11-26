package Dao;

import Entities.Department;
import Hibernate.HibernateUtils;
import net.bytebuddy.dynamic.DynamicType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DepartmentDao implements Dao<Department> {

    @Autowired
    private Session _sessionFactory;
    private Transaction transaction = null;

    public DepartmentDao(){
    }

    private void beginTransaction(){
        try{
            transaction =_sessionFactory.getTransaction();
            transaction.begin();
        }catch (Exception ex){
            transaction.rollback();
        }
    }

    private void CommitTransaction(){
        try{
            transaction.commit();
        }catch (Exception ex){
            transaction.rollback();
        }
    }

    private void init(){
        System.out.println("init method");
    }

    private void destroy(){
        try{
            System.out.println("destroy method");
            _sessionFactory.close();
        }catch (Exception ex){

        }
    }

    public DynamicType.Builder.FieldDefinition.Optional<Department> get(long id) {
        return null;
    }

    public List<Department> getAll() {
        return null;
    }

    public void Save(Department department) {
        try {
            beginTransaction();
            _sessionFactory.persist(department);
            CommitTransaction();
        }catch (Exception ex){

        }
    }

    public void update(Department department, String[] params) {

    }

    public void delete(Department department) {

    }
}

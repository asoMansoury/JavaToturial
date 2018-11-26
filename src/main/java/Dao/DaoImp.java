package Dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class DaoImp  {
    @Autowired
    protected EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;
    protected void init(){
        if(entityManager==null)
            entityManager = entityManagerFactory.createEntityManager();
    }

    protected void Destroy(){

    }

    private void getEntityManager(){
        if(entityManager==null)
             entityManager = entityManagerFactory.createEntityManager();
    }

    protected void getBeginTransaction(){
        try{
            getEntityManager();
            entityManager.getTransaction().begin();
        }catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    protected void CommitTransaction(){
        try{
            entityManager.getTransaction().commit();
        }catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}

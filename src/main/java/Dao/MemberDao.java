package Dao;

import Entities.MemberJpa;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class MemberDao extends DaoImp implements IMemberDao  {




    public MemberDao(){
        super();
    }

    public MemberJpa getById(final int id){
        return entityManager.find(MemberJpa.class,id);
    }

    public void Persist(MemberJpa memberJpa){
        try{
            getBeginTransaction();
            entityManager.persist(memberJpa);
            CommitTransaction();
        }catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(MemberJpa memberJpa){
        try{
            getBeginTransaction();
            entityManager.merge(memberJpa);
            CommitTransaction();
        }catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(MemberJpa memberJpa){
        try{
            getBeginTransaction();
            MemberJpa memberJpa1 =getById(memberJpa.getId());
            if(memberJpa1!=null)
                entityManager.remove(memberJpa1);
            CommitTransaction();
        }catch (Exception ex){
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }



    public List<MemberJpa> getAll(){
        return entityManager.createQuery("from "+MemberJpa.class).getResultList();
    }


}

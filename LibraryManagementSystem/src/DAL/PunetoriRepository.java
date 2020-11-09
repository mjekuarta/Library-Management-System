/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Punetori;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Arta
 */
public class PunetoriRepository extends EntMngClass implements PunetoriInterface{

    @Override
    public void create(Punetori p1) throws CrudFormException {
        try{
           em.getTransaction().begin();
           em.persist(p1);
           em.getTransaction().commit();
       }catch(Exception e){
           throw new CrudFormException("Msg \n" + e.getMessage());
       }  

    }

    @Override
    public void edit(Punetori p1) throws CrudFormException {
        try{
            em.getTransaction().begin();
            em.merge(p1);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }    
    }

    @Override
    public void delete(Punetori p1) throws CrudFormException {
         try{
            em.getTransaction().begin();
            em.remove(p1);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }

    }

    @Override
    public List<Punetori> findAll() throws CrudFormException {
        try{
            return em.createNamedQuery("Punetori.findAll").getResultList();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }

    }

    @Override
    public Punetori findByID(Integer ID) throws CrudFormException {
         try {
            Query query = em.createQuery("SELECT p FROM Punetori p WHERE p.punetoriID = :abc");
            query.setParameter("abc", ID);
            return (Punetori) query.getSingleResult();
        } catch (Exception e) {
            throw new CrudFormException("Msg! \n" + e.getMessage());
        }
    }


     public Punetori loginByUsernameAndPassword(String u, String p) throws CrudFormException {
        try {
            Query query = em.createQuery("SELECT p FROM Punetori p WHERE p.emriPunetorit = :us AND p.passwordi=:psw");
            query.setParameter("us", u);
            query.setParameter("psw", p);
            return (Punetori) query.getSingleResult();
        } catch (Exception e) {
            throw new CrudFormException("Msg! \n" + e.getMessage());
        }
    }
}
    


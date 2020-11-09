/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Perdoruesi;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Arta
 */
public class PerdoruesiRepository extends EntMngClass implements PerdoruesiInterface{

    @Override
    public void create(Perdoruesi p2) throws CrudFormException {
       try {
            em.getTransaction().begin();
            em.persist(p2);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Perdoruesi p2) throws CrudFormException {
        try {
            em.getTransaction().begin();
            em.merge(p2);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
        
    }

    @Override
    public void delete(Perdoruesi p2) throws CrudFormException {
        try {
            em.getTransaction().begin();
            em.remove(p2);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Perdoruesi> findAll() throws CrudFormException {
         try {
            return em.createNamedQuery("Perdoruesi.findAll").getResultList();
        } catch (Exception e) {
            throw new CrudFormException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Perdoruesi findByID(Integer ID) throws CrudFormException {
        try {
            Query query = em.createQuery("SELECT p FROM Perdoruesi p WHERE p.ID = :abc");
            query.setParameter("abc", ID);
            return (Perdoruesi) query.getSingleResult();
        } catch (Exception e) {
            throw new CrudFormException("Msg! \n" + e.getMessage());
        }
    }

    @Override
    public Perdoruesi loginByUsernameAndPassword(String u, String p) throws CrudFormException {
        try {
            Query query = em.createQuery("SELECT p FROM Perdoruesi p WHERE p.username = :us AND p.password=:psw");
            query.setParameter("us", u);
            query.setParameter("psw", p);
            return (Perdoruesi) query.getSingleResult();
        } catch (Exception e) {
            throw new CrudFormException("Msg! \n" + e.getMessage());
        }
    
    }
    
}

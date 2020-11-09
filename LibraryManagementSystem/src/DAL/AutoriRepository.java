/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Autori;
import java.util.List;

/**
 *
 * @author Arta
 */
public class AutoriRepository extends EntMngClass implements AutoriInterface{

    @Override
    public void create(Autori a) throws CrudFormException {
        try{
           em.getTransaction().begin();
           em.persist(a);
           em.getTransaction().commit();
       }catch(Exception e){
           throw new CrudFormException("Msg \n" + e.getMessage());
       }
    }

    @Override
    public void edit(Autori a) throws CrudFormException {
     try{
            em.getTransaction().begin();
            em.merge(a);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }    
    }

    @Override
    public void delete(Autori a) throws CrudFormException {
         try{
            em.getTransaction().begin();
            em.remove(a);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Autori> findAll() throws CrudFormException {
        try{
            return em.createNamedQuery("Autori.findAll").getResultList();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public Autori findByID(Integer ID) throws CrudFormException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

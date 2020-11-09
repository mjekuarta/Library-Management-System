/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Publikuesi;
import java.util.List;

/**
 *
 * @author Arta
 */
public class PublikuesiRepository extends EntMngClass implements PublikuesiInterface{

    @Override
    public void create(Publikuesi p) throws CrudFormException {
         try{
           em.getTransaction().begin();
           em.persist(p);
           em.getTransaction().commit();
       }catch(Exception e){
           throw new CrudFormException("Msg \n" + e.getMessage());
       }  
    }

    @Override
    public void edit(Publikuesi p) throws CrudFormException {
         try{
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }    
    }

    @Override
    public void delete(Publikuesi p) throws CrudFormException {
         try{
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }

    }

    @Override
    public List<Publikuesi> findAll() throws CrudFormException {
         try{
            return em.createNamedQuery("Publikuesi.findAll").getResultList();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public Publikuesi findByID(Integer ID) throws CrudFormException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

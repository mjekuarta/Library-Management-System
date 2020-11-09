/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Libri;
import java.util.List;

/**
 *
 * @author Arta
 */
public class LibriRepository extends EntMngClass implements LibriInterface {

    @Override
    public void create(Libri l) throws CrudFormException {
        try{
           em.getTransaction().begin();
           em.persist(l);
           em.getTransaction().commit();
       }catch(Exception e){
           throw new CrudFormException("Msg \n" + e.getMessage());
       }  
    }

    @Override
    public void edit(Libri l) throws CrudFormException {
        try{
            em.getTransaction().begin();
            em.merge(l);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }    
    }

    @Override
    public void delete(Libri l) throws CrudFormException {
            try{
                       em.getTransaction().begin();
                       em.remove(l);
                       em.getTransaction().commit();
                   }catch(Exception e){
                       throw new CrudFormException("Msg \n" + e.getMessage());
                   }  
    }

    @Override
    public List<Libri> findAll() throws CrudFormException {
         try{
            return em.createNamedQuery("Libri.findAll").getResultList();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public Libri findByID(Integer ID) throws CrudFormException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Klienti;
import java.util.List;

/**
 *
 * @author Arta
 */
public class KlientiRepository extends EntMngClass implements KlientiInterface{

    @Override
    public void create(Klienti k1) throws CrudFormException {
        try{
                  em.getTransaction().begin();
                  em.persist(k1);
                  em.getTransaction().commit();
              }catch(Exception e){
                  throw new CrudFormException("Msg \n" + e.getMessage());
              }    
    }

    @Override
    public void edit(Klienti k1) throws CrudFormException {
         try{
            em.getTransaction().begin();
            em.merge(k1);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }    
    }

    @Override
    public void delete(Klienti k1) throws CrudFormException {
        try{
                       em.getTransaction().begin();
                       em.remove(k1);
                       em.getTransaction().commit();
                   }catch(Exception e){
                       throw new CrudFormException("Msg \n" + e.getMessage());
                   }  
    }

    @Override
    public List<Klienti> findAll() throws CrudFormException {
        try{
            return em.createNamedQuery("Klienti.findAll").getResultList();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public Klienti findByID(Integer ID) throws CrudFormException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

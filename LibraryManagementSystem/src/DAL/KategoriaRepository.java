/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Kategoria;
import java.util.List;

/**
 *
 * @author Arta
 */
public class KategoriaRepository extends EntMngClass implements KategoriaInterface {

    @Override
    public void create(Kategoria k) throws CrudFormException {
    try{
           em.getTransaction().begin();
           em.persist(k);
           em.getTransaction().commit();
       }catch(Exception e){
           throw new CrudFormException("Msg \n" + e.getMessage());
       }   
    }

    @Override
    public void edit(Kategoria k) throws CrudFormException {
         try{
            em.getTransaction().begin();
            em.merge(k);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }    

    }

    @Override
    public void delete(Kategoria k) throws CrudFormException {
        try{
            em.getTransaction().begin();
            em.remove(k);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Kategoria> findAll() throws CrudFormException {
          try{
            return em.createNamedQuery("Kategoria.findAll").getResultList();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }

    }

    @Override
    public Kategoria findByID(Integer ID) throws CrudFormException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

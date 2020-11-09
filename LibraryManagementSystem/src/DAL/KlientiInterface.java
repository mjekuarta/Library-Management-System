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
public interface KlientiInterface {
    void create(Klienti k1) throws CrudFormException;
    void edit(Klienti k1) throws CrudFormException;
    void delete(Klienti k1) throws CrudFormException;
    List<Klienti> findAll() throws CrudFormException;
    Klienti findByID(Integer ID) throws CrudFormException;
}

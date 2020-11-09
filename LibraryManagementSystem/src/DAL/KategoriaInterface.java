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
public interface KategoriaInterface {
    void create(Kategoria k) throws CrudFormException;
    void edit(Kategoria k) throws CrudFormException;
    void delete(Kategoria k) throws CrudFormException;
    List<Kategoria> findAll() throws CrudFormException;
    Kategoria findByID(Integer ID) throws CrudFormException;
}

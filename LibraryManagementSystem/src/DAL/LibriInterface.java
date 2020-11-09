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
public interface LibriInterface {
    void create(Libri l) throws CrudFormException;
    void edit(Libri l) throws CrudFormException;
    void delete(Libri l) throws CrudFormException;
    List<Libri> findAll() throws CrudFormException;
    Libri findByID(Integer ID) throws CrudFormException;
}

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
public interface AutoriInterface {
    void create(Autori a) throws CrudFormException;
    void edit(Autori a) throws CrudFormException;
    void delete(Autori a) throws CrudFormException;
    List <Autori> findAll() throws CrudFormException;
    Autori findByID(Integer ID) throws CrudFormException;
}

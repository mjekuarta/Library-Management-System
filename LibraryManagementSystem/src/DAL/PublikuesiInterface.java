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
public interface PublikuesiInterface {
    void create(Publikuesi p) throws CrudFormException;
    void edit(Publikuesi p) throws CrudFormException;
    void delete(Publikuesi p) throws CrudFormException;
    List<Publikuesi> findAll() throws CrudFormException;
    Publikuesi findByID(Integer ID) throws CrudFormException;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Punetori;
import java.util.List;

/**
 *
 * @author Arta
 */
public interface PunetoriInterface {
    void create(Punetori p1) throws CrudFormException;
    void edit(Punetori p1) throws CrudFormException;
    void delete(Punetori p1) throws CrudFormException;
    List<Punetori> findAll() throws CrudFormException;
    Punetori findByID(Integer ID) throws CrudFormException;
    Punetori loginByUsernameAndPassword(String u, String p) throws CrudFormException;
}

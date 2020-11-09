/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Perdoruesi;
import java.util.List;

/**
 *
 * @author Arta
 */
public interface PerdoruesiInterface {
    void create(Perdoruesi p2) throws CrudFormException;
    void edit(Perdoruesi p2) throws CrudFormException;
    void delete(Perdoruesi p2) throws CrudFormException;
    List<Perdoruesi> findAll() throws CrudFormException;
    Perdoruesi findByID(Integer ID) throws CrudFormException;
    Perdoruesi loginByUsernameAndPassword(String u, String p) throws CrudFormException;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Arbenita
 */
@Entity
@Table(name = "Publikuesi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publikuesi.findAll", query = "SELECT p FROM Publikuesi p"),
    @NamedQuery(name = "Publikuesi.findByPublikuesiID", query = "SELECT p FROM Publikuesi p WHERE p.publikuesiID = :publikuesiID"),
    @NamedQuery(name = "Publikuesi.findByEmriPublikuesit", query = "SELECT p FROM Publikuesi p WHERE p.emriPublikuesit = :emriPublikuesit"),
    @NamedQuery(name = "Publikuesi.findByAutoriID", query = "SELECT p FROM Publikuesi p WHERE p.autoriID = :autoriID"),
    @NamedQuery(name = "Publikuesi.findByLibriID", query = "SELECT p FROM Publikuesi p WHERE p.libriID = :libriID")})
public class Publikuesi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PublikuesiID")
    private Integer publikuesiID;
    @Basic(optional = false)
    @Column(name = "EmriPublikuesit")
    private String emriPublikuesit;
    @Column(name = "AutoriID")
    private Integer autoriID;
    @Column(name = "LibriID")
    private Integer libriID;
    @OneToMany(mappedBy = "publikuesiID")
    private Collection<Autori> autoriCollection;
    @OneToMany(mappedBy = "publikuesiID")
    private Collection<Libri> libriCollection;

    public Publikuesi() {
    }

    public Publikuesi(Integer publikuesiID) {
        this.publikuesiID = publikuesiID;
    }

    public Publikuesi(Integer publikuesiID, String emriPublikuesit) {
        this.publikuesiID = publikuesiID;
        this.emriPublikuesit = emriPublikuesit;
    }

    public Integer getPublikuesiID() {
        return publikuesiID;
    }

    public void setPublikuesiID(Integer publikuesiID) {
        this.publikuesiID = publikuesiID;
    }

    public String getEmriPublikuesit() {
        return emriPublikuesit;
    }

    public void setEmriPublikuesit(String emriPublikuesit) {
        this.emriPublikuesit = emriPublikuesit;
    }

    public Integer getAutoriID() {
        return autoriID;
    }

    public void setAutoriID(Integer autoriID) {
        this.autoriID = autoriID;
    }

    public Integer getLibriID() {
        return libriID;
    }

    public void setLibriID(Integer libriID) {
        this.libriID = libriID;
    }

    @XmlTransient
    public Collection<Autori> getAutoriCollection() {
        return autoriCollection;
    }

    public void setAutoriCollection(Collection<Autori> autoriCollection) {
        this.autoriCollection = autoriCollection;
    }

    @XmlTransient
    public Collection<Libri> getLibriCollection() {
        return libriCollection;
    }

    public void setLibriCollection(Collection<Libri> libriCollection) {
        this.libriCollection = libriCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (publikuesiID != null ? publikuesiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publikuesi)) {
            return false;
        }
        Publikuesi other = (Publikuesi) object;
        if ((this.publikuesiID == null && other.publikuesiID != null) || (this.publikuesiID != null && !this.publikuesiID.equals(other.publikuesiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Publikuesi[ publikuesiID=" + publikuesiID + " ]";
    }
    
}

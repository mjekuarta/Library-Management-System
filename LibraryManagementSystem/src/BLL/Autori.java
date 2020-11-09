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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Autori")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autori.findAll", query = "SELECT a FROM Autori a"),
    @NamedQuery(name = "Autori.findByAutoriID", query = "SELECT a FROM Autori a WHERE a.autoriID = :autoriID"),
    @NamedQuery(name = "Autori.findByEmriAutorit", query = "SELECT a FROM Autori a WHERE a.emriAutorit = :emriAutorit"),
    @NamedQuery(name = "Autori.findByMbiemriAutorit", query = "SELECT a FROM Autori a WHERE a.mbiemriAutorit = :mbiemriAutorit"),
    @NamedQuery(name = "Autori.findByLibriID", query = "SELECT a FROM Autori a WHERE a.libriID = :libriID"),
    @NamedQuery(name = "Autori.findByKategoriaID", query = "SELECT a FROM Autori a WHERE a.kategoriaID = :kategoriaID")})
public class Autori implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "AutoriID")
    private Integer autoriID;
    @Basic(optional = false)
    @Column(name = "EmriAutorit")
    private String emriAutorit;
    @Basic(optional = false)
    @Column(name = "MbiemriAutorit")
    private String mbiemriAutorit;
    @Column(name = "LibriID")
    private Integer libriID;
    @Column(name = "KategoriaID")
    private Integer kategoriaID;
    @OneToMany(mappedBy = "autoriID")
    private Collection<Kategoria> kategoriaCollection;
    @JoinColumn(name = "PublikuesiID", referencedColumnName = "PublikuesiID")
    @ManyToOne
    private Publikuesi publikuesiID;
    @OneToMany(mappedBy = "autoriID")
    private Collection<Libri> libriCollection;

    public Autori() {
    }

    public Autori(Integer autoriID) {
        this.autoriID = autoriID;
    }

    public Autori(Integer autoriID, String emriAutorit, String mbiemriAutorit) {
        this.autoriID = autoriID;
        this.emriAutorit = emriAutorit;
        this.mbiemriAutorit = mbiemriAutorit;
    }

    public Integer getAutoriID() {
        return autoriID;
    }

    public void setAutoriID(Integer autoriID) {
        this.autoriID = autoriID;
    }

    public String getEmriAutorit() {
        return emriAutorit;
    }

    public void setEmriAutorit(String emriAutorit) {
        this.emriAutorit = emriAutorit;
    }

    public String getMbiemriAutorit() {
        return mbiemriAutorit;
    }

    public void setMbiemriAutorit(String mbiemriAutorit) {
        this.mbiemriAutorit = mbiemriAutorit;
    }

    public Integer getLibriID() {
        return libriID;
    }

    public void setLibriID(Integer libriID) {
        this.libriID = libriID;
    }

    public Integer getKategoriaID() {
        return kategoriaID;
    }

    public void setKategoriaID(Integer kategoriaID) {
        this.kategoriaID = kategoriaID;
    }

    @XmlTransient
    public Collection<Kategoria> getKategoriaCollection() {
        return kategoriaCollection;
    }

    public void setKategoriaCollection(Collection<Kategoria> kategoriaCollection) {
        this.kategoriaCollection = kategoriaCollection;
    }

    public Publikuesi getPublikuesiID() {
        return publikuesiID;
    }

    public void setPublikuesiID(Publikuesi publikuesiID) {
        this.publikuesiID = publikuesiID;
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
        hash += (autoriID != null ? autoriID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autori)) {
            return false;
        }
        Autori other = (Autori) object;
        if ((this.autoriID == null && other.autoriID != null) || (this.autoriID != null && !this.autoriID.equals(other.autoriID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Autori[ autoriID=" + autoriID + " ]";
    }
    
}

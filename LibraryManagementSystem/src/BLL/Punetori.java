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
@Table(name = "Punetori")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Punetori.findAll", query = "SELECT p FROM Punetori p"),
    @NamedQuery(name = "Punetori.findByPunetoriID", query = "SELECT p FROM Punetori p WHERE p.punetoriID = :punetoriID"),
    @NamedQuery(name = "Punetori.findByEmriPunetorit", query = "SELECT p FROM Punetori p WHERE p.emriPunetorit = :emriPunetorit"),
    @NamedQuery(name = "Punetori.findByPasswordi", query = "SELECT p FROM Punetori p WHERE p.passwordi = :passwordi"),
    @NamedQuery(name = "Punetori.findByEmailiPunetorit", query = "SELECT p FROM Punetori p WHERE p.emailiPunetorit = :emailiPunetorit"),
    @NamedQuery(name = "Punetori.findByLibriID", query = "SELECT p FROM Punetori p WHERE p.libriID = :libriID"),
    @NamedQuery(name = "Punetori.findByKlientiID", query = "SELECT p FROM Punetori p WHERE p.klientiID = :klientiID")})
public class Punetori implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PunetoriID")
    private Integer punetoriID;
    @Basic(optional = false)
    @Column(name = "EmriPunetorit")
    private String emriPunetorit;
    @Basic(optional = false)
    @Column(name = "Passwordi")
    private String passwordi;
    @Basic(optional = false)
    @Column(name = "EmailiPunetorit")
    private String emailiPunetorit;
    @Column(name = "LibriID")
    private Integer libriID;
    @Column(name = "KlientiID")
    private Integer klientiID;
    @OneToMany(mappedBy = "punetoriID")
    private Collection<Klienti> klientiCollection;
    @OneToMany(mappedBy = "punetoriID")
    private Collection<Libri> libriCollection;

    public Punetori() {
    }

    public Punetori(Integer punetoriID) {
        this.punetoriID = punetoriID;
    }

    public Punetori(Integer punetoriID, String emriPunetorit, String passwordi, String emailiPunetorit) {
        this.punetoriID = punetoriID;
        this.emriPunetorit = emriPunetorit;
        this.passwordi = passwordi;
        this.emailiPunetorit = emailiPunetorit;
    }

    public Integer getPunetoriID() {
        return punetoriID;
    }

    public void setPunetoriID(Integer punetoriID) {
        this.punetoriID = punetoriID;
    }

    public String getEmriPunetorit() {
        return emriPunetorit;
    }

    public void setEmriPunetorit(String emriPunetorit) {
        this.emriPunetorit = emriPunetorit;
    }

    public String getPasswordi() {
        return passwordi;
    }

    public void setPasswordi(String passwordi) {
        this.passwordi = passwordi;
    }

    public String getEmailiPunetorit() {
        return emailiPunetorit;
    }

    public void setEmailiPunetorit(String emailiPunetorit) {
        this.emailiPunetorit = emailiPunetorit;
    }

    public Integer getLibriID() {
        return libriID;
    }

    public void setLibriID(Integer libriID) {
        this.libriID = libriID;
    }

    public Integer getKlientiID() {
        return klientiID;
    }

    public void setKlientiID(Integer klientiID) {
        this.klientiID = klientiID;
    }

    @XmlTransient
    public Collection<Klienti> getKlientiCollection() {
        return klientiCollection;
    }

    public void setKlientiCollection(Collection<Klienti> klientiCollection) {
        this.klientiCollection = klientiCollection;
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
        hash += (punetoriID != null ? punetoriID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Punetori)) {
            return false;
        }
        Punetori other = (Punetori) object;
        if ((this.punetoriID == null && other.punetoriID != null) || (this.punetoriID != null && !this.punetoriID.equals(other.punetoriID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Punetori[ punetoriID=" + punetoriID + " ]";
    }
    
}

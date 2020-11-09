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
@Table(name = "Kategoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kategoria.findAll", query = "SELECT k FROM Kategoria k"),
    @NamedQuery(name = "Kategoria.findByKategoriaID", query = "SELECT k FROM Kategoria k WHERE k.kategoriaID = :kategoriaID"),
    @NamedQuery(name = "Kategoria.findByEmriKategorise", query = "SELECT k FROM Kategoria k WHERE k.emriKategorise = :emriKategorise"),
    @NamedQuery(name = "Kategoria.findByLibriID", query = "SELECT k FROM Kategoria k WHERE k.libriID = :libriID")})
public class Kategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KategoriaID")
    private Integer kategoriaID;
    @Basic(optional = false)
    @Column(name = "EmriKategorise")
    private String emriKategorise;
    @Column(name = "LibriID")
    private Integer libriID;
    @JoinColumn(name = "AutoriID", referencedColumnName = "AutoriID")
    @ManyToOne
    private Autori autoriID;
    @OneToMany(mappedBy = "kategoriaID")
    private Collection<Libri> libriCollection;

    public Kategoria() {
    }

    public Kategoria(Integer kategoriaID) {
        this.kategoriaID = kategoriaID;
    }

    public Kategoria(Integer kategoriaID, String emriKategorise) {
        this.kategoriaID = kategoriaID;
        this.emriKategorise = emriKategorise;
    }

    public Integer getKategoriaID() {
        return kategoriaID;
    }

    public void setKategoriaID(Integer kategoriaID) {
        this.kategoriaID = kategoriaID;
    }

    public String getEmriKategorise() {
        return emriKategorise;
    }

    public void setEmriKategorise(String emriKategorise) {
        this.emriKategorise = emriKategorise;
    }

    public Integer getLibriID() {
        return libriID;
    }

    public void setLibriID(Integer libriID) {
        this.libriID = libriID;
    }

    public Autori getAutoriID() {
        return autoriID;
    }

    public void setAutoriID(Autori autoriID) {
        this.autoriID = autoriID;
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
        hash += (kategoriaID != null ? kategoriaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kategoria)) {
            return false;
        }
        Kategoria other = (Kategoria) object;
        if ((this.kategoriaID == null && other.kategoriaID != null) || (this.kategoriaID != null && !this.kategoriaID.equals(other.kategoriaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Kategoria[ kategoriaID=" + kategoriaID + " ]";
    }
    
}

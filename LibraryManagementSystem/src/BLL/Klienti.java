/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Arbenita
 */
@Entity
@Table(name = "Klienti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klienti.findAll", query = "SELECT k FROM Klienti k"),
    @NamedQuery(name = "Klienti.findByKlientiID", query = "SELECT k FROM Klienti k WHERE k.klientiID = :klientiID"),
    @NamedQuery(name = "Klienti.findByEmriKlientit", query = "SELECT k FROM Klienti k WHERE k.emriKlientit = :emriKlientit"),
    @NamedQuery(name = "Klienti.findByNumriTelefonitKlientit", query = "SELECT k FROM Klienti k WHERE k.numriTelefonitKlientit = :numriTelefonitKlientit"),
    @NamedQuery(name = "Klienti.findByEmailiKlientit", query = "SELECT k FROM Klienti k WHERE k.emailiKlientit = :emailiKlientit"),
    @NamedQuery(name = "Klienti.findByLibriID", query = "SELECT k FROM Klienti k WHERE k.libriID = :libriID"),
    @NamedQuery(name = "Klienti.findByDataLindjes", query = "SELECT k FROM Klienti k WHERE k.dataLindjes = :dataLindjes")})
public class Klienti implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KlientiID")
    private Integer klientiID;
    @Basic(optional = false)
    @Column(name = "EmriKlientit")
    private String emriKlientit;
    @Basic(optional = false)
    @Column(name = "NumriTelefonitKlientit")
    private int numriTelefonitKlientit;
    @Basic(optional = false)
    @Column(name = "EmailiKlientit")
    private String emailiKlientit;
    @Column(name = "LibriID")
    private Integer libriID;
    @Basic(optional = false)
    @Column(name = "DataLindjes")
    @Temporal(TemporalType.DATE)
    private Date dataLindjes;
    @JoinColumn(name = "PunetoriID", referencedColumnName = "PunetoriID")
    @ManyToOne
    private Punetori punetoriID;
    @OneToMany(mappedBy = "klientiID")
    private Collection<Libri> libriCollection;

    public Klienti() {
    }

    public Klienti(Integer klientiID) {
        this.klientiID = klientiID;
    }

    public Klienti(Integer klientiID, String emriKlientit, int numriTelefonitKlientit, String emailiKlientit, Date dataLindjes) {
        this.klientiID = klientiID;
        this.emriKlientit = emriKlientit;
        this.numriTelefonitKlientit = numriTelefonitKlientit;
        this.emailiKlientit = emailiKlientit;
        this.dataLindjes = dataLindjes;
    }

    public Integer getKlientiID() {
        return klientiID;
    }

    public void setKlientiID(Integer klientiID) {
        this.klientiID = klientiID;
    }

    public String getEmriKlientit() {
        return emriKlientit;
    }

    public void setEmriKlientit(String emriKlientit) {
        this.emriKlientit = emriKlientit;
    }

    public int getNumriTelefonitKlientit() {
        return numriTelefonitKlientit;
    }

    public void setNumriTelefonitKlientit(int numriTelefonitKlientit) {
        this.numriTelefonitKlientit = numriTelefonitKlientit;
    }

    public String getEmailiKlientit() {
        return emailiKlientit;
    }

    public void setEmailiKlientit(String emailiKlientit) {
        this.emailiKlientit = emailiKlientit;
    }

    public Integer getLibriID() {
        return libriID;
    }

    public void setLibriID(Integer libriID) {
        this.libriID = libriID;
    }

    public Date getDataLindjes() {
        return dataLindjes;
    }

    public void setDataLindjes(Date dataLindjes) {
        this.dataLindjes = dataLindjes;
    }

    public Punetori getPunetoriID() {
        return punetoriID;
    }

    public void setPunetoriID(Punetori punetoriID) {
        this.punetoriID = punetoriID;
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
        hash += (klientiID != null ? klientiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klienti)) {
            return false;
        }
        Klienti other = (Klienti) object;
        if ((this.klientiID == null && other.klientiID != null) || (this.klientiID != null && !this.klientiID.equals(other.klientiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return klientiID + " : "  + emriKlientit;
    }
    
}

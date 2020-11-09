/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Arbenita
 */
@Entity
@Table(name = "Libri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libri.findAll", query = "SELECT l FROM Libri l"),
    @NamedQuery(name = "Libri.findByLibriID", query = "SELECT l FROM Libri l WHERE l.libriID = :libriID"),
    @NamedQuery(name = "Libri.findByTitulliLibrit", query = "SELECT l FROM Libri l WHERE l.titulliLibrit = :titulliLibrit"),
    @NamedQuery(name = "Libri.findByPath", query = "SELECT l FROM Libri l WHERE l.path = :path")})
public class Libri implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LibriID")
    
      @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq" , sequenceName = "INV_SEQ", allocationSize = 1)
    
    private Integer libriID;
    @Basic(optional = false)
    @Column(name = "TitulliLibrit")
    private String titulliLibrit;
    @Column(name = "Path")
    private String path;
    @JoinColumn(name = "AutoriID", referencedColumnName = "AutoriID")
    @ManyToOne
    private Autori autoriID;
    @JoinColumn(name = "KategoriaID", referencedColumnName = "KategoriaID")
    @ManyToOne
    private Kategoria kategoriaID;
    @JoinColumn(name = "KlientiID", referencedColumnName = "KlientiID")
    @ManyToOne
    private Klienti klientiID;
    @JoinColumn(name = "PublikuesiID", referencedColumnName = "PublikuesiID")
    @ManyToOne
    private Publikuesi publikuesiID;
    @JoinColumn(name = "PunetoriID", referencedColumnName = "PunetoriID")
    @ManyToOne
    private Punetori punetoriID;

    public Libri() {
    }

    public Libri(Integer libriID) {
        this.libriID = libriID;
    }

    public Libri(Integer libriID, String titulliLibrit) {
        this.libriID = libriID;
        this.titulliLibrit = titulliLibrit;
    }

    public Integer getLibriID() {
        return libriID;
    }

    public void setLibriID(Integer libriID) {
        this.libriID = libriID;
    }

    public String getTitulliLibrit() {
        return titulliLibrit;
    }

    public void setTitulliLibrit(String titulliLibrit) {
        this.titulliLibrit = titulliLibrit;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Autori getAutoriID() {
        return autoriID;
    }

    public void setAutoriID(Autori autoriID) {
        this.autoriID = autoriID;
    }

    public Kategoria getKategoriaID() {
        return kategoriaID;
    }

    public void setKategoriaID(Kategoria kategoriaID) {
        this.kategoriaID = kategoriaID;
    }

    public Klienti getKlientiID() {
        return klientiID;
    }

    public void setKlientiID(Klienti klientiID) {
        this.klientiID = klientiID;
    }

    public Publikuesi getPublikuesiID() {
        return publikuesiID;
    }

    public void setPublikuesiID(Publikuesi publikuesiID) {
        this.publikuesiID = publikuesiID;
    }

    public Punetori getPunetoriID() {
        return punetoriID;
    }

    public void setPunetoriID(Punetori punetoriID) {
        this.punetoriID = punetoriID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (libriID != null ? libriID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libri)) {
            return false;
        }
        Libri other = (Libri) object;
        if ((this.libriID == null && other.libriID != null) || (this.libriID != null && !this.libriID.equals(other.libriID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Libri[ libriID=" + libriID + " ]";
    }
    
}

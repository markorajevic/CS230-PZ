/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MarkoMB
 */
@Entity
@Table(name = "tipklijenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipklijenta.findAll", query = "SELECT t FROM Tipklijenta t")
    , @NamedQuery(name = "Tipklijenta.findByIdtipaklijenta", query = "SELECT t FROM Tipklijenta t WHERE t.idtipaklijenta = :idtipaklijenta")})
public class Tipklijenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTIPAKLIJENTA")
    private Integer idtipaklijenta;
    @Lob
    @Size(max = 65535)
    @Column(name = "OPISTIPAKLIJENTA")
    private String opistipaklijenta;
    @OneToMany(mappedBy = "idtipaklijenta")
    private Collection<Klijent> klijentCollection;

    public Tipklijenta() {
    }

    public Tipklijenta(Integer idtipaklijenta) {
        this.idtipaklijenta = idtipaklijenta;
    }

    public Integer getIdtipaklijenta() {
        return idtipaklijenta;
    }

    public void setIdtipaklijenta(Integer idtipaklijenta) {
        this.idtipaklijenta = idtipaklijenta;
    }

    public String getOpistipaklijenta() {
        return opistipaklijenta;
    }

    public void setOpistipaklijenta(String opistipaklijenta) {
        this.opistipaklijenta = opistipaklijenta;
    }

    @XmlTransient
    public Collection<Klijent> getKlijentCollection() {
        return klijentCollection;
    }

    public void setKlijentCollection(Collection<Klijent> klijentCollection) {
        this.klijentCollection = klijentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipaklijenta != null ? idtipaklijenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipklijenta)) {
            return false;
        }
        Tipklijenta other = (Tipklijenta) object;
        if ((this.idtipaklijenta == null && other.idtipaklijenta != null) || (this.idtipaklijenta != null && !this.idtipaklijenta.equals(other.idtipaklijenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tipklijenta[ idtipaklijenta=" + idtipaklijenta + " ]";
    }
    
}

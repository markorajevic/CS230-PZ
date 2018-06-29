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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "mesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mesto.findAll", query = "SELECT m FROM Mesto m")
    , @NamedQuery(name = "Mesto.findByIdmesta", query = "SELECT m FROM Mesto m WHERE m.idmesta = :idmesta")})
public class Mesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDMESTA")
    private Integer idmesta;
    @Lob
    @Size(max = 65535)
    @Column(name = "NAZIVMESTA")
    private String nazivmesta;
    @JoinColumn(name = "IDDRZAVE", referencedColumnName = "IDDRZAVE")
    @ManyToOne
    private Drzava iddrzave;
    @OneToMany(mappedBy = "idmesta")
    private Collection<Nepokretnost> nepokretnostCollection;

    public Mesto() {
    }

    public Mesto(Integer idmesta) {
        this.idmesta = idmesta;
    }

    public Integer getIdmesta() {
        return idmesta;
    }

    public void setIdmesta(Integer idmesta) {
        this.idmesta = idmesta;
    }

    public String getNazivmesta() {
        return nazivmesta;
    }

    public void setNazivmesta(String nazivmesta) {
        this.nazivmesta = nazivmesta;
    }

    public Drzava getIddrzave() {
        return iddrzave;
    }

    public void setIddrzave(Drzava iddrzave) {
        this.iddrzave = iddrzave;
    }

    @XmlTransient
    public Collection<Nepokretnost> getNepokretnostCollection() {
        return nepokretnostCollection;
    }

    public void setNepokretnostCollection(Collection<Nepokretnost> nepokretnostCollection) {
        this.nepokretnostCollection = nepokretnostCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmesta != null ? idmesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mesto)) {
            return false;
        }
        Mesto other = (Mesto) object;
        if ((this.idmesta == null && other.idmesta != null) || (this.idmesta != null && !this.idmesta.equals(other.idmesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Mesto[ idmesta=" + idmesta + " ]";
    }
    
}

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
@Table(name = "tipnaknade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipnaknade.findAll", query = "SELECT t FROM Tipnaknade t")
    , @NamedQuery(name = "Tipnaknade.findByIdtipanaknade", query = "SELECT t FROM Tipnaknade t WHERE t.idtipanaknade = :idtipanaknade")})
public class Tipnaknade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTIPANAKNADE")
    private Integer idtipanaknade;
    @Lob
    @Size(max = 65535)
    @Column(name = "OPISTIPANAKNADE")
    private String opistipanaknade;
    @OneToMany(mappedBy = "idtipanaknade")
    private Collection<Ugovor> ugovorCollection;

    public Tipnaknade() {
    }

    public Tipnaknade(Integer idtipanaknade) {
        this.idtipanaknade = idtipanaknade;
    }

    public Integer getIdtipanaknade() {
        return idtipanaknade;
    }

    public void setIdtipanaknade(Integer idtipanaknade) {
        this.idtipanaknade = idtipanaknade;
    }

    public String getOpistipanaknade() {
        return opistipanaknade;
    }

    public void setOpistipanaknade(String opistipanaknade) {
        this.opistipanaknade = opistipanaknade;
    }

    @XmlTransient
    public Collection<Ugovor> getUgovorCollection() {
        return ugovorCollection;
    }

    public void setUgovorCollection(Collection<Ugovor> ugovorCollection) {
        this.ugovorCollection = ugovorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipanaknade != null ? idtipanaknade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipnaknade)) {
            return false;
        }
        Tipnaknade other = (Tipnaknade) object;
        if ((this.idtipanaknade == null && other.idtipanaknade != null) || (this.idtipanaknade != null && !this.idtipanaknade.equals(other.idtipanaknade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tipnaknade[ idtipanaknade=" + idtipanaknade + " ]";
    }
    
}

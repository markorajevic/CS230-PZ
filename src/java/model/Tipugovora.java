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
@Table(name = "tipugovora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipugovora.findAll", query = "SELECT t FROM Tipugovora t")
    , @NamedQuery(name = "Tipugovora.findByIdtipaugovora", query = "SELECT t FROM Tipugovora t WHERE t.idtipaugovora = :idtipaugovora")})
public class Tipugovora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTIPAUGOVORA")
    private Integer idtipaugovora;
    @Lob
    @Size(max = 65535)
    @Column(name = "OPISTIPAUGOVORA")
    private String opistipaugovora;
    @OneToMany(mappedBy = "idtipaugovora")
    private Collection<Ugovor> ugovorCollection;

    public Tipugovora() {
    }

    public Tipugovora(Integer idtipaugovora) {
        this.idtipaugovora = idtipaugovora;
    }

    public Integer getIdtipaugovora() {
        return idtipaugovora;
    }

    public void setIdtipaugovora(Integer idtipaugovora) {
        this.idtipaugovora = idtipaugovora;
    }

    public String getOpistipaugovora() {
        return opistipaugovora;
    }

    public void setOpistipaugovora(String opistipaugovora) {
        this.opistipaugovora = opistipaugovora;
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
        hash += (idtipaugovora != null ? idtipaugovora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipugovora)) {
            return false;
        }
        Tipugovora other = (Tipugovora) object;
        if ((this.idtipaugovora == null && other.idtipaugovora != null) || (this.idtipaugovora != null && !this.idtipaugovora.equals(other.idtipaugovora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tipugovora[ idtipaugovora=" + idtipaugovora + " ]";
    }
    
}

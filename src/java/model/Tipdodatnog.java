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
@Table(name = "tipdodatnog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipdodatnog.findAll", query = "SELECT t FROM Tipdodatnog t")
    , @NamedQuery(name = "Tipdodatnog.findByIdtipadodatnog", query = "SELECT t FROM Tipdodatnog t WHERE t.idtipadodatnog = :idtipadodatnog")})
public class Tipdodatnog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTIPADODATNOG")
    private Integer idtipadodatnog;
    @Lob
    @Size(max = 65535)
    @Column(name = "OPISTIPADODATNOG")
    private String opistipadodatnog;
    @OneToMany(mappedBy = "idtipadodatnog")
    private Collection<Dodatno> dodatnoCollection;

    public Tipdodatnog() {
    }

    public Tipdodatnog(Integer idtipadodatnog) {
        this.idtipadodatnog = idtipadodatnog;
    }

    public Integer getIdtipadodatnog() {
        return idtipadodatnog;
    }

    public void setIdtipadodatnog(Integer idtipadodatnog) {
        this.idtipadodatnog = idtipadodatnog;
    }

    public String getOpistipadodatnog() {
        return opistipadodatnog;
    }

    public void setOpistipadodatnog(String opistipadodatnog) {
        this.opistipadodatnog = opistipadodatnog;
    }

    @XmlTransient
    public Collection<Dodatno> getDodatnoCollection() {
        return dodatnoCollection;
    }

    public void setDodatnoCollection(Collection<Dodatno> dodatnoCollection) {
        this.dodatnoCollection = dodatnoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipadodatnog != null ? idtipadodatnog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipdodatnog)) {
            return false;
        }
        Tipdodatnog other = (Tipdodatnog) object;
        if ((this.idtipadodatnog == null && other.idtipadodatnog != null) || (this.idtipadodatnog != null && !this.idtipadodatnog.equals(other.idtipadodatnog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tipdodatnog[ idtipadodatnog=" + idtipadodatnog + " ]";
    }
    
}

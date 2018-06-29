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
@Table(name = "tipnepokretnosti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipnepokretnosti.findAll", query = "SELECT t FROM Tipnepokretnosti t")
    , @NamedQuery(name = "Tipnepokretnosti.findByIdtipanepokretnosti", query = "SELECT t FROM Tipnepokretnosti t WHERE t.idtipanepokretnosti = :idtipanepokretnosti")})
public class Tipnepokretnosti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTIPANEPOKRETNOSTI")
    private Integer idtipanepokretnosti;
    @Lob
    @Size(max = 65535)
    @Column(name = "OPISTIPANEPOKRETNOSTI")
    private String opistipanepokretnosti;
    @OneToMany(mappedBy = "idtipanepokretnosti")
    private Collection<Nepokretnost> nepokretnostCollection;

    public Tipnepokretnosti() {
    }

    public Tipnepokretnosti(Integer idtipanepokretnosti) {
        this.idtipanepokretnosti = idtipanepokretnosti;
    }

    public Integer getIdtipanepokretnosti() {
        return idtipanepokretnosti;
    }

    public void setIdtipanepokretnosti(Integer idtipanepokretnosti) {
        this.idtipanepokretnosti = idtipanepokretnosti;
    }

    public String getOpistipanepokretnosti() {
        return opistipanepokretnosti;
    }

    public void setOpistipanepokretnosti(String opistipanepokretnosti) {
        this.opistipanepokretnosti = opistipanepokretnosti;
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
        hash += (idtipanepokretnosti != null ? idtipanepokretnosti.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipnepokretnosti)) {
            return false;
        }
        Tipnepokretnosti other = (Tipnepokretnosti) object;
        if ((this.idtipanepokretnosti == null && other.idtipanepokretnosti != null) || (this.idtipanepokretnosti != null && !this.idtipanepokretnosti.equals(other.idtipanepokretnosti))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tipnepokretnosti[ idtipanepokretnosti=" + idtipanepokretnosti + " ]";
    }
    
}

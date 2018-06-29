/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MarkoMB
 */
@Entity
@Table(name = "fotografija")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fotografija.findAll", query = "SELECT f FROM Fotografija f")
    , @NamedQuery(name = "Fotografija.findByIdfotografije", query = "SELECT f FROM Fotografija f WHERE f.idfotografije = :idfotografije")})
public class Fotografija implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFOTOGRAFIJE")
    private Integer idfotografije;
    @Lob
    @Size(max = 65535)
    @Column(name = "URLFOTOGRAFIJE")
    private String urlfotografije;
    @JoinColumn(name = "IDNEPOKRETNOSTI", referencedColumnName = "IDNEPOKRETNOSTI")
    @ManyToOne
    private Nepokretnost idnepokretnosti;

    public Fotografija() {
    }

    public Fotografija(Integer idfotografije) {
        this.idfotografije = idfotografije;
    }

    public Integer getIdfotografije() {
        return idfotografije;
    }

    public void setIdfotografije(Integer idfotografije) {
        this.idfotografije = idfotografije;
    }

    public String getUrlfotografije() {
        return urlfotografije;
    }

    public void setUrlfotografije(String urlfotografije) {
        this.urlfotografije = urlfotografije;
    }

    public Nepokretnost getIdnepokretnosti() {
        return idnepokretnosti;
    }

    public void setIdnepokretnosti(Nepokretnost idnepokretnosti) {
        this.idnepokretnosti = idnepokretnosti;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfotografije != null ? idfotografije.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fotografija)) {
            return false;
        }
        Fotografija other = (Fotografija) object;
        if ((this.idfotografije == null && other.idfotografije != null) || (this.idfotografije != null && !this.idfotografije.equals(other.idfotografije))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Fotografija[ idfotografije=" + idfotografije + " ]";
    }
    
}

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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MarkoMB
 */
@Entity
@Table(name = "interesovanje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Interesovanje.findAll", query = "SELECT i FROM Interesovanje i")
    , @NamedQuery(name = "Interesovanje.findByIdinteresovanja", query = "SELECT i FROM Interesovanje i WHERE i.idinteresovanja = :idinteresovanja")})
public class Interesovanje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDINTERESOVANJA")
    private Integer idinteresovanja;
    @JoinColumn(name = "IDNEPOKRETNOSTI", referencedColumnName = "IDNEPOKRETNOSTI")
    @ManyToOne
    private Nepokretnost idnepokretnosti;
    @JoinColumn(name = "IDKLIJENTA", referencedColumnName = "IDKLIJENTA")
    @ManyToOne
    private Klijent idklijenta;

    public Interesovanje() {
    }

    public Interesovanje(Integer idinteresovanja) {
        this.idinteresovanja = idinteresovanja;
    }

    public Integer getIdinteresovanja() {
        return idinteresovanja;
    }

    public void setIdinteresovanja(Integer idinteresovanja) {
        this.idinteresovanja = idinteresovanja;
    }

    public Nepokretnost getIdnepokretnosti() {
        return idnepokretnosti;
    }

    public void setIdnepokretnosti(Nepokretnost idnepokretnosti) {
        this.idnepokretnosti = idnepokretnosti;
    }

    public Klijent getIdklijenta() {
        return idklijenta;
    }

    public void setIdklijenta(Klijent idklijenta) {
        this.idklijenta = idklijenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinteresovanja != null ? idinteresovanja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Interesovanje)) {
            return false;
        }
        Interesovanje other = (Interesovanje) object;
        if ((this.idinteresovanja == null && other.idinteresovanja != null) || (this.idinteresovanja != null && !this.idinteresovanja.equals(other.idinteresovanja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Interesovanje[ idinteresovanja=" + idinteresovanja + " ]";
    }
    
}

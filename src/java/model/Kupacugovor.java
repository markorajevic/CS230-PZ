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
@Table(name = "kupacugovor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kupacugovor.findAll", query = "SELECT k FROM Kupacugovor k")
    , @NamedQuery(name = "Kupacugovor.findByIdkupacugovor", query = "SELECT k FROM Kupacugovor k WHERE k.idkupacugovor = :idkupacugovor")})
public class Kupacugovor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDKUPACUGOVOR")
    private Integer idkupacugovor;
    @JoinColumn(name = "IDKLIJENTA", referencedColumnName = "IDKLIJENTA")
    @ManyToOne
    private Klijent idklijenta;
    @JoinColumn(name = "IDUGOVORA", referencedColumnName = "IDUGOVORA")
    @ManyToOne
    private Ugovor idugovora;

    public Kupacugovor() {
    }

    public Kupacugovor(Integer idkupacugovor) {
        this.idkupacugovor = idkupacugovor;
    }

    public Integer getIdkupacugovor() {
        return idkupacugovor;
    }

    public void setIdkupacugovor(Integer idkupacugovor) {
        this.idkupacugovor = idkupacugovor;
    }

    public Klijent getIdklijenta() {
        return idklijenta;
    }

    public void setIdklijenta(Klijent idklijenta) {
        this.idklijenta = idklijenta;
    }

    public Ugovor getIdugovora() {
        return idugovora;
    }

    public void setIdugovora(Ugovor idugovora) {
        this.idugovora = idugovora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idkupacugovor != null ? idkupacugovor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kupacugovor)) {
            return false;
        }
        Kupacugovor other = (Kupacugovor) object;
        if ((this.idkupacugovor == null && other.idkupacugovor != null) || (this.idkupacugovor != null && !this.idkupacugovor.equals(other.idkupacugovor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Kupacugovor[ idkupacugovor=" + idkupacugovor + " ]";
    }
    
}

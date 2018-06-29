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
@Table(name = "prodavacugovor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prodavacugovor.findAll", query = "SELECT p FROM Prodavacugovor p")
    , @NamedQuery(name = "Prodavacugovor.findByIdprodavacugovor", query = "SELECT p FROM Prodavacugovor p WHERE p.idprodavacugovor = :idprodavacugovor")})
public class Prodavacugovor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPRODAVACUGOVOR")
    private Integer idprodavacugovor;
    @JoinColumn(name = "IDKLIJENTA", referencedColumnName = "IDKLIJENTA")
    @ManyToOne
    private Klijent idklijenta;
    @JoinColumn(name = "IDUGOVORA", referencedColumnName = "IDUGOVORA")
    @ManyToOne
    private Ugovor idugovora;

    public Prodavacugovor() {
    }

    public Prodavacugovor(Integer idprodavacugovor) {
        this.idprodavacugovor = idprodavacugovor;
    }

    public Integer getIdprodavacugovor() {
        return idprodavacugovor;
    }

    public void setIdprodavacugovor(Integer idprodavacugovor) {
        this.idprodavacugovor = idprodavacugovor;
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
        hash += (idprodavacugovor != null ? idprodavacugovor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prodavacugovor)) {
            return false;
        }
        Prodavacugovor other = (Prodavacugovor) object;
        if ((this.idprodavacugovor == null && other.idprodavacugovor != null) || (this.idprodavacugovor != null && !this.idprodavacugovor.equals(other.idprodavacugovor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Prodavacugovor[ idprodavacugovor=" + idprodavacugovor + " ]";
    }
    
}

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
@Table(name = "vlasniknepokretnost")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vlasniknepokretnost.findAll", query = "SELECT v FROM Vlasniknepokretnost v")
    , @NamedQuery(name = "Vlasniknepokretnost.findByIdvlasniknepokretnost", query = "SELECT v FROM Vlasniknepokretnost v WHERE v.idvlasniknepokretnost = :idvlasniknepokretnost")})
public class Vlasniknepokretnost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDVLASNIKNEPOKRETNOST")
    private Integer idvlasniknepokretnost;
    @JoinColumn(name = "IDNEPOKRETNOSTI", referencedColumnName = "IDNEPOKRETNOSTI")
    @ManyToOne
    private Nepokretnost idnepokretnosti;
    @JoinColumn(name = "IDKLIJENTA", referencedColumnName = "IDKLIJENTA")
    @ManyToOne
    private Klijent idklijenta;

    public Vlasniknepokretnost() {
    }

    public Vlasniknepokretnost(Integer idvlasniknepokretnost) {
        this.idvlasniknepokretnost = idvlasniknepokretnost;
    }

    public Integer getIdvlasniknepokretnost() {
        return idvlasniknepokretnost;
    }

    public void setIdvlasniknepokretnost(Integer idvlasniknepokretnost) {
        this.idvlasniknepokretnost = idvlasniknepokretnost;
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
        hash += (idvlasniknepokretnost != null ? idvlasniknepokretnost.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vlasniknepokretnost)) {
            return false;
        }
        Vlasniknepokretnost other = (Vlasniknepokretnost) object;
        if ((this.idvlasniknepokretnost == null && other.idvlasniknepokretnost != null) || (this.idvlasniknepokretnost != null && !this.idvlasniknepokretnost.equals(other.idvlasniknepokretnost))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Vlasniknepokretnost[ idvlasniknepokretnost=" + idvlasniknepokretnost + " ]";
    }
    
}

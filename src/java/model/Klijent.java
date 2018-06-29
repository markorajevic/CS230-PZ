/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "klijent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klijent.findAll", query = "SELECT k FROM Klijent k")
    , @NamedQuery(name = "Klijent.findByIdklijenta", query = "SELECT k FROM Klijent k WHERE k.idklijenta = :idklijenta")
    , @NamedQuery(name = "Klijent.findByMaticnibrojklijenta", query = "SELECT k FROM Klijent k WHERE k.maticnibrojklijenta = :maticnibrojklijenta")
    , @NamedQuery(name = "Klijent.findByBrojlicnekarteklijenta", query = "SELECT k FROM Klijent k WHERE k.brojlicnekarteklijenta = :brojlicnekarteklijenta")})
public class Klijent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDKLIJENTA")
    private Integer idklijenta;
    @Lob
    @Size(max = 65535)
    @Column(name = "IMEKLIJENTA")
    private String imeklijenta;
    @Lob
    @Size(max = 65535)
    @Column(name = "PREZIMEKLIJENTA")
    private String prezimeklijenta;
    @Lob
    @Size(max = 65535)
    @Column(name = "ADRESAKLIJENTA")
    private String adresaklijenta;
    @Lob
    @Size(max = 65535)
    @Column(name = "TELEFONKLIJENTA")
    private String telefonklijenta;
    @Column(name = "MATICNIBROJKLIJENTA")
    private BigInteger maticnibrojklijenta;
    @Column(name = "BROJLICNEKARTEKLIJENTA")
    private BigInteger brojlicnekarteklijenta;
    @OneToMany(mappedBy = "idklijenta")
    private Collection<Prodavacugovor> prodavacugovorCollection;
    @JoinColumn(name = "IDTIPAKLIJENTA", referencedColumnName = "IDTIPAKLIJENTA")
    @ManyToOne
    private Tipklijenta idtipaklijenta;
    @OneToMany(mappedBy = "idklijenta")
    private Collection<Interesovanje> interesovanjeCollection;
    @OneToMany(mappedBy = "idklijenta")
    private Collection<Vlasniknepokretnost> vlasniknepokretnostCollection;
    @OneToMany(mappedBy = "idklijenta")
    private Collection<Kupacugovor> kupacugovorCollection;

    public Klijent() {
    }

    public Klijent(Integer idklijenta) {
        this.idklijenta = idklijenta;
    }

    public Integer getIdklijenta() {
        return idklijenta;
    }

    public void setIdklijenta(Integer idklijenta) {
        this.idklijenta = idklijenta;
    }

    public String getImeklijenta() {
        return imeklijenta;
    }

    public void setImeklijenta(String imeklijenta) {
        this.imeklijenta = imeklijenta;
    }

    public String getPrezimeklijenta() {
        return prezimeklijenta;
    }

    public void setPrezimeklijenta(String prezimeklijenta) {
        this.prezimeklijenta = prezimeklijenta;
    }

    public String getAdresaklijenta() {
        return adresaklijenta;
    }

    public void setAdresaklijenta(String adresaklijenta) {
        this.adresaklijenta = adresaklijenta;
    }

    public String getTelefonklijenta() {
        return telefonklijenta;
    }

    public void setTelefonklijenta(String telefonklijenta) {
        this.telefonklijenta = telefonklijenta;
    }

    public BigInteger getMaticnibrojklijenta() {
        return maticnibrojklijenta;
    }

    public void setMaticnibrojklijenta(BigInteger maticnibrojklijenta) {
        this.maticnibrojklijenta = maticnibrojklijenta;
    }

    public BigInteger getBrojlicnekarteklijenta() {
        return brojlicnekarteklijenta;
    }

    public void setBrojlicnekarteklijenta(BigInteger brojlicnekarteklijenta) {
        this.brojlicnekarteklijenta = brojlicnekarteklijenta;
    }

    @XmlTransient
    public Collection<Prodavacugovor> getProdavacugovorCollection() {
        return prodavacugovorCollection;
    }

    public void setProdavacugovorCollection(Collection<Prodavacugovor> prodavacugovorCollection) {
        this.prodavacugovorCollection = prodavacugovorCollection;
    }

    public Tipklijenta getIdtipaklijenta() {
        return idtipaklijenta;
    }

    public void setIdtipaklijenta(Tipklijenta idtipaklijenta) {
        this.idtipaklijenta = idtipaklijenta;
    }

    @XmlTransient
    public Collection<Interesovanje> getInteresovanjeCollection() {
        return interesovanjeCollection;
    }

    public void setInteresovanjeCollection(Collection<Interesovanje> interesovanjeCollection) {
        this.interesovanjeCollection = interesovanjeCollection;
    }

    @XmlTransient
    public Collection<Vlasniknepokretnost> getVlasniknepokretnostCollection() {
        return vlasniknepokretnostCollection;
    }

    public void setVlasniknepokretnostCollection(Collection<Vlasniknepokretnost> vlasniknepokretnostCollection) {
        this.vlasniknepokretnostCollection = vlasniknepokretnostCollection;
    }

    @XmlTransient
    public Collection<Kupacugovor> getKupacugovorCollection() {
        return kupacugovorCollection;
    }

    public void setKupacugovorCollection(Collection<Kupacugovor> kupacugovorCollection) {
        this.kupacugovorCollection = kupacugovorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idklijenta != null ? idklijenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klijent)) {
            return false;
        }
        Klijent other = (Klijent) object;
        if ((this.idklijenta == null && other.idklijenta != null) || (this.idklijenta != null && !this.idklijenta.equals(other.idklijenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Klijent[ idklijenta=" + idklijenta + " ]";
    }
    
}

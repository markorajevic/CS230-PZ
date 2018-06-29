/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MarkoMB
 */
@Entity
@Table(name = "ugovor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ugovor.findAll", query = "SELECT u FROM Ugovor u")
    , @NamedQuery(name = "Ugovor.findByIdugovora", query = "SELECT u FROM Ugovor u WHERE u.idugovora = :idugovora")
    , @NamedQuery(name = "Ugovor.findByDatumnastanka", query = "SELECT u FROM Ugovor u WHERE u.datumnastanka = :datumnastanka")
    , @NamedQuery(name = "Ugovor.findByDatumisticanja", query = "SELECT u FROM Ugovor u WHERE u.datumisticanja = :datumisticanja")
    , @NamedQuery(name = "Ugovor.findByIznos", query = "SELECT u FROM Ugovor u WHERE u.iznos = :iznos")
    , @NamedQuery(name = "Ugovor.findByIznosnaknade", query = "SELECT u FROM Ugovor u WHERE u.iznosnaknade = :iznosnaknade")})
public class Ugovor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDUGOVORA")
    private Integer idugovora;
    @Column(name = "DATUMNASTANKA")
    @Temporal(TemporalType.DATE)
    private Date datumnastanka;
    @Column(name = "DATUMISTICANJA")
    @Temporal(TemporalType.DATE)
    private Date datumisticanja;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "IZNOS")
    private Double iznos;
    @Column(name = "IZNOSNAKNADE")
    private Double iznosnaknade;
    @Lob
    @Size(max = 65535)
    @Column(name = "NAPOMENA")
    private String napomena;
    @OneToMany(mappedBy = "idugovora")
    private Collection<Prodavacugovor> prodavacugovorCollection;
    @JoinColumn(name = "IDTIPAUGOVORA", referencedColumnName = "IDTIPAUGOVORA")
    @ManyToOne
    private Tipugovora idtipaugovora;
    @JoinColumn(name = "IDTIPANAKNADE", referencedColumnName = "IDTIPANAKNADE")
    @ManyToOne
    private Tipnaknade idtipanaknade;
    @OneToMany(mappedBy = "idugovora")
    private Collection<Kupacugovor> kupacugovorCollection;
    @OneToMany(mappedBy = "idugovora")
    private Collection<Nepokretnost> nepokretnostCollection;

    public Ugovor() {
    }

    public Ugovor(Integer idugovora) {
        this.idugovora = idugovora;
    }

    public Integer getIdugovora() {
        return idugovora;
    }

    public void setIdugovora(Integer idugovora) {
        this.idugovora = idugovora;
    }

    public Date getDatumnastanka() {
        return datumnastanka;
    }

    public void setDatumnastanka(Date datumnastanka) {
        this.datumnastanka = datumnastanka;
    }

    public Date getDatumisticanja() {
        return datumisticanja;
    }

    public void setDatumisticanja(Date datumisticanja) {
        this.datumisticanja = datumisticanja;
    }

    public Double getIznos() {
        return iznos;
    }

    public void setIznos(Double iznos) {
        this.iznos = iznos;
    }

    public Double getIznosnaknade() {
        return iznosnaknade;
    }

    public void setIznosnaknade(Double iznosnaknade) {
        this.iznosnaknade = iznosnaknade;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    @XmlTransient
    public Collection<Prodavacugovor> getProdavacugovorCollection() {
        return prodavacugovorCollection;
    }

    public void setProdavacugovorCollection(Collection<Prodavacugovor> prodavacugovorCollection) {
        this.prodavacugovorCollection = prodavacugovorCollection;
    }

    public Tipugovora getIdtipaugovora() {
        return idtipaugovora;
    }

    public void setIdtipaugovora(Tipugovora idtipaugovora) {
        this.idtipaugovora = idtipaugovora;
    }

    public Tipnaknade getIdtipanaknade() {
        return idtipanaknade;
    }

    public void setIdtipanaknade(Tipnaknade idtipanaknade) {
        this.idtipanaknade = idtipanaknade;
    }

    @XmlTransient
    public Collection<Kupacugovor> getKupacugovorCollection() {
        return kupacugovorCollection;
    }

    public void setKupacugovorCollection(Collection<Kupacugovor> kupacugovorCollection) {
        this.kupacugovorCollection = kupacugovorCollection;
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
        hash += (idugovora != null ? idugovora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ugovor)) {
            return false;
        }
        Ugovor other = (Ugovor) object;
        if ((this.idugovora == null && other.idugovora != null) || (this.idugovora != null && !this.idugovora.equals(other.idugovora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Ugovor[ idugovora=" + idugovora + " ]";
    }
    
}

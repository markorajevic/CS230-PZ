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
@Table(name = "nepokretnost")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nepokretnost.findAll", query = "SELECT n FROM Nepokretnost n")
    , @NamedQuery(name = "Nepokretnost.findByIdnepokretnosti", query = "SELECT n FROM Nepokretnost n WHERE n.idnepokretnosti = :idnepokretnosti")
    , @NamedQuery(name = "Nepokretnost.findByCena", query = "SELECT n FROM Nepokretnost n WHERE n.cena = :cena")
    , @NamedQuery(name = "Nepokretnost.findByPovrsina", query = "SELECT n FROM Nepokretnost n WHERE n.povrsina = :povrsina")
    , @NamedQuery(name = "Nepokretnost.findBySprat", query = "SELECT n FROM Nepokretnost n WHERE n.sprat = :sprat")})
public class Nepokretnost implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDNEPOKRETNOSTI")
    private Integer idnepokretnosti;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CENA")
    private Double cena;
    @Column(name = "POVRSINA")
    private Float povrsina;
    @Lob
    @Size(max = 65535)
    @Column(name = "ADRESA")
    private String adresa;
    @Column(name = "SPRAT")
    private Integer sprat;
    @OneToMany(mappedBy = "idnepokretnosti")
    private Collection<Fotografija> fotografijaCollection;
    @OneToMany(mappedBy = "idnepokretnosti")
    private Collection<Dodatno> dodatnoCollection;
    @OneToMany(mappedBy = "idnepokretnosti")
    private Collection<Interesovanje> interesovanjeCollection;
    @OneToMany(mappedBy = "idnepokretnosti")
    private Collection<Vlasniknepokretnost> vlasniknepokretnostCollection;
    @JoinColumn(name = "IDUGOVORA", referencedColumnName = "IDUGOVORA")
    @ManyToOne
    private Ugovor idugovora;
    @JoinColumn(name = "IDMESTA", referencedColumnName = "IDMESTA")
    @ManyToOne
    private Mesto idmesta;
    @JoinColumn(name = "IDTIPANEPOKRETNOSTI", referencedColumnName = "IDTIPANEPOKRETNOSTI")
    @ManyToOne
    private Tipnepokretnosti idtipanepokretnosti;

    public Nepokretnost() {
    }

    public Nepokretnost(Integer idnepokretnosti) {
        this.idnepokretnosti = idnepokretnosti;
    }

    public Integer getIdnepokretnosti() {
        return idnepokretnosti;
    }

    public void setIdnepokretnosti(Integer idnepokretnosti) {
        this.idnepokretnosti = idnepokretnosti;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Float getPovrsina() {
        return povrsina;
    }

    public void setPovrsina(Float povrsina) {
        this.povrsina = povrsina;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Integer getSprat() {
        return sprat;
    }

    public void setSprat(Integer sprat) {
        this.sprat = sprat;
    }

    @XmlTransient
    public Collection<Fotografija> getFotografijaCollection() {
        return fotografijaCollection;
    }

    public void setFotografijaCollection(Collection<Fotografija> fotografijaCollection) {
        this.fotografijaCollection = fotografijaCollection;
    }

    @XmlTransient
    public Collection<Dodatno> getDodatnoCollection() {
        return dodatnoCollection;
    }

    public void setDodatnoCollection(Collection<Dodatno> dodatnoCollection) {
        this.dodatnoCollection = dodatnoCollection;
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

    public Ugovor getIdugovora() {
        return idugovora;
    }

    public void setIdugovora(Ugovor idugovora) {
        this.idugovora = idugovora;
    }

    public Mesto getIdmesta() {
        return idmesta;
    }

    public void setIdmesta(Mesto idmesta) {
        this.idmesta = idmesta;
    }

    public Tipnepokretnosti getIdtipanepokretnosti() {
        return idtipanepokretnosti;
    }

    public void setIdtipanepokretnosti(Tipnepokretnosti idtipanepokretnosti) {
        this.idtipanepokretnosti = idtipanepokretnosti;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnepokretnosti != null ? idnepokretnosti.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nepokretnost)) {
            return false;
        }
        Nepokretnost other = (Nepokretnost) object;
        if ((this.idnepokretnosti == null && other.idnepokretnosti != null) || (this.idnepokretnosti != null && !this.idnepokretnosti.equals(other.idnepokretnosti))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Nepokretnost[ idnepokretnosti=" + idnepokretnosti + " ]";
    }
    
}

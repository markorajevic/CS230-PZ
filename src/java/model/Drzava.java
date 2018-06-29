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
@Table(name = "drzava")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Drzava.findAll", query = "SELECT d FROM Drzava d")
    , @NamedQuery(name = "Drzava.findByIddrzave", query = "SELECT d FROM Drzava d WHERE d.iddrzave = :iddrzave")})
public class Drzava implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDDRZAVE")
    private Integer iddrzave;
    @Lob
    @Size(max = 65535)
    @Column(name = "NAZIVDRZAVE")
    private String nazivdrzave;
    @OneToMany(mappedBy = "iddrzave")
    private Collection<Mesto> mestoCollection;

    public Drzava() {
    }

    public Drzava(Integer iddrzave) {
        this.iddrzave = iddrzave;
    }

    public Integer getIddrzave() {
        return iddrzave;
    }

    public void setIddrzave(Integer iddrzave) {
        this.iddrzave = iddrzave;
    }

    public String getNazivdrzave() {
        return nazivdrzave;
    }

    public void setNazivdrzave(String nazivdrzave) {
        this.nazivdrzave = nazivdrzave;
    }

    @XmlTransient
    public Collection<Mesto> getMestoCollection() {
        return mestoCollection;
    }

    public void setMestoCollection(Collection<Mesto> mestoCollection) {
        this.mestoCollection = mestoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddrzave != null ? iddrzave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Drzava)) {
            return false;
        }
        Drzava other = (Drzava) object;
        if ((this.iddrzave == null && other.iddrzave != null) || (this.iddrzave != null && !this.iddrzave.equals(other.iddrzave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Drzava[ iddrzave=" + iddrzave + " ]";
    }
    
}

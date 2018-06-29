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
@Table(name = "dodatno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dodatno.findAll", query = "SELECT d FROM Dodatno d")
    , @NamedQuery(name = "Dodatno.findByIddodatno", query = "SELECT d FROM Dodatno d WHERE d.iddodatno = :iddodatno")})
public class Dodatno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDDODATNO")
    private Integer iddodatno;
    @JoinColumn(name = "IDNEPOKRETNOSTI", referencedColumnName = "IDNEPOKRETNOSTI")
    @ManyToOne
    private Nepokretnost idnepokretnosti;
    @JoinColumn(name = "IDTIPADODATNOG", referencedColumnName = "IDTIPADODATNOG")
    @ManyToOne
    private Tipdodatnog idtipadodatnog;

    public Dodatno() {
    }

    public Dodatno(Integer iddodatno) {
        this.iddodatno = iddodatno;
    }

    public Integer getIddodatno() {
        return iddodatno;
    }

    public void setIddodatno(Integer iddodatno) {
        this.iddodatno = iddodatno;
    }

    public Nepokretnost getIdnepokretnosti() {
        return idnepokretnosti;
    }

    public void setIdnepokretnosti(Nepokretnost idnepokretnosti) {
        this.idnepokretnosti = idnepokretnosti;
    }

    public Tipdodatnog getIdtipadodatnog() {
        return idtipadodatnog;
    }

    public void setIdtipadodatnog(Tipdodatnog idtipadodatnog) {
        this.idtipadodatnog = idtipadodatnog;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddodatno != null ? iddodatno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dodatno)) {
            return false;
        }
        Dodatno other = (Dodatno) object;
        if ((this.iddodatno == null && other.iddodatno != null) || (this.iddodatno != null && !this.iddodatno.equals(other.iddodatno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Dodatno[ iddodatno=" + iddodatno + " ]";
    }
    
}

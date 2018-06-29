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
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MarkoMB
 */
@Entity
@Table(name = "viewq")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Viewq.findAll", query = "SELECT v FROM Viewq v")
    , @NamedQuery(name = "Viewq.findByIdklijenta", query = "SELECT v FROM Viewq v WHERE v.idklijenta = :idklijenta")})
public class Viewq implements Serializable {

    private static final long serialVersionUID = 1L;
    @Lob
    @Size(max = 65535)
    @Column(name = "IMEKLIJENTA")
    private String imeklijenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDKLIJENTA")
    private int idklijenta;
    @Lob
    @Size(max = 65535)
    @Column(name = "ADRESAKLIJENTA")
    private String adresaklijenta;
    @Lob
    @Size(max = 65535)
    @Column(name = "TELEFONKLIJENTA")
    private String telefonklijenta;
    @Id
    private Long id;

    public Viewq() {
    }

    public String getImeklijenta() {
        return imeklijenta;
    }

    public void setImeklijenta(String imeklijenta) {
        this.imeklijenta = imeklijenta;
    }

    public int getIdklijenta() {
        return idklijenta;
    }

    public void setIdklijenta(int idklijenta) {
        this.idklijenta = idklijenta;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}

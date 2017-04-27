/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.creasig.inspire;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eric
 */
@Entity
@Table(name = "themeiso", catalog = "catalogue", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThemeISO.findAll", query = "SELECT t FROM ThemeISO t")
    , @NamedQuery(name = "ThemeISO.findById", query = "SELECT t FROM ThemeISO t WHERE t.id = :id")
    , @NamedQuery(name = "ThemeISO.findByExemple", query = "SELECT t FROM ThemeISO t WHERE t.exemple = :exemple")
    , @NamedQuery(name = "ThemeISO.findByNom", query = "SELECT t FROM ThemeISO t WHERE t.nom = :nom")})
public class ThemeISO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 255)
    @Column(name = "exemple", length = 255)
    private String exemple;
    @Size(max = 255)
    @Column(name = "nom", length = 255)
    private String nom;

    public ThemeISO() {
    }

    public ThemeISO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExemple() {
        return exemple;
    }

    public void setExemple(String exemple) {
        this.exemple = exemple;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ThemeISO)) {
            return false;
        }
        ThemeISO other = (ThemeISO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.creasig.inspire.ThemeISO[ id=" + id + " ]";
    }
    
}
